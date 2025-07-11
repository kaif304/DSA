package Contest;
// COMPLETED

import java.util.HashMap;

public class MinimumConsecutiveCardsToPick {
    static int minimumCardPickup(int[] cards) {
        int min = Integer.MAX_VALUE;

        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0;

        while(right < cards.length){
            map.put(cards[right], map.getOrDefault(cards[right], 0) + 1);

            while(map.get(cards[right]) > 1){
                min = Math.min(min, (right - left + 1));

                map.put(cards[left], map.get(cards[left]) - 1);
                left++;
            }

            right++;
        }

        if(min == Integer.MAX_VALUE) return -1;

        return min;
    }
    public static void main(String[] args) {
        int[] cards = {3,4,2,3,4,7};

        System.out.println(minimumCardPickup(cards));
    }
}
