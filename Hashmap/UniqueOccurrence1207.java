package Hashmap;
// COMPLETED

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UniqueOccurrence1207 {
    static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int e:arr) {
            freq.put(e, freq.getOrDefault(e, 0) + 1);
        }

        Set<Integer> seen = new HashSet<>();
        for (int count : freq.values()) {
            if (!seen.add(count)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,2,1,1,3};
        int[] arr2 = {-3,0,1,-3,1,1,1,-3,10,0};

        System.out.println(uniqueOccurrences(arr1));
        System.out.println(uniqueOccurrences(arr2));
    }
}
