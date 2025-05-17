package TwoPointerQs;
// COMPLETED

import java.util.Arrays;
public class SortColors75 {
    static void sortColors(int[] arr){
        int low = 0, mid = 0, high = arr.length-1;

        while(mid <= high){
            if(arr[mid] == 2){
                swap(arr, mid, high);
                high--;
            }
            else if(arr[mid] == 0 && low != mid){
                swap(arr, low, mid);
                low++;
            }
            else {
                mid++;
            }
        }
    }
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        int[] arr2 = {1,0,2};

        sortColors(arr);
        sortColors(arr2);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
    }
}
