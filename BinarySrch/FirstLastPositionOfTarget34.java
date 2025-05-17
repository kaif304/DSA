package BinarySrch;

import java.util.Arrays;
public class FirstLastPositionOfTarget34 {
    static int[] searchRange(int[] arr, int target) {
        int[] result = new int[]{-1, -1};

        result[0] = firstOccurrence(arr, target);
        result[1] = lastOccurrence(arr, target);

        return result;
    }
    static int lastOccurrence(int[] arr, int target){
        int l = 0, r = arr.length-1;
        int index = -1;

        while(l <= r){
            int mid = l + (r - l) / 2;

            if(arr[mid] == target){
                index = mid;
                l = mid + 1;
            }
            else if(arr[mid] < target){
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return index;
    }
    static int firstOccurrence(int[] arr, int target){
        int l = 0, r = arr.length-1;
        int index = -1;

        while(l <= r){
            int mid = l + (r - l) / 2;

            if(arr[mid] == target){
                index = mid;
                r = mid - 1;
            }
            else if(arr[mid] < target){
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};

        System.out.println(Arrays.toString(searchRange(arr, 8)));
    }
}
