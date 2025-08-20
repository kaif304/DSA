package Arrays;
// COMPLETED
// A very nice hard level problem

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class RearrangingFruits2561 {
    static long minCost(int[] basket1, int[] basket2){
        // map which contains extra frequency of all elements
        HashMap<Integer, Integer> map = new HashMap<>();
        int minEle = Integer.MAX_VALUE;

        // start with basket1 - store frequency

        for(int val : basket1){
            map.put(val, map.getOrDefault(val, 0) + 1);
            minEle = Math.min(minEle, val);
        }

        // subtracting + storing basket2 elements

        for(int val : basket2){
            map.put(val, map.getOrDefault(val, 0) - 1);
            minEle = Math.min(minEle, val);
        }

        // absolute value of map is extra frequency of key element

        // list of elements which need swapping
        ArrayList<Integer> finalList = new ArrayList<>();

        for(Integer ele : map.keySet()){
            int cost = ele;
            int count = map.get(ele);

            if(count == 0){
                continue;
            }
            if(count % 2 != 0){
                return -1;
            }

            for (int i = 0; i < Math.abs(count)/2; i++) {
                finalList.add(cost);
            }
        }

        Collections.sort(finalList);

        long result = 0;
        // indirect swap using min element
        for (int i = 0; i < finalList.size()/2; i++) {
            result += Math.min(finalList.get(i), minEle * 2);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] basket1 = {4,2,2,2}, basket2 = {1,4,1,2};

        System.out.println(minCost(basket1, basket2));
    }
}
