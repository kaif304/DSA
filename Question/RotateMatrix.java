package Question;

public class RotateMatrix {
    static void rotate(int[][] arr){
        int len = arr.length;
        int k = len-1;
        for(int i=0; i<len; i++){
            for (int j = 0; j < len; j++) {
                int t = arr[i][j];
                arr[i][j] = arr[j][k];
                arr[j][k] = t;
            }
            k--;
        }
    }
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rotate(arr);
        for(int[] each: arr){
            for(int e: each){
                System.out.print(e+" ");
            }
            System.out.println();
        }
    }
}
