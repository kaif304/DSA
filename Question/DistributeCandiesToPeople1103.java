package Question;

import java.util.Arrays;

public class DistributeCandiesToPeople1103 {
    static int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int i = 0;
        int n = 0;
        while(candies > 0){
            int currentCandy = n + 1;
            if (candies < currentCandy) {
                currentCandy = candies;
            }
            ans[i] += currentCandy;
            candies -= currentCandy;
            i++;
            if(i == ans.length){
                i = 0;
            }
            n++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = distributeCandies(10,3);
        int[] arr2 = distributeCandies(7,4);
        System.out.println(Arrays.toString(arr2));
    }
}
