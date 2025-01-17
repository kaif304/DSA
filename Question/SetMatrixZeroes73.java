package Question;
import java.util.Arrays;
public class SetMatrixZeroes73 {
    static void setZeroes(int[][] matrix) {
        int[] col = new int[matrix[0].length];
        int[] row = new int[matrix.length];
        Arrays.fill(col,0);
        Arrays.fill(row,0);
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    col[j] = 1;
                    row[i] = 1;
                }
            }
        }
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[i].length; j++){
                if(row[i] == 1 || col[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] arr = {{1,1,1},{1,0,1},{1,1,1}};
        int[][] arr2 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        int[][] arr3 = {{0,1}};
        setZeroes(arr2);
        for(int[] ar: arr2){
            System.out.println(Arrays.toString(ar));
        }
    }
}
