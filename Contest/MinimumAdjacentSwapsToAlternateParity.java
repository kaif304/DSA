package Contest;
// COMPLETED

public class MinimumAdjacentSwapsToAlternateParity {
    static int swapCount(int[] arr, int state){
        // state = 0 -> put even num at even index
        // state = 1 -> put odd num at even index
        int curr = 0, swaps = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] % 2 == state){
                swaps += Math.abs(i-curr);
                curr += 2;
            }
        }

        return swaps;
    }
    static int minSwaps(int[] arr) {
        int evenCount = 0, oddCount = 0;

        for(int val : arr){
            if(val % 2 == 0) evenCount++;
            else oddCount++;
        }

        if(Math.abs(evenCount - oddCount) > 1) return -1;

        if(evenCount > oddCount) return swapCount(arr, 0);

        else if(oddCount > evenCount) return swapCount(arr, 1);

        else return Math.min(swapCount(arr, 0), swapCount(arr, 1));
    }

    public static void main(String[] args) {
        int[] arr = {2,4,6,5,7};
        int[] arr2 = {1,2,3};
        System.out.println(minSwaps(arr));
        System.out.println(minSwaps(arr2));
    }
}
