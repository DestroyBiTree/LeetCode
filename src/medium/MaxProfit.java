package medium;
//309. 最佳买卖股票时机含冷冻期
public class MaxProfit {
    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int[] prices = new int[]{3,2,6,5,0,3};
        System.out.println(maxProfit.maxProfitMe3(prices));

    }

    public int maxProfitMe(int[] prices){
        int dp[][] = new int[prices.length][4];
        //dp[i][j]代表第i天j状态剩余的钱
        /*j = 0代表持有状态
          j = 1代表保持卖的状态（可以买的状态）
          j = 2代表具体卖的状态
          j = 3代表处于冷冻期
        */
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        dp[0][3] = 0;


        for (int i = 1; i < prices.length; i++){

            dp[i][0] = Math.max(Math.max(dp[i - 1][0],dp[i - 1][1] - prices[i]),dp[i - 1][3] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][3],dp[i - 1][1]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][3] = dp[i - 1][2];
//            for (int j = 0; j < 4; j++)
//            System.out.print(dp[i][j] + " ");
//            System.out.println(" ");
        }
        return Math.max(Math.max(dp[prices.length - 1][1],dp[prices.length - 1][2]),dp[prices.length - 1][3]);

    }
    public int maxProfitMe2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];

        // bad case
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], -prices[1]);

        for (int i = 2; i < prices.length; i++) {
            // dp公式
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }

        return dp[prices.length - 1][0];
    }
    public int maxProfitMe3(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        // f[i][0]: 手上持有股票的最大收益
        // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
        int[][] f = new int[n][3];
        f[0][0] = -prices[0];
        for (int i = 1; i < n; ++i) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);
            f[i][1] = f[i - 1][0] + prices[i];
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);
        }
        return Math.max(f[n - 1][1], f[n - 1][2]);
    }

}
