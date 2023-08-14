package WeBank;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(removeMinSubarray(nums));


    }
    public static int removeMinSubarray(int[] nums) {
        int n = nums.length;
        int minSum = Integer.MAX_VALUE, secondMinSum = Integer.MAX_VALUE;
        int currSum = 0;

        // 找到最小的和次小的子序列
        for (int i = 0; i < n; i++) {
            currSum += nums[i];
            if (currSum < minSum) {
                secondMinSum = minSum;
                minSum = currSum;
            } else if (currSum < secondMinSum) {
                secondMinSum = currSum;
            }
        }

        // 从原始数组中删除最小和次小的子序列
        int left = 0, right = n - 1;
        int leftSum = 0, rightSum = 0;
        while (nums[left] + leftSum != minSum) {
            leftSum += nums[left];
            left++;
        }
        while (nums[right] + rightSum != secondMinSum) {
            rightSum += nums[right];
            right--;
        }
        int[] remaining = new int[right - left + 1];
        int idx = 0;
        for (int i = left; i <= right; i++) {
            remaining[idx++] = nums[i];
        }

        // 返回处理后数组的总和
        int remainingSum = 0;
        for (int i = 0; i < remaining.length; i++) {
            remainingSum += remaining[i];
        }
        return remainingSum;
    }

}
