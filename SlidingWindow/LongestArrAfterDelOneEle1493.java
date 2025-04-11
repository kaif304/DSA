package SlidingWindow;
// COMPLETED

public class LongestArrAfterDelOneEle1493 {
    static int longestSubarray2(int[] arr) {
        int l = 0, r = 0, zeros = 0, ones = 0, max = 0;

        while(r < arr.length && l <= r){
            if(arr[r] == 1){
                ones++;
                r++;
            }
            else if(arr[r] == 0 && zeros == 0){
                r++;
                zeros++;
            }
            else {
                if(arr[l] == 0) zeros--;
                else ones--;
                l++;
            }

            if(zeros == 0){
                max = Math.max(max, ones-1);
            }
            else {
                max = Math.max(max, ones);
            }
        }

        return max;
    }

    static int longestSubarray(int[] arr) {
        int start = 0, zeros = 0, max = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) zeros++;

            while(zeros > 1){
                if(arr[start] == 0) zeros--;
                start++;
            }

            max = Math.max(max, i - start);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,0,1};
        int[] arr1 = {0,1,1,1,0,1,1,0,1};
        int[] arr2 = {1,1,1};

        System.out.println(longestSubarray(arr));
        System.out.println(longestSubarray(arr1));
        System.out.println(longestSubarray(arr2));
    }
}
