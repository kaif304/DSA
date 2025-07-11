package DP;

import java.util.ArrayList;

public class OriginalTypedStringII3333 {
    static int possibleStringCount(String word, int k) {
        int mod = 1000000007;

        ArrayList<Integer> groupList = new ArrayList<>();
        int  groupLength= 1;

        for (int i = 1; i < word.length(); i++) {
            if(word.charAt(i) == word.charAt(i-1)) {
                groupLength++;
            }
            else {
                groupList.add(groupLength);
                groupLength = 1;
            }
        }
        groupList.add(groupLength);
        System.out.println(groupList);

        int totalWays = 1;

        for(int group : groupList){
            totalWays *= group;
        }
        if(groupList.size() > k) return totalWays;
        System.out.println(totalWays);

        int[] prefixSum = new int[k]; // [1, 1, 1, 1, 1, 1]

        for(int groupSize : groupList){
            int[] dp = new int[k];

            for (int length = 1; length < k; length++) {
                dp[length] = prefixSum[length-1];

                if(length - groupSize - 1 >= 0){
                    dp[length] = 0;
                }
            }
        }

        return 0;
    }
    public static void main(String[] args) {

        System.out.println(possibleStringCount("aabbccdd", 7));

    }
}
