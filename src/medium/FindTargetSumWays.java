package medium;

public class FindTargetSumWays {
    public static void main(String[] args) {
/*13.目标和*/
//        输入：nums = [1,1,1,1,1], target = 3
//        输出：5
//        解释：一共有 5 种方法让最终目标和为 3
/*解题思路：动态规划*/
/*给定数组中nums所有数字的总和为sum。将题目分解为加法的集合left和减法的集合right。则
left + right = sum
又根据题意得
left - right = target
易得
right = sum - left
根据23联立得
left - (sum - left) = target
即
left = (sum + target) / 2;
right =
left的意义为：从整数集合中选出多少种组合，使其和等于left；
*/
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums){
            sum += num;
        }

        int right = sum - target;

        if (right % 2 != 0 || right < 0){
            return 0;
        }
        int neg = right / 2;

        //dp的含义为：从前i个数中选取元素和为j的方案数
        int dp[][] = new int[nums.length + 1][neg + 1];
        dp[0][0] = 1;
        for(int i = 1; i <= nums.length ; i++){
            int num = nums[i - 1];
            for (int j = 0; j <= neg; j++){
                if (num > j){
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i -1][j - num];
                }

            }
        }
        return dp[nums.length][neg];
    }
}
