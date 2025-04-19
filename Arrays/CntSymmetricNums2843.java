package Arrays;
// COMPLETED

public class CntSymmetricNums2843 {
    static int countSymmetricIntegers(int low, int high) {
        int count = 0;

        for(int i = low; i <= high; i++){
            if(isSymmetric(i)) count++;
        }

        return count;
    }
    static boolean isSymmetric(int n){
        int digits = 0, num = n;
        while(num > 0){
            digits++;
            num /= 10;
        }

        if(digits % 2 != 0) return false;

        int div = (int) Math.pow(10, (double) digits /2);

        int left = n / div, right = n % div;
        int leftSum = 0, rightSum = 0;

        while(left > 0){
            leftSum += left%10;
            left /= 10;
        }
        while(right > 0){
            rightSum += right%10;
            right /= 10;
        }

        return leftSum == rightSum;
    }
    static boolean isSymmetric2(int n){
        String num = String.valueOf(n);

        if(num.length() % 2 != 0) return false;

        int l = 0, r = num.length()-1, leftSum = 0, rightSum = 0;

        while(l < r){
            leftSum += num.charAt(l++) - '0';
            rightSum += num.charAt(r--) - '0';
        }

        return leftSum == rightSum;
    }

    public static void main(String[] args) {
        System.out.println(countSymmetricIntegers(1, 100));
        System.out.println(countSymmetricIntegers(1200, 1230));
    }
}
