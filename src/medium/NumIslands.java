package medium;


public class NumIslands {
    public static void main(String[] args) {

    }
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int r = 0; r < grid.length; r++){
            for (int c = 0; c < grid[0].length; c++){
                if (grid[r][c] == '1'){
                    dfs(grid, r , c);
                    res++;
                }
            }
        }
        return res;
    }
    public void dfs(char[][] grid, int r, int c){
        if (!border(grid, r, c)){
            return;
        }

        if (grid[r][c] != '1'){
            return;
        }

        grid[r][c] = '2';

        dfs(grid,r,c + 1);
        dfs(grid,r,c - 1);
        dfs(grid,r - 1,c);
        dfs(grid,r + 1,c);
    }

    public boolean border(char[][] grid, int r, int c){
        if (0 <=  r && r < grid.length
                && 0 <= c && c < grid[0].length)
            return true;
        else
            return false;
    }
}

