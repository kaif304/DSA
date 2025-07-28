package Backtracking;

import java.util.Arrays;

public class SudokuSolver2 {
    static boolean isSafe(char[][] b, int r, int c, char num){
        for (int i = 0; i < 9; i++) {
            if(b[r][i] == num) return false;
        }
        for (int i = 0; i < 9; i++) {
            if(b[i][c] == num) return false;
        }

        int startingRow = (r / 3) * 3, startingCol = (c / 3) * 3;

        for (int i = startingRow; i < startingRow+3; i++) {
            for (int j = startingCol; j < startingCol+3; j++) {
                if(b[i][j] == num) return false;
            }
        }

        return true;
    }
    static boolean helper(char[][] board){
        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){

                if(board[row][col] == '.'){ // if cell is empty, try to place 1-9
                    for(char num = '1'; num <= '9'; num++){
                        if(isSafe(board, row, col, num)){
                            board[row][col] = num;

                            if(helper(board)) return true;
                            else board[row][col] = '.';

                        }
                    }

                    return false;
                }

            }
        }

        return true;
    }

    static void solveSudoku(char[][] board) {
        System.out.println("Sudoku solved: " + helper(board));
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
