package Question;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class MaximumSubarraySum3026 {
    static long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Long> valToMinPrefixSum = new HashMap<>();
        long maxSum = Long.MIN_VALUE, prefixSum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (valToMinPrefixSum.getOrDefault(nums[i], Long.MAX_VALUE) > prefixSum) {
                valToMinPrefixSum.put(nums[i], prefixSum);
            }
            prefixSum += nums[i];
            if (valToMinPrefixSum.containsKey(nums[i] + k)) {
                maxSum = Math.max(maxSum, prefixSum - valToMinPrefixSum.get(nums[i] + k));
            }
            if (valToMinPrefixSum.containsKey(nums[i] - k)) {
                maxSum = Math.max(maxSum, prefixSum - valToMinPrefixSum.get(nums[i] - k));
            }
        }
        return maxSum == Long.MIN_VALUE ? 0 : maxSum;
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int[] arr2 = {-1,-2,-3,-4};
        long ans = maximumSubarraySum(arr2, 2);
        System.out.println(ans);
    }
}
