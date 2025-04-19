package Arrays;

import java.util.List;
import java.util.ArrayList;

public class SubsetsUsingBitMasking {
    // Most optimized way to generate all subsets of an array
    // TC - O(n * (2^n))
    static List<List<Integer>> allSubsets(int[] arr){
        List<List<Integer>> subsets = new ArrayList<>();
        int n = arr.length;
        int totalSubsets = (1 << n);

        for (int mask = 0; mask < totalSubsets; mask++) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if((mask & (1 << i)) != 0) {
                    subset.add(arr[i]);
                }
            }
            subsets.add(subset);
        }

        return subsets;
    }
    public static void main(String[] args) {
        // User input array - just for practice
//        Scanner sc = new Scanner(System.in);
//
//        int n; // take array size
//        System.out.print("Enter Array size: ");
//        n = sc.nextInt(); // user input - array size
//
//        int[] arr = new int[3];
//        System.out.print("Enter values: ");
//        for (int i = 0; i < n; i++) { // user input - array elements
//            arr[i] = sc.nextInt();
//        }
//        System.out.print("Array: "+ Arrays.toString(arr));

        int[] arr = {1,2,3,4};
        List<List<Integer>> subsets = allSubsets(arr);

        System.out.println("All subsets of array: ");
        for(List<Integer> subset : subsets){
            System.out.println(subset);
        }

        System.out.println((1 << arr.length)+" subsets");
    }
}
