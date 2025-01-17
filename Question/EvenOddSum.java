package Question;
import java.util.Arrays;
import java.util.Scanner;

public class EvenOddSum {
    static int[] sum(int n){
        int even = 0;
        int odd = 0;
        while(n > 0){
            int rem = n % 10;
            if(rem % 2 == 0){
                even += rem;
            }
            else{
                odd += rem;
            }
            n /= 10;
        }
        return new int[]{even, odd};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(Arrays.toString(sum(sc.nextInt())));
    }
}
