package DP;

public class Fibonacci {
    // Normal recursion function
    static int fibonacciNumber1(int n){
        if(n <= 1) return n;
        return fibonacciNumber1(n-1) + fibonacciNumber1(n-2);
    }

    // Dynamic Programming approach function / Memoization
    static int fibonacciNumber2(int n, int[] dp){
        if(n <= 1) return n;

        if(dp[n] != -1) return dp[n];

        return dp[n] = fibonacciNumber2(n-1,dp) + fibonacciNumber2(n-2,dp);
    }
    // Tabulation
    static int fibonacciNumber3(int n){
        int prev2 = 0, prev = 1;
        for (int i = 2; i <= n; i++) {
            int curr = prev2 + prev;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
    public static void main(String[] args) {
        int n = 10;

        // Using fibonacciNumber1
//        System.out.println(fibonacciNumber1(n));

        // Using fibonacciNumber2

//        int[] dp = new int[n+1];
//        Arrays.fill(dp, -1);
//        System.out.println(fibonacciNumber2(n,dp));
//        System.out.println(Arrays.toString(dp));

        // Using fibonacciNumber3
        System.out.println(fibonacciNumber3(n));
    }
}