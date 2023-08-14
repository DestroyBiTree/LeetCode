package medium;

import java.util.Arrays;

public class LongestPalindrome {
    /*5.最长回文子串*/
    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindromeMe(s));


    }
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean dp[][] = new boolean[len][len];

        //对数组进行初始化
        for (int i = 0; i < len; i++){
            dp[i][i] = true;
        }

        char[] c = s.toCharArray();
        int max = 1, start = 0;
        //开始遍历数组
        for (int j = 1; j < len; j++){
            for (int i = 0; i < len - 1; i++){
                if (c[j] != c[i]){
                    dp[i][j] = false;
                }
                else {
                    if (j - i < 3){
                        dp[i][j] = true;
                    }
                    else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > max){
                    max = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start,max + start);
    }

    public static String longestPalindromeMe(String s){
        int n = s.length();
        if (n == 1){
            return s;
        }
        char [] charS = s.toCharArray();
        boolean dp [][] = new boolean[n][n];

        for (int i = 0; i < n ;i++){
            dp[i][i] = true;
        }
        String res = s.substring(0,1);
        for (int j = 1; j < n;j++){
            for (int i = 0; i < j - 1; i++){
                if (charS[i] != charS[j]){
                    dp[i][j] = false;
                }
                else {
                    if (j == i) {
                        dp[i][j] = true;
                    }
                    if (j - i <= 2) {
                        dp[i][j] = charS[i] == charS[j];
                    } else {
                        dp[i][j] = (charS[i] == charS[j]) && dp[i + 1][j - 1];
                    }
                    if (dp[i][j] && (j - i + 1) > res.length()) {
                        res = s.substring(i, j - i + 1);
                    }
                }
            }

        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return res;

    }



}
