package Backtracking;

public class SumOfFirstN {
    // print method
    public static void makeSum(int N, int sum){
        if(N < 1){
            System.out.println("Sum: "+ sum);
            return;
        }

        makeSum(N-1, sum + N);
    }
    // return method
    public static int makeSum2(int N){
        if(N == 0){
            return 0;
        }

        return N + makeSum2(N-1);
    }

    public static void main(String[] args) {
        int N = 10;

        makeSum(N, 0);
        System.out.println("Sum: "+makeSum2(N));
    }
}
