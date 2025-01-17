package Question;

public class SumDigitsStringAfterConvert1945 {
    static long sum(long n){
        long sum = 0;
        while(n > 0){
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
    static int getLucky(String s, int k) {
        long num = 0;
        for (int i = 0; i < s.length(); i++) {
            int charNum = s.charAt(i) - 'a' + 1;
            if(charNum < 10){
                num = (num * 10) + (long) charNum;
            }
            else{
                num = (num * 100) + (long) charNum;
            }
        }
        for (int i = 0; i < k; i++) {
            num = sum(num);
        }
        return (int)num;
    }
    public static void main(String[] args) {
//        System.out.println(getLucky("zbax",2));
//        System.out.println(getLucky("iiii",1));
//        System.out.println(getLucky("leetcode",2));
        System.out.println(getLucky("fleyctuuajsr",5));
    }
}
