package Backtracking;
// COMPLETED

public class WordSearch79 {
    static boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0) && dfs(board,i,j,0,word, new boolean[m][n])){
                    return true;
                }
            }
        }

        return false;
    }
    static boolean dfs(char[][] board, int row, int col, int i, String word, boolean[][] vis){
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length ||
                board[row][col] != word.charAt(i) || vis[row][col]) {
            return false;
        }

        if(i == word.length()-1) return true;

        vis[row][col] = true;

        boolean found = dfs(board, row, col+1, i+1, word, vis) ||
                dfs(board, row, col-1, i+1, word, vis) ||
                dfs(board, row+1, col, i+1, word, vis) ||
                dfs(board, row-1, col, i+1, word, vis);

        vis[row][col] = false;

        return found;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCCED";

        char[][] board2 = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word2 = "ABCB";

        char[][] board3 = {
                {'C','A','A'},
                {'A','A','A'},
                {'B','C','D'}
        };
        String word3 = "AAB";

        System.out.println(exist(board, word));
        System.out.println(exist(board2, word2));
        System.out.println(exist(board3, word3));
    }
}
