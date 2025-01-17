package Question;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class RowColumnContains1ToN2133 {
    static boolean checkValid(int[][] matrix){
        int n = matrix.length;
        int sum = n * (n + 1) / 2;

        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            int rowSum = 0;
            int colSum = 0;

            for (int j = 0; j < n; j++) {
                if(matrix[i][j] < 1 || matrix[i][j] > n || !rowSet.add(matrix[i][j])){
                    return false;
                }
                rowSum += matrix[i][j];
                if(matrix[j][i] < 1 || matrix[j][i] > n || !colSet.add(matrix[j][i])){
                    return false;
                }
                colSum += matrix[j][i];
            }
            if(rowSum != sum || colSum != sum){
                return false;
            }
        }
        return true;
    }
    static boolean checkValid2(int[][] matrix) {
        for (int r = 0, n = matrix.length; r < n; ++r) {
            Set<Integer> row = new HashSet<>();
            Set<Integer> col = new HashSet<>();
            for (int c = 0; c < n; ++c) {
                if (!row.add(matrix[r][c]) || !col.add(matrix[c][r])) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{3,1,2},{2,3,1}};
        int[][] mat2 = {{1,1,1},{1,2,3},{1,2,3}};
        System.out.println(checkValid2(mat2));
    }
}
