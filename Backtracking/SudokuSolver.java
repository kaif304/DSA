package Backtracking;
// COMPLETED

import java.util.Arrays;

public class SudokuSolver {
    static boolean isSafe(char[][] board, int row, int col, char digit){
        // horizontal check
        for (int i = 0; i < 9; i++) {
            if(board[row][i] == digit) return false;
        }

        // vertical check
        for (int i = 0; i < 9; i++) {
            if(board[i][col] == digit) return false;
        }

        // 3 x 3 grid check
        int startingRow = (row / 3) * 3;
        int startingCol = (col / 3) * 3;

        for (int i = startingRow; i < startingRow + 3; i++) {
            for (int j = startingCol; j < startingCol + 3; j++) {
                if(board[i][j] == digit) return false;
            }
        }

        return true;
    }
    static boolean helper(char[][] board, int row, int col){
        if (row == 9) return true;

        int nextRow = row, nextCol = col + 1;

        if(nextCol == 9){
            nextRow = row + 1; nextCol = 0;
        }

        if(board[row][col] != '.'){
            return helper(board, nextRow, nextCol);
        }

        // place digits
        for(char digit = '1'; digit <= '9'; digit++){
            if(isSafe(board, row, col, digit)){
                board[row][col] = digit;

                if(helper(board, nextRow, nextCol)){
                    return true;
                }

                board[row][col] = '.';
            }
        }

        return false;
    }
    static void solveSudoku(char[][] board) {
        System.out.println("Sudoku solved: " + helper(board, 0,0));
    }

    static void sudokuSolveKar(String[][] b){
        // char board
        char[][] board = new char[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = b[i][j].charAt(0);
            }
        }
        
        solveSudoku(board);

        for(char[] arr:board){
            System.out.println(Arrays.toString(arr));
        }
    }
    public static void main(String[] args) {
        String[][] board = {
                {"5","3",".",".","7",".",".",".","."},
                {"6",".",".","1","9","5",".",".","."},
                {".","9","8",".",".",".",".","6","."},
                {"8",".",".",".","6",".",".",".","3"},
                {"4",".",".","8",".","3",".",".","1"},
                {"7",".",".",".","2",".",".",".","6"},
                {".","6",".",".",".",".","2","8","."},
                {".",".",".","4","1","9",".",".","5"},
                {".",".",".",".","8",".",".","7","9"}};

        sudokuSolveKar(board);
    }
}
