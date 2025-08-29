package matrix;
// COMPLETED

import java.util.Arrays;

public class DiagonalTraverse498 {
    static int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] result = new int[m * n];
        int index = 0;

        int numberOfDiagonals = m + n - 1;

        for (int d = 0; d < numberOfDiagonals; d++) {
            // if even - going up from left to right diagonally
            if(d % 2 == 0){
                for(int row = Math.min(m-1, d); row >= 0; row--){
                    int col = d - row;
                    if(isValidIndex(row, col, m, n)){
                        result[index++] = mat[row][col];
                    }
                }
            }
            // if odd - going down from right to left diagonally
            else{
                for(int row = 0; row <= Math.min(m-1, d); row++){
                    int col = d - row;
                    if(isValidIndex(row, col, m, n)){
                        result[index++] = mat[row][col];
                    }
                }
            }
        }

        return result;
    }

    static boolean isValidIndex(int row, int col, int m, int n){
        return row < m && row >= 0 && col < n && col >= 0;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] mat2 = {{1}};

        System.out.println(Arrays.toString(findDiagonalOrder(mat)));
        System.out.println(Arrays.toString(findDiagonalOrder(mat2)));
    }
}
