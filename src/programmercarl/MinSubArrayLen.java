package programmercarl;
/*209题，长度最小的子数组*/
/*给定一个含有 n 个正整数的数组和一个正整数 target 。
找出该数组中满足其和 ≥ target 的长度最小的 连续子数组
[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。*/
/*此题的思路为滑动窗口法*/
public class MinSubArrayLen {
    public static void main(String[] args) {
        int [] nums = new int[]{1,2,3,4,5};
        System.out.println(minSubArrayLen(11, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        //结果初始化为最大值
        int res = Integer.MAX_VALUE;
        //左指针
        int i = 0;
        int sum = 0;
        for (int  j = 0; j < n; j++){
            sum += nums[j];
            while (sum >= target){
                res = Math.min(res, j - i + 1);
                sum -= nums[i];
                i++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
    public static int minSubArrayLenMe(int s, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= s) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
