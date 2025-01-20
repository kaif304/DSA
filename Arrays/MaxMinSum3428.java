package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxMinSum3428 {
    static int dfs(ArrayList<Integer> list, int[] arr, int i, int k){
        if(i == arr.length){
            if(list.size() <= k && !list.isEmpty()){
                int min = Integer.MAX_VALUE;
                int max = -1;
                for (int e : list) {
                    min = Math.min(min, e);
                    max = Math.max(max, e);
                }
                return (min + max) % 1000000007;
            }
            return 0;
        }
        list.add(arr[i]);
        int left = dfs(list, arr, i+1, k);
        list.remove(list.size()-1);
        int right = dfs(list, arr, i+1, k);

        return (left + right) % 1000000007;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int k = 2;
        System.out.println(dfs(new ArrayList<>(),arr,0,k));
//        helper(arr, 2);
    }
}