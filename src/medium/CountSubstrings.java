package medium;

public class CountSubstrings {
    public static void main(String[] args) {
/* 647. 回文子串 */
/* 动态规划法 */
    }
    public int countSubstrings(String s) {
        int ans = 0;
        char arr[] = s.toCharArray();
        /*dp[i][j]数组的含义是子数组i到j之间是否是回文序列*/
        boolean dp[][] = new boolean[s.length()][s.length()];
        for(int j = 0; j < s.length(); j++){
            for (int i = 0; i <= j; i++){
                if (arr[i] == arr[j] && (j - i < 2 || dp[i + 1][j - 1])){
                    dp[i][j] = true;
                    ans++;
                }
            }

        }
        return ans;

    }
}
