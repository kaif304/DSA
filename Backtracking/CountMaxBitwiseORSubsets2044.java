package Backtracking;
// COMPLETED

public class CountMaxBitwiseORSubsets2044 {
    static int helper(int[] arr, int i, int currOr, int maxOr) {
        if (i == arr.length) {
            if (currOr == maxOr) return 1;
            return 0;
        }

        return helper(arr, i + 1, currOr | arr[i], maxOr) + helper(arr, i + 1, currOr, maxOr);
    }

    static int countMaxOrSubsets(int[] arr) {
        int maxOr = 0;

        for (int num : arr) {
            maxOr |= num;
        }

        return helper(arr, 0, 0, maxOr);
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 2};
        System.out.println(countMaxOrSubsets(arr));
    }
}
