package Hashmap;
// COMPLETED

import java.util.*;

public class DifferenceOfTwoArrs2215 {
    static boolean search(int[] arr, int target){
        int index =  Arrays.binarySearch(arr, target);
        return index >= 0;
    }
    static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();

        ans.add(distinct(nums1, nums2));
        ans.add(distinct(nums2, nums1));

        return ans;
    }
    static List<Integer> distinct(int[] arr1, int[] arr2){
        HashSet<Integer> arr2Map = new HashSet<>();
        for(int e:arr2) arr2Map.add(e);

        List<Integer> difference = new ArrayList<>();
        HashSet<Integer> included = new HashSet<>();

        for(int e:arr1){
            if(!included.contains(e) && !arr2Map.contains(e)){
                difference.add(e);
                included.add(e);
            }
        }

        return difference;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,4,6};
        System.out.println(findDifference(nums1, nums2));
    }
}
