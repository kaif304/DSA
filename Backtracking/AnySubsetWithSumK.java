package Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AnySubsetWithSumK {
    static int count(int[] arr, int i, int sum, int k){
        if(i >= arr.length){
            return (sum == k) ? 1 : 0;
        }

        return    count(arr, i+1, sum + arr[i], k)
                + count(arr, i+1, sum, k);
    }
    // count with Memoization
    static int count2(int[] arr, int i, int sum, int k, Map<String, Integer> memo){
        if(i >= arr.length){
            return (sum == k) ? 1 : 0;
        }

        String key = i + "," + sum;
        if(memo.containsKey(key)) return memo.get(key);

        int include = count2(arr, i+1, sum + arr[i], k, memo);
        int exclude = count2(arr, i+1, sum, k, memo);

        memo.put(key, include + exclude);
        return memo.get(key);
    }

    static int countSubsetWithSumK(int[] arr, int k){
        Map<String, Integer> memo = new HashMap<>();
        return count2(arr, 0, 0, k, memo);
    }
    static boolean dfs(int[] arr, ArrayList<Integer> subset, int i, int sum, int k){
        if(i >= arr.length){
            if(sum == k){
                System.out.println(subset);
                return true;
            }
            return false;
        }

        subset.add(arr[i]);
        if(dfs(arr, subset, i+1, sum + arr[i], k)) return true;

        subset.remove(subset.size()-1);
        return dfs(arr, subset, i+1, sum, k);
    }
    static void printAnySubset(int[] arr, int k){
        dfs(arr, new ArrayList<>(), 0, 0, k);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,1};
        int k = 2; // target sum
        printAnySubset(arr, k);
        System.out.println(countSubsetWithSumK(arr,k));
    }
}
