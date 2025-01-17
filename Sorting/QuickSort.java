package Sorting;
import java.util.Arrays;
class QuickSort {
    public static void quicksort(int[] arr, int l, int h, int i) {
        if (arr[l] < arr[h]) {
            i++;
        }
        if (arr[l] > arr[h]) {
            int t = arr[i];
            arr[h] = arr[l];
            arr[l] = t;
        }
        quicksort(arr, 0, h - 1, -1);
    }
    public static void main(String[] args) {
        int[] arr = {5,6,4,8,9,5,14,8,62,4};
        quicksort(arr,0, arr.length-1,-1);
        System.out.println(Arrays.toString(arr));
    }
}
