package RecursionQs;
// COMPLETED

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII40 {
    static void combinations(int[] arr, int idx, int target, List<Integer> ds, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            if(i > idx && arr[i] == arr[i-1]) continue;
            if(arr[i] > target) break;

            ds.add(arr[i]);
            combinations(arr, i+1, target-arr[i], ds, ans);
            ds.remove(ds.size()-1);
        }
    }
    static List<List<Integer>> combinationSum2(int[] candidates, int target){
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(candidates);
        combinations(candidates, 0, target, new ArrayList<>(), ans);

        return ans;
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;

        System.out.println(combinationSum2(candidates, target));
    }
}
