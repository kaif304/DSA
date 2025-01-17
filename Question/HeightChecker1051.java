package Question;
import java.util.Arrays;
public class HeightChecker1051 {
    static int heightChecker(int[] heights) {
        int[] expected = Arrays.copyOfRange(heights,0,heights.length);
        Arrays.sort(expected);

        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if(heights[i] != expected[i]){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,4,2,1,3};
        System.out.println(heightChecker(arr));
    }
}
