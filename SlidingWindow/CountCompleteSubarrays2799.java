package SlidingWindow;
// COMPLETED

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CountCompleteSubarrays2799 {
    static int countCompleteSubarrays(int[] arr){
        Set<Integer> set = new HashSet<>();
        for(int val:arr) set.add(val);

        int distinct = set.size();

        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0, r = 0, count = 0, n = arr.length;

        while(r < n){
            map.put(arr[r], map.getOrDefault(arr[r],0)+1);

            while(map.size() == distinct){
                count += n - r;

                map.put(arr[l], map.get(arr[l]) - 1);

                if(map.get(arr[l]) == 0){
                    map.remove(arr[l]);
                }
                l++;
            }

            r++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,1,2,2};

        System.out.println(countCompleteSubarrays(arr));
    }
}
