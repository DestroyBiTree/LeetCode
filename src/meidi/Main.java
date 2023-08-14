package meidi;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        String[] tokerns = input.split(",");
        PriorityQueue<Integer> queue = new PriorityQueue<>(
                (o1, o2) -> o2 - o1
        );
        int n = tokerns.length;
        for (int i = 0; i < n; i++) {
           queue.add(Integer.parseInt(tokerns[i]));
        }
        int x = queue.poll();
        int y = queue.poll();
        System.out.println(x * y);
    }



}
