package meidi;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s =scanner.nextLine();
        String [] strings = s.split(",");
        PriorityQueue<Integer> queue = new PriorityQueue<>(
                (o1, o2) -> o2- o1
        );
        int [] nums = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {

            nums[i] = Integer.parseInt(strings[i]);
            queue.add(nums[i]);
        }
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
        System.out.println("");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
