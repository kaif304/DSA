package Question;

public class ValidPerfectSquare367 {
    static boolean isPerfectSquare(int num) {

        if (num < 1){
            return false;
        }
        long left = 1, right = num;
        while (left <= right) {
            long mid = left + (right - left) / 2;

            Object obj = mid;
            System.out.println(obj.getClass().getName());

            long square = mid * mid;
            if (square == num) {
                return true;
            } else if (square < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(2147483647));
    }
}
