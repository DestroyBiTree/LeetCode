package mhy;

import sun.misc.FpUtils;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int []nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = in.nextInt();
        }

        long [] dp = new long[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++){
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                if (nums[i] % nums[j] == 0){
                    dp[i] += dp[j];
                    dp[i] %= 1000000007;
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < n; i++){
            ans += dp[i];
            ans %= 1000000007;
        }
        System.out.println(ans - n);
    }
}