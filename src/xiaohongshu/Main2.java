package xiaohongshu;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int nums [] = new int[n];
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int j = 0; j < n; j++) {
                nums[j] = scanner.nextInt();
                queue.add(nums[j]);
            }
            Arrays.sort(nums);
            boolean flag = true;
            int [] numTemp = new int[n];
            while (!queue.isEmpty() && flag ) {
                int [] knum = new int[k];
                for (int j = 0; j < k; j++) {
                    knum[i] = queue.poll();
                }

            }


        }
    }
}
