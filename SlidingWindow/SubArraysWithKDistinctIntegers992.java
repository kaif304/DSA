package SlidingWindow;
// COMPLETED

import java.util.HashMap;

public class SubArraysWithKDistinctIntegers992 {
    static int counter(int[] arr, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0, r = 0, count = 0;

        while(r < arr.length){
            map.put(arr[r], map.getOrDefault(arr[r], 0)+1);

            while(map.size() > k){
                map.put(arr[l] , map.get(arr[l]) - 1);
                if(map.get(arr[l]) == 0){
                    map.remove(arr[l]);
                }
                l++;
            }

            count += r - l + 1;
            r++;
        }

        return count;
    }
    static int subArraysWithKDistinct(int[] arr, int k) {
        // all the sub arrays with <= k distinct elements
        int first = counter(arr, k);

        // all the sub arrays with <= k-1 distinct elements
        int second = counter(arr, k-1);

        return first - second; // sub arrays with == k distinct elements
    }

    public static void main(String[] args) {
        int[] arr = {2,1,1,1,3,4,3,2};
        int[] arr2 = {1,2,1,2,3};

//        System.out.println(subArraysWithKDistinct(arr, 3));
        System.out.println(subArraysWithKDistinct(arr2, 2));
    }
}
