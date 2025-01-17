package Question;

public class MatrixDiagonalSum1572 {
    static int diagonalSum(int[][] mat) {
        int len = mat.length;
        if(len <= 1){
            return mat[0][0];
        }
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][i] + mat[i][len-i-1];
        }
        if(len % 2 != 0){
            sum -= mat[len/2][len/2];
        }
        return sum;
    }
    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] mat2 = {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
        System.out.println(diagonalSum(mat2));
    }
}
