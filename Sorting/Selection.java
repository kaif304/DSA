package Sorting;
import java.util.Arrays;
class Selection {
    static void selectionSort(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            int smallest = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j] < arr[smallest]){
                    smallest = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
        }
    }
    public static void main(String[] args) {
        int [] arr = {2,5,4,6,1,8,2,5};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
