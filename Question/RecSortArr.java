package Question;

import java.util.Arrays;

public class RecSortArr {
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static int findSm(int[] arr,int sm, int i){
        if(i == arr.length){
            return sm;
        }
        if(arr[i] < arr[sm]){
            sm = i;
        }
        return findSm(arr, sm, i+1);

    }
    static void sort(int[] arr,int i){
        if(i == arr.length-1){
            return;
        }
        int sm = i+1;
        sm = findSm(arr,sm-1,sm);
        swap(arr, i, sm);

        sort(arr, i+1);
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 2,1,3,3,2,5,4};
        sort(arr,0);
        System.out.println(Arrays.toString(arr));
    }
}
