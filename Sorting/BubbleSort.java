package Sorting;

class BubbleSort {
    public static void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[i]){
                    swap(arr,i,j);
                }
            }
        }
    }
    public static void main(String[] args) {
        int [] arr = {2,5,4,6,1,8,2,5};
        bubbleSort(arr);
        for(int e:arr){
            System.out.print(e+" ");
        }
    }
}
