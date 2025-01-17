package DP;

import java.util.Arrays;

public class ClimbingStairs70 {
    static int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n,dp);
    }
    static int helper(int i,int[] dp){
        if(i == 0){
            return 1;
        }
        if(i == 1){
            return 1;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        return dp[i] = helper(i-1,dp) + helper(i-2,dp);
    }
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(climbStairs(5));
        long end = System.currentTimeMillis();
        System.out.println((end-start)+" ms");
    }
}
