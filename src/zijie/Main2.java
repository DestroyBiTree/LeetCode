package zijie;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int [][] watermelons = new int[n][2];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < 2; j++){
                watermelons[i][j] = in.nextInt();
            }
        }
        System.out.println(maxWater(watermelons));

    }

    public static int maxWater(int[][] nums){
        int [] dp = new int[nums.length];
        dp[0] = nums[0][0];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length && j <= nums[i][1]; j++){
                dp[j] = Math.max(dp[j],dp[i]);
                dp[j] = Math.max(dp[j],nums[j][0]);
            }
            if (i + nums[i][1] + 1 < nums.length){
                dp[i + nums[i][1] + 1] =
                        Math.max(dp[i] + nums[i + nums[i][1] + 1][0], nums[i][1]);
            }
        }
return dp[nums.length - 1];
    }
}
