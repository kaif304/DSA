package Hashmap;

import java.util.HashMap;
import java.util.Map;

public class LeastFrequentElement {
    public static void main(String[] args) {
        // Sample array
//        int[] array = {1, 2, 3, 4, 1, 2, 3, 1, 4, 5};
        int[] array = {1, 2, 1, 2, 5};

        // Map to store the frequency of each element
        Map<Integer, Integer> elementCounts = new HashMap<>();

        // Iterate through the array and count the frequency of each element
        for (int element : array) {
            elementCounts.put(element, elementCounts.getOrDefault(element, 0) + 1);
        }

        // Find the element with the least frequency
        int leastFrequentElement = 0; // Default value, assuming elements are positive
        int minCount = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : elementCounts.entrySet()) {
            int count = entry.getValue();
            if (count < minCount) {
                minCount = count;
                leastFrequentElement = entry.getKey();
            }
        }

        // Print the result
        System.out.println("Element with the least frequency: " + leastFrequentElement);
    }
}

