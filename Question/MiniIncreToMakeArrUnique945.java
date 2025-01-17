package Question;
import java.util.Arrays;
public class MiniIncreToMakeArrUnique945 {
    static int minIncrementForUnique(int[] nums) {
        int moves = 0;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] <= nums[i-1]){
                int temp = nums[i];
                nums[i] = nums[i-1] + 1;
                moves += Math.abs(nums[i] - temp);
            }
        }
        return moves;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,2};
        int[] arr2 = {3,2,1,2,1,7};
        System.out.println(minIncrementForUnique(arr2));
    }
}
