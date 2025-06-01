package Backtracking;

public class FibonacciSeries {
    static int fibonacciNumber(int n){
        if(n <= 1) return n;

        int last = fibonacciNumber(n-1);
        int secondLast = fibonacciNumber(n-2);

        return last + secondLast;
    }
    static void printFibonacciSeries(int n){
        int a = 0, b = 1;

        System.out.print(a+" "+b+" ");

        for (int i = 2; i < n; i++) {
            int c = a + b;

            System.out.print(c + " ");

            a = b;
            b = c;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(fibonacciNumber(n));
        printFibonacciSeries(n);
    }
}
