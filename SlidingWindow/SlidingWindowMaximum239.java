package SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SlidingWindowMaximum239 {
    static int[] maxSlidingWindow(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        ArrayList<Integer> maxList = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            pq.offer(arr[i]);
            map.put(arr[i], map.getOrDefault(arr[i],0) + 1);
        }

        if(!pq.isEmpty()) maxList.add(pq.peek());

        for (int i = k; i < arr.length; i++) {
            pq.remove(arr[i-k]);
            map.put(arr[i-k], map.get(arr[i-k]) - 1);

            map.put(arr[i], map.getOrDefault(arr[i],0) + 1);

            while(!pq.isEmpty() && map.get(pq.peek()) <= 0){
                pq.poll();
            }

            maxList.add(pq.peek());
        }

        int[] max = new int[maxList.size()];
        for (int i = 0; i < max.length; i++) {
            max[i] = maxList.get(i);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] array = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        System.out.println(Arrays.toString(maxSlidingWindow(array, k)));
    }
}
