package Arrays;

import java.util.HashMap;

public class TupleWithSameProduct1726 {
    static int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> productCount = new HashMap<>();
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int product = nums[i] * nums[j];
                productCount.put(product, productCount.getOrDefault(product, 0) + 1);
            }
        }

        for (int freq : productCount.values()) {
            if (freq > 1) {
                count += (freq * (freq - 1)) / 2 * 8;  // Combination formula * 8 tuples
            }
        }

        return count;
    }

    public static void main(String[] args) {
//        int[] arr = {2,3,4,6};
//        int[] arr2 = {1,2,4,5,10};
        int[] arr3 = {1,2,4,5,10};
//        System.out.println(tupleSameProduct(arr));
//        System.out.println(tupleSameProduct(arr2));
        System.out.println(tupleSameProduct(arr3));
    }
}
