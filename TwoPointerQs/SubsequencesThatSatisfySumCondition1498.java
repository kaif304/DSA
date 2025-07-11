package TwoPointerQs;
// COMPLETED

import java.util.Arrays;

public class SubsequencesThatSatisfySumCondition1498 {
    static int numSubseq(int[] arr, int target) {
        Arrays.sort(arr);
        int mod = 1000000007, count = 0, n = arr.length;

        int[] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; i++) {
            power[i] = (power[i - 1] * 2) % mod;
        }

        int left = 0, right = n-1;

        while(left <= right){
            if(arr[left] + arr[right] <= target){
                count = (count + power[right - left]) % mod;
                left++;
            }
            else {
                right--;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,6,7};
        int[] arr2 = {2,3,3,4,6,7};

        System.out.println(numSubseq(arr, 9));
    }
}
