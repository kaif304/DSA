package Backtracking;

public class Print1ToN {
    public static void print1ToN(int i, int N){
        if(i < 1){
            return;
        }
        print1ToN(i-1, N);
        System.out.println(i);
    }
    public static void main(String[] args) {
        print1ToN(10, 10);
    }
}
