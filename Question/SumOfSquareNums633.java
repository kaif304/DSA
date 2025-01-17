package Question;

public class SumOfSquareNums633 {
    static boolean judgeSquareSum(int c) {
        if(c == 0){
            return true;
        }
        int left = 1;
        int right = c-1;
        while(left <= right){
            int sum = (left*left) + (right*right);
            if(sum == c){
                return true;
            }
            else if(sum > c){
                right -= 1;
            }
            else{
                left += 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(3));
    }
}
