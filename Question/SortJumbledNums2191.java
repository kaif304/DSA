package Question;

import java.util.Arrays;
import java.util.Comparator;

public class SortJumbledNums2191 {
    static int mappedValue1(int originalVal, int[] mapping) {
        if (originalVal == 0) {
            return mapping[originalVal];
        }
        int mv = 0;
        int factor = 1;
        while (originalVal > 0) {
            int digit = originalVal % 10;
            mv = mv + mapping[digit] * factor;
            factor *= 10;
            originalVal /= 10;
        }
        return mv;
    }

    static int[] sortJumbled1(int[] mapping, int[] nums) {
        int n = nums.length;
        int[][] pairs = new int[n][2]; // Each pair contains the original value and its mapped value

        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i]; // Original value
            pairs[i][1] = mappedValue1(nums[i], mapping); // Mapped value
        }

        // Sort based on the mapped value
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));

        // Extract the sorted original values
        for (int i = 0; i < n; i++) {
            nums[i] = pairs[i][0];
        }

        return nums;
    }
    static int mappedValue(int originalVal, int[] mapping){
        if(originalVal == 0){
            return mapping[originalVal];
        }
        int mv = 0;
        int factor = 1;
        while (originalVal > 0) {
            int digit = originalVal % 10;
            mv = mv + mapping[digit] * factor;
            factor *= 10;
            originalVal /= 10;
        }
        return mv;
    }
    static int[] sortJumbled(int[] mapping, int[] nums) {
        int[] newValues = new int[nums.length];
        for (int i = 0; i < newValues.length; i++) {
            newValues[i] = mappedValue(nums[i], mapping);
        }

        Integer[] index = new Integer[newValues.length];
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }

        Arrays.sort(index, (a,b) -> Integer.compare(newValues[a],newValues[b]));

        System.out.println("original-> "+Arrays.toString(nums));
        System.out.println("new-> "+Arrays.toString(newValues));
        System.out.println("index-> "+Arrays.toString(index));

        int[] numsCopy = Arrays.copyOfRange(nums,0,nums.length);
        for (int i = 0; i < numsCopy.length; i++) {
            numsCopy[i] = nums[index[i]];
        }

        return numsCopy;
    }

    public static void main(String[] args) {
        int[] mapping = {8,9,4,0,2,1,3,5,7,6};
        int[] nums = {991,338,38};

        int[] mapping1 = {0,1,2,3,4,5,6,7,8,9};
        int[] nums1 = {789,456,123};

        int[] mapping2 = {9,8,7,6,5,4,3,2,1,0};
        int[] nums2 = {0,1,2,3,4,5,6,7,8,9};

//        System.out.println(Arrays.toString(sortJumbled(mapping, nums)));
//        System.out.println(Arrays.toString(sortJumbled(mapping1, nums1)));
        System.out.println("ans-> "+Arrays.toString(sortJumbled1(mapping2, nums2)));
    }
}
