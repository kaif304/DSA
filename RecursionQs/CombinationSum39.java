package RecursionQs;
// COMPLETED

import java.util.List;
import java.util.ArrayList;
public class CombinationSum39 {
    static void combination(int[] arr, int i, List<Integer> list, List<List<Integer>> ans, int target){
        if(i >= arr.length || target == 0){
            if(target == 0) ans.add(new ArrayList<>(list));
            return;
        }

        if(arr[i] <= target){
            list.add(arr[i]);
            combination(arr, i, list, ans, target - arr[i]);
            list.remove(list.size()-1);
        }

        combination(arr, i+1, list, ans, target);
    }
    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        combination(candidates, 0, new ArrayList<>(), ans, target);

        return ans;
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;

        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println(result);
    }
}
