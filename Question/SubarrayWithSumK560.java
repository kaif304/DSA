package Question;

import java.util.HashMap;

public class SubarrayWithSumK560 {
    static int subarraySum(int[] nums, int k){
        int n = nums.length;
        int[] preFix = new int[n];
        preFix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            preFix[i] = nums[i] + preFix[i-1];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if(preFix[i] == k){
                ans++;
            }
            if(map.containsKey(preFix[i] - k)){
                ans += map.get(preFix[i] - k);
            }
            map.put(preFix[i], map.getOrDefault(preFix[i], 0) + 1);
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,1,1,1,1,4,2,3};
        int[] arr2 = {1,2,3};
        int[] arr3 = {1,1,1};
        int[] arr4 = {1,2,1,2,1};
        System.out.println(subarraySum(arr3, 3));
    }
}
