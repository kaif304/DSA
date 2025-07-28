package Backtracking;

public class CountMaxBitwiseORSubsets2044 {
//    static int maxOr = 0;
//    static int count = 0;
//
//    static void helper(int[] arr, int i, int currOr){
//        if(i == arr.length){
//            if(currOr == maxOr) count++;
//            return;
//        }
//
//        helper(arr, i+1, currOr | arr[i]);
//        helper(arr, i+1, currOr);
//    }
    static int helper2(int[] arr, int i, int currOr, int maxOr){
        if(i == arr.length){
            if(currOr == maxOr) return 1;
            return 0;
        }

        return helper2(arr, i+1, currOr | arr[i], maxOr) + helper2(arr, i+1, currOr, maxOr);
    }
    static int countMaxOrSubsets(int[] arr) {
        int maxOr = 0;

        for(int num : arr){
            maxOr |= num;
        }

        return helper2(arr, 0, 0, maxOr);
    }
    public static void main(String[] args) {
        int[] arr = {2,2,2};
        System.out.println(countMaxOrSubsets(arr));
    }
}
