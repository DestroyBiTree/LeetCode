package medium;

/*1143.最长公共子序列*/
/*本题和最长重复子数组的区别在于一个是连续的，一个是不连续的*/
/*dp数组的定义为以i为结尾的nums1和以j为结尾的nums2的最长公共子序列的长度*/
/*当i j相同的时候两个数组一起回退;*/
/*当i j不相同的时候，分别回退一次*/
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        longestCommonSubsequenceMe(new String("abcde"), new String("ace"));
    }
    public static int longestCommonSubsequenceMe(String text1, String text2) {
        int [][] dp = new int[text1.length() + 1][text2.length() + 1];


        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];

    }
}
