package medium;

public class HouseRobber {

    public int rob(int[] nums) {
       int len = nums.length;
       int dp [] = new int[len + 1];
       dp[0] = 0;
       dp[1] = nums[0];
       for (int i = 2; i <= len; i++){
           dp[i] = Math.max(dp[i - 1],dp[i - 2] + nums[i - 1]);
       }
       return dp[len];

    }
}
