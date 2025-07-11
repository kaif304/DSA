package design.pairswithcertainsum;

import java.util.HashMap;

class FindSumPairs {
    int[] arr1;
    int[] arr2;
    HashMap<Integer, Integer> arr2Frequency;

    public FindSumPairs(int[] arr1, int[] arr2) {
        this.arr1 = arr1;
        this.arr2 = arr2;

        this.arr2Frequency = new HashMap<>();
        for(int val : arr2){
            arr2Frequency.put(val, arr2Frequency.getOrDefault(val, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int oldVal = arr2[index];
        int newVal = oldVal + val;

        arr2[index] = newVal;

        // update the frequency of newVal in map
        arr2Frequency.put(newVal, arr2Frequency.get(newVal) + 1);

        // update the frequency of newVal in map
        arr2Frequency.put(oldVal, arr2Frequency.get(oldVal) - 1);
    }

    public int count(int tot) {
        int count = 0;

        for(int arr1Val : arr1){
            int targetValue = tot - arr1Val;

            if(arr2Frequency.containsKey(targetValue)){
                count = count + arr2Frequency.get(targetValue);
            }
        }

        return count;
    }
}
