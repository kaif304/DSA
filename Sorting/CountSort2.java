package Sorting;

public class CountSort2 {
    static void countSort(int[] arr){
        if(arr == null || arr.length <= 1) return;

        int max = arr[0];
        for(int num : arr){
            max = Math.max(max, num);
        }

        int[] frequencyArray = new int[max+1];
        for(int num : arr){
            frequencyArray[num]++;
        }

        int index = 0;
        for (int i = 0; i < frequencyArray.length; i++) {
            while(frequencyArray[i] > 0){
                arr[index] = i;
                frequencyArray[i]--;
                index++;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {5,4,6,2,5,5,4,8,1,2};

        countSort(arr);

        for(int num : arr){
            System.out.print(num+" ");
        }
    }
}
