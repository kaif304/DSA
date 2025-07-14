package Backtracking;
// COMPLETED

import java.util.Arrays;
public class NQueens {
    public static int counter = 0;
    static void solveNQueens(int N){
        char[][] board = new char[N][N];
        for(char[] row : board){
            Arrays.fill(row, '*');
        }

        nQueens(0, board, N);
    }
    static void nQueens(int row, char[][] board, int n){
        if(row == n){
            counter++;
            System.out.println();
            System.out.println(counter);
            for(char[] currRow: board){
                for(char cell : currRow){
                    System.out.print(cell + " ");
                }
                System.out.println();
            }
            return;
        }

        for (int col = 0; col < n; col++) {
            if(isQueenSafe(row, col, board)){
                board[row][col] = 'Q';
                nQueens(row + 1, board, n);
                board[row][col] = '*';
            }
        }
    }

    static boolean isQueenSafe(int row, int col, char[][] board){
        int rowStart = row, colStart = col;

        // upper left diagonal check
        while(row >= 0 && col >= 0){
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        // upper col check
        row = rowStart;
        col = colStart;
        while(row >= 0){
            if(board[row][col] == 'Q') return false;
            row--;
        }

        // upper right diagonal check
        row = rowStart;
        while(col < board.length && row >= 0){
            if(board[row][col] == 'Q') return false;
            row--;
            col++;
        }

        return true;
    }

    public static void main(String[] args) {
        int N = 4;
        solveNQueens(N);
    }
}
