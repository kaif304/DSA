package Arrays;
// COMPLETED

import java.util.PriorityQueue;
public class KthLargestElement215 {
    static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);

        for(int ele : nums){
            pq.offer(ele);
        }

        for (int i = 0; i < k; i++) {
            pq.poll();
        }

        return pq.poll();
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;

        System.out.println(findKthLargest(nums, k));
    }
}
