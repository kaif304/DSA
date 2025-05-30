package SlidingWindow;
// COMPLETED

// Sliding Window - grow & shrink behaviour
public class MinSubArraySum209 {
    static int minSubArrayLen(int target, int[] arr){
        int minLen = Integer.MAX_VALUE;
        int sum = 0, left = 0, right = 0;

        while(right < arr.length){
            sum += arr[right];

            while(sum >= target){
                minLen = Math.min(minLen, (right-left+1));

                sum -= arr[left];
                left++;
            }

            right++;
        }

        if(minLen == Integer.MAX_VALUE) return 0;

        return minLen;
    }
    public static void main(String[] args) {
        int target = 7;
        int[] arr = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(target, arr));
    }
}
