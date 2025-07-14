package Backtracking;
// COMPLETED

public class NQueensII52 {
    static char[][] getBoard(int size){
        char[][] board = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '.';
            }
        }

        return board;
    }
    static void nQueens(int[] result, char[][] board, int row, int n, boolean[] upperCol, boolean[] leftDiagonal, boolean[] rightDiagonal){
        if(row == n){
            result[0]++;
            return;
        }

        for(int col = 0; col < n; col++){
            if(!upperCol[col] && !leftDiagonal[ n-1+col-row ] && !rightDiagonal[ row+col ]){
                board[row][col] = 'Q';// place Queen in current row
                // mark current position/cell as occupied
                upperCol[col] = true;
                leftDiagonal[n-1+col-row] = true;
                rightDiagonal[row+col] = true;

                nQueens(result, board, row+1, n, upperCol, leftDiagonal, rightDiagonal);

                board[row][col] = '.'; // Displace Queen for future possibilities

                upperCol[col] = false;
                leftDiagonal[n-1+col-row] = false;
                rightDiagonal[row+col] = false;
            }
        }
    }
    static int totalNQueens(int n) {
        int[] result = new int[1];
        char[][] board = getBoard(n);

        boolean[] col = new boolean[n];
        boolean[] leftDiagonal = new boolean[2*n-1];
        boolean[] rightDiagonal = new boolean[2*n-1];

        nQueens(result, board, 0, n, col, leftDiagonal, rightDiagonal);

        return result[0];
    }

    public static void main(String[] args) {
        int N = 4;
        System.out.println(totalNQueens(N));
    }
}
