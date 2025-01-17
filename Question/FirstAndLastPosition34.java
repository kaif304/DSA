package Question;

import java.util.Arrays;

public class FirstAndLastPosition34 {
    static int[] searchRange(int[] arr, int target) {
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;

        int s = 0;
        int e = arr.length-1;

        while(s <= e){
            int mid = s + (e-s)/2;

            if(target == arr[mid]){
                ans[0] = mid;
            }
            if(target <= arr[mid]){
                e = mid-1;
            }
            else{
                s = mid+1;
            }
        }
        s = 0;
        e = arr.length-1;
        while(s <= e){
            int mid = s + (e-s)/2;

            if(target == arr[mid]){
                ans[1] = mid;
            }
            if(target >= arr[mid]){
                s = mid+1;
            }
            else{
                e = mid-1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(arr,8)));
    }
}
