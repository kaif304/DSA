package Backtracking;
// COMPLETED

import java.util.ArrayList;
import java.util.List;

public class NQueens51 {
    static List<String> boardToList(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] row : board)
            list.add(new String(row));
        return list;
    }

    static char[][] getBoard(int size){
        char[][] board = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '.';
            }
        }

        return board;
    }
    static void nQueens(List<List<String>> res, char[][] board, int row, int n, boolean[] upperCol, boolean[] leftDiagonal, boolean[] rightDiagonal){
        if(row == n){
            // add new row to result
            res.add(boardToList(board));
            return;
        }

        for(int col = 0; col < n; col++){
            if(!upperCol[col] && !leftDiagonal[ n-1+col-row ] && !rightDiagonal[ row+col ]){
                board[row][col] = 'Q';// place Queen in current row
                // mark current position/cell as occupied
                upperCol[col] = true;
                leftDiagonal[n-1+col-row] = true;
                rightDiagonal[row+col] = true;

                nQueens(res, board, row+1, n, upperCol, leftDiagonal, rightDiagonal);

                board[row][col] = '.'; // Displace Queen for future possibilities

                upperCol[col] = false;
                leftDiagonal[n-1+col-row] = false;
                rightDiagonal[row+col] = false;
            }
        }
    }
    static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = getBoard(n);

        boolean[] col = new boolean[n];
        boolean[] leftDiagonal = new boolean[2*n-1];
        boolean[] rightDiagonal = new boolean[2*n-1];

        nQueens(result, board, 0, n, col, leftDiagonal, rightDiagonal);

        return result;
    }
    public static void main(String[] args) {
        int N = 4;

        System.out.println(solveNQueens(N));
    }
}
