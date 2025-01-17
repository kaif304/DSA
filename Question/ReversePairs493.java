package Question;
import java.util.Arrays;
public class ReversePairs493 {
    public static int count = 0;

    static int reversePairs(int[] nums){
        helper2(nums);
        return count;
    }
    static void helper2(int[] nums) {
        if(nums.length == 2){
            if(nums[0] > 2 * nums[nums.length-1]){
                count++;
            }
            return;
        }
        if(nums[0] > 2 * nums[nums.length-1]){
            count++;
        }
        helper2(Arrays.copyOfRange(nums, 0, nums.length-1));
        helper2(Arrays.copyOfRange(nums, 1, nums.length));
    }
    static void helper(int[] nums) {
        int s = 0;
        int e = nums.length-1;
        int mid = s + (e-s)/2;

        if(nums.length == 2){
            if(nums[s] > 2 * nums[e]){
                count++;
            }
            return;
        }
        if(nums[s] > 2 * nums[e]){
            count++;
        }
        helper(Arrays.copyOfRange(nums, s, mid+1));
        helper(Arrays.copyOfRange(nums, mid, nums.length));
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,3,1};
        int[] arr2 = {2,4,3,5,1};
        System.out.println(reversePairs(arr2));
    }
}
