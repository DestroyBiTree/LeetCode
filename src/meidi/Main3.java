package meidi;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        String[] tokerns = input.split(",");
        int n = tokerns.length;
        HashSet<Integer> set = new HashSet<>();
        int [] nums = new int[n];
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(tokerns[i]));
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(
                (o1, o2) -> o2 - o1
        );
        for (Integer num : set) {
            queue.add(num);
        }
        int x = queue.poll();
        int y = queue.poll();
        System.out.println(x * y);

    }

}
