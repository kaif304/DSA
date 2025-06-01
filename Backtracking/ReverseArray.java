package Backtracking;

import java.util.Arrays;
public class ReverseArray {
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void reverseArray(int[] arr, int left, int right){
        if(left >= right) return;

        // swap current elements at left & right
        swap(arr, left, right);

        reverseArray(arr, left+1, right-1);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        reverseArray(arr, 0, arr.length-1);

        System.out.println(Arrays.toString(arr));
    }
}
