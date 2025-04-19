package Hard;
// TLE - DP needed

public class CountPowerfulNums2999 {
    static long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        int count = 0;

        long startTime = System.currentTimeMillis();

        for(long num = start; num <= finish; num++){
            if(powerful(num, limit, s)) {
                count++;
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Total time: "+(endTime-startTime)+"ms");

        return count;
    }
    static boolean powerful(long n, int limit, String s){
        int substringEnd = s.length()-1;

        while(n > 0){
            long lastDigit = n % 10;

            if(substringEnd >= 0){
                if(lastDigit != s.charAt(substringEnd) - '0') return false;
            }
            if(lastDigit > limit) return false;

            substringEnd--;
            n /= 10;
        }

        return true;
    }
    static boolean powerful2(long n, int limit, String s){
        String num = String.valueOf(n);

        if(!num.endsWith(s)) return false;

        for (int i = 0; i < num.length(); i++) {
            if((num.charAt(i) - '0') > limit) return false;
        }

        return true;
    }
    public static void main(String[] args) {
//        System.out.println(numberOfPowerfulInt(15, 215,6, "10"));
//        System.out.println(numberOfPowerfulInt(1, 6000,4, "124"));

        long start = 1829505, finish = 1255574165;
        int limit = 7;
        String s = "11223";
        System.out.println(numberOfPowerfulInt(start, finish, limit, s));
    }
}
