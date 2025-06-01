package Backtracking;

public class PrintNTo1 {
    public static void printNTo1(int i, int N){
        if(i > N){
            return;
        }

        printNTo1(i+1, N);

        System.out.println(i);
    }

    public static void main(String[] args) {
        printNTo1(1, 10);
    }
}
