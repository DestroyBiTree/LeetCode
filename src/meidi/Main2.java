package meidi;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        String[] tokerns = input.split(",");
        int n = tokerns.length;
        int [] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(tokerns[i]);
        }
        int max = maxProduct(nums);
        System.out.println(max);
    }
     public static int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];
                if (product >maxProduct) {
                    maxProduct = product;
                }
            }
        }
        return maxProduct;
    }
}
