package SlidingWindow;
// COMPLETED

public class SubArraysThresholdK1343 {
    static int numOfSubarrays(int[] arr, int k, int threshold) {
        int windowSum = 0, count = 0;

        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        if(windowSum / k >= threshold) count++;

        for (int i = k; i < arr.length; i++) {
            windowSum -= arr[i-k];
            windowSum += arr[i];

            if(windowSum / k >= threshold) count++;
        }

        return count;
    }
    public static void main(String[] args) {
        int[] arr = {2,2,2,2,5,5,5,8};
        int k = 3;
        int threshold = 4;

        System.out.println(numOfSubarrays(arr, k, threshold));
    }
}
