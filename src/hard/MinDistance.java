package hard;

import com.sun.org.apache.xerces.internal.util.EntityResolverWrapper;
import com.sun.xml.internal.bind.v2.model.core.ID;

public class MinDistance {
    public static void main(String[] args) {
        System.out.println(minDistanceMe("gabcab", "aef"));
    }
    /*39.编辑距离*/
    /*给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数。
      你可以对一个单词进行如下三种操作：插入一个字符、删除一个字符、替换一个字符*/

    /*解法：动态规划*/
    /*dp[i][j]的定义为以 i - 1 为结尾的word1 变成以 j - 1 为结尾的 word2 最少的操作次数*/
    /*递推公式：*/
    /*当 word[i - 1]和 word2[j - 1] 相同的时候，此时就不考虑这两个元素了，不需要进行任何操作，两个数组各回退一位，即dp[i][j] = dp[i - 1][j - 1]*/
    /*不相同时，删 或者 增（互为逆操作）：
    dp[i - 1][j] + 1 和 dp[i][j - 1] + 1 代表着删除这个元素（即不考虑），操作次数 + 1，可以是word1删除，也可以是word2删除*/
    /*不相同时，替换 ：
    * dp[i - 1][j - 1] + 1 就是两个数组同时不考虑这个元素，替换，所以次数 + 1*/
    /*上面三种情况取最小值*/

    public static int minDistanceMe(String word1, String word2) {
        if (word1.length() == 0 ) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }

        char[] word1c = word1.toCharArray();
        char[] word2c = word2.toCharArray();
        int len1 = word1.length();
        int len2 = word2.length();
        int [][] dp = new int[len1][len2];
        /*初始化*/
        if (word1c[0] != word2c[0]) dp[0][0] = 1;
        /*dp[i][0]表示i - 1结尾的字符串word1和空字符串word2，最近的编辑距离为dp[i][0],即全都删了*/
        for (int i = 1; i < word1.length(); i++) {
            if (word1c[i] == word2c[0]) {
                dp[i][0] = dp[i-1][0];
            } else {
                dp[i][0] = dp[i-1][0] + 1;
            }
        }

        for (int i = 1; i < word2.length(); i++) {
            if (word2c[i] == word1c[0]) {
                dp[0][i] = dp[0][i-1];
            } else {
                dp[0][i] = dp[0][i-1]+1;
            }

        }
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (word1c[i] == word2c[j]){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[len1-1][len2-1];
    }
    public static int minDistanceMe2(String word1, String word2) {
       int dp[][] = new int[word1.length() + 1 ][word2.length() + 1] ;
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= word2.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1],dp[i - 1][j]),dp[i - 1][j - 1]) + 1;
                }
            }
        }

        return dp[word1.length()][word2.length()];


    }

}