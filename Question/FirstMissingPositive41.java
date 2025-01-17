package Question;

import java.util.Arrays;
import java.util.HashMap;

public class FirstMissingPositive41 {
    static int firstMissingPositive(int[] nums) {
        // Algorithm 1
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], nums[i]);
        }
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if(!map.containsKey(i)){
                return i;
            }
        }
        return 0;

        // Algorithm 2
//        Arrays.sort(nums);
//        int ans = 1;
//        int i = 0;
//        while(i < nums.length){
//            if(nums[i] == ans){
//                ans++;
//            }
//            i++;
//        }
//        return ans;
    }
    public static void main(String[] args) {
        int[] arr1 = {3,4,-1,1};
        int[] arr2 = {7,8,9,11,12};
        int[] arr3 = {2,1};
        System.out.println(firstMissingPositive(arr3));
    }
}
