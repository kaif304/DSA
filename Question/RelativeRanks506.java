package Question;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class RelativeRanks506 {
    static String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int e:score){
            pq.add(e);
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        int rank = 1;
        while (!pq.isEmpty()) {
            map.put(pq.poll(), rank++);
        }

        String[] ans = new String[score.length];
        for(int i=0; i<score.length; i++){
            if(map.get(score[i]) == 1){
                ans[i] = "Gold Medal";
            }
            else if(map.get(score[i]) == 2){
                ans[i] = "Silver Medal";
            }
            else if(map.get(score[i]) == 3){
                ans[i] = "Bronze Medal";
            }
            else{
                ans[i] = map.get(score[i])+"";
            }
        }

        return ans;
    }
    static String[] findRelativeRanks2(int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int e:score){
            pq.add(e);
        }

        String[] ans = new String[score.length];
        int rank = 1;
        while (!pq.isEmpty()) {
            int currScore = pq.poll();
            if (rank == 1) {
                ans[scoreIndex(score, currScore)] = "Gold Medal";
            } else if (rank == 2) {
                ans[scoreIndex(score, currScore)] = "Silver Medal";
            } else if (rank == 3) {
                ans[scoreIndex(score, currScore)] = "Bronze Medal";
            } else {
                ans[scoreIndex(score, currScore)] = String.valueOf(rank);
            }
            rank++;
        }
        return ans;
    }
    static int scoreIndex(int[] score, int target) {
        int s = 0;
        int e = score.length-1;
        while(s <= e){
            int mid = s + (e-s)/2;
            if(score[mid] == target){
                return mid;
            }
            if(target < score[mid]){
                e = mid;
            }
            else{
                s = mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {10,3,8,9,4};
        System.out.println(Arrays.toString(findRelativeRanks(arr)));
    }
}
