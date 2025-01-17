package Pattern;

public class P2ZeroOne {
    static void print(int n){
        int first = 1;
        for(int r = 0; r < n; r++){
            int second = first;
            for(int c = 0; c <= r; c++){
                System.out.print(second);
                second = (second == 1) ? 0 : 1;
            }
            System.out.println();
            first = (first == 1)? 0 : 1;
        }
    }
    public static void main(String[] args) {
        print(6);
    }
}
