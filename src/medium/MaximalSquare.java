package medium;

public class MaximalSquare {
    public static void main(String[] args) {
/*221. 最大正方形*/
    }
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int dp[][] = new int[row][col];
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length ==0){
            return maxSide;
        }
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (matrix[i][j] == '1'){
                    if ( i == 0 || j == 0){
                        dp[i][j] = 1;
                    }
                    else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]),dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(dp[i][j], maxSide);

                }
            }
        }
        return maxSide * maxSide;

    }

}
