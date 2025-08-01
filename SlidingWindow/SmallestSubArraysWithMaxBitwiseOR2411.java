package SlidingWindow;
// COMPLETED

import java.util.Arrays;

public class SmallestSubArraysWithMaxBitwiseOR2411 {
    // solution - TLE
    static int[] smallestSubarrays2(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int or = arr[i];
            result[i] = 1;
            int maxOr = 0;

            for (int j = i; j < n; j++) {
                or |= arr[j];

                if (or > maxOr) {
                    maxOr = or;
                    result[i] = j - i + 1;
                }
            }
        }

        return result;
    }

    static int[] smallestSubarrays(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];

        int[] lastIndexWithSetBit = new int[31];
        Arrays.fill(lastIndexWithSetBit, -1);

        for (int i = n - 1; i >= 0; i--) {
            int endIndex = i;

            for (int j = 0; j < 31; j++) {
                // if jth bit is not set
                if ((arr[i] & (1 << j)) == 0) {
                    // then find the value with max index which can make it set
                    if (lastIndexWithSetBit[j] != -1) {
                        endIndex = Math.max(endIndex, lastIndexWithSetBit[j]);
                    }
                }
                else {
                    lastIndexWithSetBit[j] = i;
                }
            }

            result[i] = endIndex - i + 1;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 1, 3};
        int[] arr2 = {0};

        System.out.println(Arrays.toString(smallestSubarrays(arr)));
        System.out.println(Arrays.toString(smallestSubarrays(arr2)));
    }
}
