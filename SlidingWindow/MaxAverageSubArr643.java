package SlidingWindow;
// COMPLETED

public class MaxAverageSubArr643 {
    static double findMaxAverage(int[] nums, int k){
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int max = sum;

        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i-k];
            max = Math.max(max, sum);
        }

        System.out.printf("%.5f\n", (double) max / k);

        return (double) max / k;
    }

    public static void main(String[] args) {
        int[] arr = {1,12,-5,-6,50,3};
        int[] arr2 = {-1};
        System.out.println(findMaxAverage(arr, 4));
        System.out.println(findMaxAverage(arr2, 1));
    }
}
