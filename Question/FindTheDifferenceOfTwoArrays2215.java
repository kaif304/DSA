package Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTheDifferenceOfTwoArrays2215 {
    static boolean search(int[] arr, int target){
        int index =  Arrays.binarySearch(arr, target);
        return index >= 0;
    }
    static List<List<Integer>> findDifference(int[] nums1, int[] nums2){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list0 = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();

        for(int e:nums1){
            if(!search(nums2,e) && !list0.contains(e)){
                list0.add(e);
            }
        }
        for(int e:nums2){
            if(!search(nums1,e) && !list1.contains(e)){
                list1.add(e);
            }
        }

        ans.add(list0);
        ans.add(list1);

        return ans;
    }
    public static void main(String[] args) {
        int[] arr1 = {1,2,3};
        int[] arr2 = {2,4,6};

        int[] arr3 = {1,2,3,3};
        int[] arr4 = {1,1,2,2};

        int[] arr5 = {80,5,-20,33,26,29};
        int[] arr6 = {-69,0,-36,52,-84,-34,-67,-100,80};

//        System.out.println(findDifference(arr1, arr2));
//        System.out.println(findDifference(arr3, arr4));
        System.out.println(findDifference(arr5, arr6));
    }
}
