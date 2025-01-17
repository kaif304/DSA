package Question;

public class DivisibleandNondivisibleSumsDifference2894 {
    static int diff(int n, int m){
        int num1 = 0; // all from 1 to n non-divisible by m
        int num2 = 0; // all from 1 to n divisible by m
        for(int i = 1; i <= n; i++){
            if(i % m != 0){
                num1 += i;
            }
            if(i % m == 0){
                num2 += i;
            }
        }
        return num1 - num2;
    }
    public static void main(String[] args) {
        System.out.println(diff(10,3));
    }
}
