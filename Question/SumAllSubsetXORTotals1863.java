package Question;

public class SumAllSubsetXORTotals1863 {
    static int subsetXORSum(int[] nums) {
        return helper(nums, 0, 0);
    }

    static int helper(int[] nums, int index, int currentXor) {
        // return currentXor when all elements in nums are already considered
        if (index == nums.length) return currentXor;

        // calculate sum of xor with current element
        int withElement = helper(nums, index + 1, currentXor ^ nums[index]);

        // calculate sum of xor without current element
        int withoutElement = helper(nums, index + 1, currentXor);

        // return sum of xors from recursion
        return withElement + withoutElement;
    }
    public static void main(String[] args) {
        int[] arr = {5,1,6};
        int[] arr2 = {1,3};
        System.out.println(subsetXORSum(arr));
    }
}
