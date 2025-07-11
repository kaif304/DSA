package Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortedSumOfAllSubsets {
    static void dfs(int[] arr, int i, int sum, List<Integer> sumList){
        if(i >= arr.length){
            sumList.add(sum);
            return;
        }

        dfs(arr, i+1, sum + arr[i], sumList);
        dfs(arr, i+1, sum, sumList);
    }
    static List<Integer> subsetSums(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        dfs(arr, 0, 0, ans);
        Collections.sort(ans);

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {3,1,2};
        List<Integer> result = subsetSums(arr);
        System.out.println(result);
    }
}
