package Anli;

import java.util.concurrent.Semaphore;

class PrintThread implements Runnable {
    private String id;
    private Semaphore currentSemaphore;
    private Semaphore nextSemaphore;
    private int count;

    public PrintThread(String id, Semaphore currentSemaphore, Semaphore nextSemaphore, int count) {
        this.id = id;
        this.currentSemaphore = currentSemaphore;
        this.nextSemaphore = nextSemaphore;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            try {
                currentSemaphore.acquire();
                System.out.print(id);
                nextSemaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Semaphore semaphoreA = new Semaphore(1);
        Semaphore semaphoreB = new Semaphore(0);
        Semaphore semaphoreC = new Semaphore(0);
        int count = 10;

        Thread threadA = new Thread(new PrintThread("A", semaphoreA, semaphoreB, count));
        Thread threadB = new Thread(new PrintThread("B", semaphoreB, semaphoreC, count));
        Thread threadC = new Thread(new PrintThread("C", semaphoreC, semaphoreA, count));

        threadA.start();
        threadB.start();
        threadC.start();
    }
}


