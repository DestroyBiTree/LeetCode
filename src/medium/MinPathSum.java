package medium;

import java.util.Arrays;

public class MinPathSum {
    public static void main(String[] args) {
        MinPathSum minPathSum = new MinPathSum();
        System.out.println(minPathSum.minPathSumMethod(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));

    }
    public int minPathSumMethod(int[][] grid){
        int row = grid.length;
        int col = grid[0].length;
//        int dp[][] = new int[row][col];
//        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; i++){
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < col; i++){
            grid[0][i] = grid[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < row; i++){
            for (int j = 1; j < col; j++){
                grid[i][j] = (grid[i - 1][j] < grid[i][j - 1] ? grid[i - 1][j] : grid[i][j - 1]) + grid[i][j];
            }
        }

        return grid[row - 1][col - 1];

    }

}
