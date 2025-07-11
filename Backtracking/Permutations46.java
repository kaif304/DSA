package Backtracking;
// COMPLETED

import java.util.ArrayList;
import java.util.List;

public class Permutations46 {
    // Optimal Approach
    static void recursionPermute(int start, int[] arr, List<List<Integer>> result){
        if(start == arr.length){
            List<Integer> permutation = new ArrayList<>();
            for(int val : arr){
                permutation.add(val);
            }
            result.add(permutation);
            return;
        }

        for (int i = start; i < arr.length; i++) {
            swap(arr, i, start);

            recursionPermute(start+1, arr, result);

            swap(arr, i, start);
        }
    }
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void dfs(int[] arr, List<Integer> ds, List<List<Integer>> res, boolean[] vis){
        if(ds.size() == arr.length){
            res.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if(!vis[i]){
                vis[i] = true;
                ds.add(arr[i]);

                dfs(arr, ds, res, vis);

                ds.remove(ds.size()-1);
                vis[i] = false;
            }
        }
    }
    static List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] visited = new boolean[arr.length];

        dfs(arr, ds, result, visited);

        return result;
    }
    static List<List<Integer>> permute2(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();

        recursionPermute(0, arr, result);

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        // Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

        List<List<Integer>> result = permute(arr);
        List<List<Integer>> result2 = permute2(arr);

        for(List<Integer> list : result2){
            System.out.println(list);
        }
    }
}
