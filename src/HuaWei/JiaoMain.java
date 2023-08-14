package HuaWei;
import java.util.*;
/*请用Java解决以下问题：
输入为：10000,7,{1.0,2.0,1.0,2.0,2.0,3.0,2.0},2
代表着初始资金M=10000，连续7天的价格分别是1.0,2.0,1.0,2.0,2.0,3.0,2.0，最大交易次数K为2。
第一天1元买入，得10000股,第二天2元卖出得20000元，第三天1元买入,得20000股，第六天卖出得60000元,最终盈利50000元。
请根据输入算出最大输出*/
public class JiaoMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("[,{}\\s]+");
        double M = scanner.nextDouble(); // 初始资金
        int N = scanner.nextInt(); // 天数
        double[] prices = new double[N];
        for (int i = 0; i < N; i++) {
            prices[i] = scanner.nextDouble();
        }
        int K = scanner.nextInt(); // 最大交易次数
        double[][] dp = new double[N][K+1]; // 动态规划数组
        for (int k = 1; k <= K; k++) {
            double maxDiff = -prices[0];
            for (int i = 1; i < N; i++) {
                dp[i][k] = Math.max(dp[i-1][k], maxDiff + prices[i]);
                maxDiff = Math.max(maxDiff, dp[i-1][k-1] - prices[i]);
            }
        }
        System.out.println((int)dp[N-1][K]); // 输出最大利润
    }
}
