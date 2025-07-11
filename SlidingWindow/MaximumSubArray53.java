package SlidingWindow;

public class MaximumSubArray53 {
    static int helper(int[] arr, int start){
        if(start >= arr.length) return 0;

        int sum = 0;
        for (int i = start; i < arr.length; i++) {
            sum += arr[i];
            if(sum < 0){
                sum = Math.max(sum, helper(arr, i+1));
                break;
            }
        }

        return sum;
    }
    static int maxSubArray(int[] arr) {
        return helper(arr, 0);
    }
    static int maxSubArray2(int[] arr) {
        int maxSum = Integer.MIN_VALUE, sum = 0;

        for(int val : arr){
            sum += val;
            maxSum = Math.max(maxSum, sum);
            if(sum < 0) sum = 0;
        }

        return maxSum;
    }
    static int maxSubArray3(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            maxSum = Math.max(sum, maxSum);
            if(sum < 0) sum = 0;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4}; // 6
        System.out.println(maxSubArray(arr));
    }
}
