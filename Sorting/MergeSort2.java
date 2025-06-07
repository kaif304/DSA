package Sorting;
import java.util.Arrays;

public class MergeSort2 {
    public static int[] mergeAsSorted(int[] arr1, int[] arr2){
        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;

        while(i < arr1.length && j < arr2.length){
            if(arr1[i] <= arr2[j]) result[k] = arr1[i++];
            else result[k] = arr2[j++];
            k++;
        }
        while(i < arr1.length){
            result[k++] = arr1[i++];
        }
        while(j < arr2.length){
            result[k++] = arr2[j++];
        }

        return result;
    }
    public static int[] mergeSort(int[] arr){
        if(arr.length == 1) return arr;

        int mid = arr.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return mergeAsSorted(left, right);
    }
    public static void main(String[] args) {
        int[] arr = {2,1,3,5,7,4,6};

        int[] sortedArr = mergeSort(arr);

        System.out.println(Arrays.toString(sortedArr));
    }
}
