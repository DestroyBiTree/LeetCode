package medium;

public class FindLength {
/*718 最长重复子数组*/
/*给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。*/
/*dp数组定义为以i为结尾的nums1和以j结尾的nums2的 最长公共后缀 的长度*/
/*递推公式为if (nums1[i] == nums2[j]) {
             dp[i][j] = dp[i - 1][j - 1] + 1;
*/
/*拓展题目：最长公共子序列1143.*/
    public static void main(String[] args) {
        findLengthMe(new int[]{1,2,3,2,8},new int[]{5,6,1,4,7} );
    }

    public static int  findLengthMe(int[] nums1, int[] nums2) {
        int dp [][] = new int[nums1.length + 1][nums2.length + 1];
        int res = 0;
        if(nums1[0] == nums2[0]) {
            dp[0][0] = 1;
        }
        for(int i = 0; i < nums2.length; i++) {
            if(nums1[0] == nums2[i]) {
                dp[0][i] = 1;
                res = 1;
            }
        }
        for(int i = 0; i < nums1.length; i++) {
            if(nums2[0] == nums1[i]) {
                dp[i][0] = 1;
                res = 1;
            }
        }
        for (int i = 1; i < nums1.length; i++) {
            for (int j = 1; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                res = Math.max(dp[i][j], res);
            }
        }
        return res;
    }
}
