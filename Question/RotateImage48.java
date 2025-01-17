package Question;

public class RotateImage48 {
    // transpose the matrix then reverse every row
    static void rotate(int[][] matrix){
        int n = matrix.length;
        int temp = 0;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int[] arr: matrix){
            reverse(arr);
        }
    }
    static void rotate2(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }
    static void reverse(int[] arr) {
        for (int left = 0, right = arr.length - 1; left < right; left++, right--) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        rotate2(arr);
        for(int[] ar : arr){
            for(int e: ar){
                System.out.print(e+"  ");
            }
            System.out.println();
        }
    }
}