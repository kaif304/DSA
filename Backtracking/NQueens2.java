package Backtracking;
// COMPLETED

import java.util.Arrays;
// In this we are placing queens column wise
public class NQueens2 {
    public static int counter = 0;
    static boolean canBePlaced(int row, int col, char[][] board){
        int rowStart = row, colStart = col;

        // upper left diagonal check
        while(row >= 0 && col >= 0){
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        // backward row check
        row = rowStart;
        col = colStart;
        while(col >= 0){
            if(board[row][col] == 'Q') return false;
            col--;
        }

        // lower left diagonal check
        col = colStart;
        while(row < board.length && col >= 0){
            if(board[row][col] == 'Q') return false;
            row++;
            col--;
        }

        return true;
    }
    static void dfs(int col, char[][] board, int n){
        if(col == n){
            counter++;
            System.out.println();
            System.out.println(counter);

            for(char[] row : board){
                for(char cell : row){
                    System.out.print(cell + " ");
                }
                System.out.println();
            }
            return;
        }

        for (int row = 0; row < n; row++) {
            if(canBePlaced(row, col, board)){
                board[row][col] = 'Q';
                dfs(col + 1, board, n);
                board[row][col] = '*';
            }
        }
    }
    static void solveNQueens(int N){
        char[][] board = new char[N][N];
        for(char[] row : board){
            Arrays.fill(row, '*');
        }

        dfs(0, board, N);
    }
    public static void main(String[] args) {
        int N = 8;
        solveNQueens(N);
    }
}
