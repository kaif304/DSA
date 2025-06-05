package Backtracking;

import java.util.ArrayList;

public class SubsetsWithTargetSum {
    static void dfs(ArrayList<Integer> subset, int[] arr, int i, int sum, int target){
        if(i >= arr.length){
            if(sum == target) System.out.println(subset);
            return;
        }

        if(sum == target){
            System.out.println(subset);
        }

        subset.add(arr[i]);
        dfs(subset, arr, i+1, sum+arr[i], target);
        subset.remove(subset.size()-1);

        dfs(subset, arr, i+1, sum, target);
    }
    static void subsetsWithTargetSum(int[] arr, int target){
        ArrayList<Integer> subset = new ArrayList<>();

        dfs(subset, arr,0, 0, target);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        subsetsWithTargetSum(arr, 4);
    }
}
