package medium;

import java.util.Arrays;

/*300最长递增子序列*/
public class LengthOfLIS {
    public static void main(String[] args) {

    }

    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        int res = 1;
        Arrays.fill(dp,1);
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < i; j++){
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
                res = Math.max(dp[i],res);

            }
        }
        return res;

    }
}
