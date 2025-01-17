package Question;
import java.util.ArrayList;
import java.util.List;
public class SpiralMatrix54 {
    static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int left = 0;
        int right = matrix[0].length-1;

        int top = 0;
        int bottom = matrix.length-1;

        while(left < right && top < bottom){
            // go right
            for(int i = left ; i<= right ; i++){
                ans.add(matrix[top][i]);
            }
            top++;

            // go down
            for(int i = top ; i<= bottom ; i++){
                ans.add(matrix[i] [right]);
            }
            right--;

            // go left
            if(top <= bottom){
                for(int i = right ; i >= left ; i--){
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // go up
            if(left <= right){
                for(int i = bottom ; i >= top ; i--){
                    ans.add(matrix[i][left]);
                }
                left++;
            }

        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11 , 12}};
        int[][] matrix3 = {{2,3}};
        System.out.println(spiralOrder(matrix3));
    }
}
