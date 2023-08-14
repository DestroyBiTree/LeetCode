package medium;

import com.sun.rowset.internal.Row;
/*单词搜索 经典DFS*/
public class WordSearch {
    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(wordSearch.exist(board, word));

    }

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(i, j, word, board, 0, col, row) == true)
                    return true;
            }
        }
        return false;
    }

    public boolean border(int x, int y, int col, int row){
        if (x >= 0 && x < row && y >= 0 && y < col)
            return true;
        else
            return false;

    }

    public boolean dfs(int i, int j, String word,char[][] board,int idx, int col, int row){
        //找到了
        if ((board[i][j] == word.charAt(idx)) && (word.length() - 1 == idx)){
            return true;
        }

        //找不到了
        if (board[i][j] != word.charAt(idx)){
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#';

        //接着搜索
        if (border(i, j - 1, col, row) && dfs(i, j - 1, word, board, idx + 1, col, row)) return true;
        if (border(i, j + 1, col, row) && dfs(i, j + 1, word, board, idx + 1, col, row)) return true;
        if (border(i + 1, j, col, row) && dfs(i + 1, j, word, board, idx + 1, col, row)) return true;
        if (border(i - 1, j, col, row) && dfs(i - 1, j, word, board, idx + 1, col, row)) return true;

        board[i][j] = temp;
        return false;
    }
}
