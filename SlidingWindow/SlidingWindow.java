package SlidingWindow;
// COMPLETED

public class SlidingWindow {
    static int longestOnes(int[] nums, int k){
        int max = 0;
        int left = 0, right = 0, kCnt = 0;

        while(right < nums.length){
            if(nums[right] == 0){
                kCnt++;
            }

            while (kCnt > k){
                if(nums[left] == 0){
                    kCnt--;
                }
                left++;
            }
            max = Math.max(max, (right - left + 1));

            right++;
        }

        return max;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;

        int[] arr2 = {1,1,1,0,0,0,1,1,1,1,0};
        int k2 = 3;

        System.out.println(longestOnes(arr, k));
        System.out.println(longestOnes(arr2, k2));
    }
}
