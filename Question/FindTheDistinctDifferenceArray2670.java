package Question;

import java.util.Arrays;
import java.util.HashSet;
public class FindTheDistinctDifferenceArray2670 {
    static int[] findDiff(int[] nums){
        int[] ans = new int[nums.length];

        HashSet<Integer> uniqueElements = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j <= i; j++) {
                uniqueElements.add(nums[j]);
            }
            int left = uniqueElements.size();
            uniqueElements.clear();

            for (int j = i+1; j < nums.length; j++) {
                uniqueElements.add(nums[j]);
            }
            int right = uniqueElements.size();
            uniqueElements.clear();

            ans[i] = left - right;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {3,2,3,4,2};
        int[] arr2 = {1,2,3,4,5};
        int[] ans = findDiff(arr);
        System.out.println(Arrays.toString(ans));
    }
}
