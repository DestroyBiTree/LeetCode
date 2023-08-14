package medium;

public class SubarraySum {
    /*560. 和为 K 的子数组*/
    /*暴力解法：设置两个指针end和start，end从0开始向后增加，作为子数组的结尾，start从end的位置开始，向前递减作为子数组的开头，计算start和end中间子数组的和*/
    /*为什么不能用滑动窗口法：因为数组的元素可能会有负数，右指针向右不知道会导致变大还是变小*/
    public static void main(String[] args) {
        SubarraySum subarraySum = new SubarraySum();
        int a [] = new int[]{1, 2, 3};
//        int a [] = new int[]{1,2,1,2,1};
        System.out.println(subarraySum.subarraySumMethod(a, 3));

    }
    public int subarraySumMethod(int[] nums, int k) {
        int n = nums.length, count = 0;
        for (int end = 0; end < n ; end++){
            int sum = 0;
            for (int start = end; start >=0 ; start--) {
                sum += nums[start];

                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
