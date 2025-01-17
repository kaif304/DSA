package Question;

import java.util.Arrays;

public class RotateArr189 {
    static void rotate(int[] nums, int k) {
        if (nums.length <= 1 || k == 0) {
            return;
        }
        int len = nums.length;
        int rotation = k % len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, rotation - 1);
        reverse(nums, rotation, len - 1);
    }
    static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        rotate(arr,2);
        System.out.println(Arrays.toString(arr));
    }
}
