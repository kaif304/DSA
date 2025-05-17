package SlidingWindow;
// COMPLETED

public class SubarrayCntMaxElementAppearsLeastKTimes2962 {
    static long countSubarrays(int[] arr, int k){
        int max = arr[0];
        for(int val : arr) {
            max = Math.max(max, val);
        }

        long result = 0;
        int n = arr.length, l = 0, maxCnt = 0;

        for (int r = 0; r < n; r++) {

            if(arr[r] == max) maxCnt++;

            while(maxCnt >= k){
                if(maxCnt >= k) result += n - r;

                if(arr[l] == max) maxCnt--;

                l++;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,2,3,3};
        int k = 2;
        System.out.println(countSubarrays(arr, k));
    }
}
