package Arrays;
// COMPLETED

import java.util.*;

public class KLenSubsetWithLargestSum2099 {
    static int[] maxSubsequence(int[] arr, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        for (int i = 0; i < arr.length; i++) {
            heap.add(new int[]{arr[i], i});

            // keep only k largest values
            if(heap.size() > k){
                heap.poll();
            }
        }

        List<int[]> list = new ArrayList<>(heap);
        list.sort(Comparator.comparingInt(a -> a[1]));

        int[] result = new int[list.size()];

        for(int i = 0; i < result.length; i++){
            result[i] = list.get(i)[0];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,3,3};
        int[] arr2 = {-1,-2,3,4};

        System.out.println(Arrays.toString(maxSubsequence(arr, 2)));
        System.out.println(Arrays.toString(maxSubsequence(arr2, 3)));
    }
}
