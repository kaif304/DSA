package Question;

import java.util.Arrays;

public class Sort012 {
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void sort(int[] arr){
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, high);
                high--;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {0,1,2,0,2,0,1,0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
