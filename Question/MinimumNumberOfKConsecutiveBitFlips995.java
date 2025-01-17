package Question;

import java.util.Arrays;

public class MinimumNumberOfKConsecutiveBitFlips995 {
    static int minKBitFlips(int[] nums, int k) {
        int count = 0;
        int i = 0;
        while(i < nums.length) {
            if(nums[i] == 0){
                count++;
                int temp = -1;
                int j = 0;
                while(j < k && i < nums.length){
                    nums[i] = 1 - nums[i];
                    if(temp < 0 && nums[i] == 0){
                        temp = i;
                    }
                    i++;
                    j++;
                }
                if(temp != -1){
                    i = temp;
                }
                else{
                    i++;
                }
            }
            else{
                i++;
            }
        }
        for(int e:nums){
            System.out.print(e+",");
        }
        System.out.println();
        for(int e:nums){
            if(e == 0){
                return -1;
            }
        }
        return count;
    }
    static int minKBitFlips2(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int flipCount = 0;
        int[] isFlipped = new int[n]; // To keep track of flips

        for (int i = 0; i < n; i++) {
            if (i >= k) {
                flipCount ^= isFlipped[i - k]; // Adjust flipCount based on old flips
            }

            // Check if current bit needs flipping
            if ((nums[i] ^ flipCount) == 0) { // nums[i] ^ flipCount will be 0 if nums[i] needs flipping
                if (i + k > n) { // If there's no room for the flip
                    return -1;
                }
                isFlipped[i] = 1; // Mark this position as flipped
                flipCount ^= 1; // Increment flip count
                count++; // Increment count of flips
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,0,1,0,1,1,0};
        int[] arr2 = {0,1,0};
        System.out.println(minKBitFlips2(arr2,2));
    }
}
