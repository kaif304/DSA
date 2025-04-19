package SlidingWindow;
// COMPLETED

import java.util.HashMap;
public class MaxSumDistinctSubarrOfLenK2461 {
    // Sliding Window - Grow Shrink to maintain uniqueness
    static long maximumSubarraySum(int[] nums, int k) {
        int l = 0, r = 0, n = nums.length;
        long maxSum = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); // store last first index of each element

        int lastOccurrence;

        while(r < n) {
            lastOccurrence = map.getOrDefault(nums[r], -1);

            while(l <= lastOccurrence || r - l + 1 > k){
                sum -= nums[l];
                l++;
            }

            map.put(nums[r], r);
            sum += nums[r];

            if(r - l + 1 == k) maxSum = Math.max(maxSum, sum);

            r++;
        }

        return maxSum;
    }
    public static void main(String[] args) {
        int[] arr = {1,5,4,2,9,9,9};
        System.out.println(maximumSubarraySum(arr, 3));
    }
}
