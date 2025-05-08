package Arrays;
// COMPLETED

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII90 {
    // Most Efficient
    static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), result);
        return result;
    }

    static void dfs(int[] nums, int start, List<Integer> subset, List<List<Integer>> result) {
        result.add(new ArrayList<>(subset));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue; // Handle uniqueness
            subset.add(nums[i]);
            dfs(nums, i + 1, subset, result);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        int[] nums2 = {4,4,4,1,4};
        int[] nums3 = {1,2,2};

        List<List<Integer>> result = subsetsWithDup(nums2);

        for(List<Integer> subset : result){
            System.out.println(subset);
        }
    }
}
