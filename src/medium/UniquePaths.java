package medium;

public class UniquePaths {
    public static void main(String[] args) {
    UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePathsMethod(3, 3));
    }

    public int uniquePathsMethod(int m, int n) {
        int[][]dp = new int[m][n];
        for (int i = 0; i < n; i ++){
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++){
            dp[i][0] = 1;
        }

        for (int i = 1; i < n; i++){
            for (int j = 1; j < m; j++){
                dp[j][i] = dp[j - 1][i] + dp[j][i - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

}
