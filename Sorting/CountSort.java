package Sorting;

import java.util.Arrays;

public class CountSort {
    static void countSort(int[] arr){
        if(arr == null || arr.length == 1){
            return;
        }
        int max = arr[0];
        for(int e:arr){
            if(e > max){
                max = e;
            }
        }
        int[] countArr = new int[max+1];
        for(int e: arr){
            countArr[e]++;
        }

        int index = 0;
        for(int i = 0; i<max; i++){
            while(countArr[i] > 0){
                arr[index] = i;
                index++;
                countArr[i]--;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {3,1,2,4,2,3,8};
        countSort(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr2 = new int[2];
        System.out.println(Arrays.toString(arr2));
    }
}
