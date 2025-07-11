package SlidingWindow;
// COMPLETED

import java.util.Arrays;

public class KRadiusSubarrayAverages2090 {
    static int[] getAverages(int[] arr, int k) {
        if(k == 0) return arr.clone();

        int n = arr.length;
        int[] ans = new int[arr.length];
        Arrays.fill(ans, -1);

        if(2 * k + 1 > n) return ans;

        int left = 0, right = k * 2;
        int windowSize = (2 * k) + 1;
        long windowSum = 0;

        for (int i = left; i <= right && i < n; i++) {
            windowSum += arr[i];
        }

        while(right < n){
            int windowMid = (left + right) / 2;
            ans[windowMid] = (int) windowSum / windowSize;

            windowSum -= arr[left];
            left++;
            right++;
            if(right < n) windowSum += arr[right];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {7,4,3,9,1,8,5,2,6};
        int k = 3;

        int[] result = getAverages(arr, k);
        System.out.println(Arrays.toString(result));
    }
}
