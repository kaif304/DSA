package SlidingWindow;
// COMPLETED

import java.util.HashMap;

public class CountGoodSubarrays2537 {
    // Sliding Window - Shrink and Grow
    static long countGood(int[] nums, int k){
        long result = 0, pairs = 0;
        int l = 0, r = 0, n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        while(r < n){
            if(map.containsKey(nums[r])) pairs += map.get(nums[r]);

            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            while(pairs >= k){
                result += n - r;
                map.put(nums[l], map.get(nums[l]) - 1);
                pairs -= map.get(nums[l]);
                l++;
            }
            r++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {3,1,4,3,2,2,4};
        int[] arr2 = {3,1,4,3,2,2,7,11,13,14};

        System.out.println(countGood(arr1, 2));
        System.out.println(countGood(arr2, 2));
    }
}
