package SlidingWindow;
// COMPLETED

public class MaxErasureValue1695 {
    static int maximumUniqueSubarray(int[] arr) {
        int[] valueFrequency = new int[10001]; // 1 <= arr[i] <= 10^4
        int sum = 0, maxSum = 0, n = arr.length;
        int left = 0;

        for (int right : arr) {
            sum += right;
            valueFrequency[right]++;

            while (valueFrequency[right] > 1) {
                sum -= arr[left];
                valueFrequency[arr[left++]]--;
            }

            maxSum = Integer.max(maxSum, sum);

        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {5,2,1,2,5,2,1,2,5};
        System.out.println(maximumUniqueSubarray(arr));
    }
}
