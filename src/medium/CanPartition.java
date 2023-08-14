package medium;
/*416.分割等和子集*/
/*简化：首先集合中的数必须是偶数，只要集合有的元素加起来等于总数的一半就可以*/
public class CanPartition {
    public static void main(String[] args) {

    }
    public boolean canPartitionMethod(int[] nums) {
        int sum = 0;
        int target = 0;
        for (int num : nums){
            sum+=num;
        }
        if (sum % 2 != 0){
            return false;
        }
        else {
            target = sum / 2;
        }

        int dp[] = new int[target + 1];
        for (int i = 0; i < nums.length; i++){
            for (int j = target; j >= nums[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }
}
