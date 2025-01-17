package Question;

public class EleDigitSumDiff2535 {
    static int diff(int[] nums){
        int eleSum  = 0;
        int digitSum = 0;
        for(int e: nums){
            eleSum += e;
            while(e > 0){
                digitSum += e % 10;
                e /= 10;
            }
        }
        return Math.abs(eleSum - digitSum);
    }
    public static void main(String[] args) {
        int[] arr = {1,15,6,3};
        System.out.println(diff(arr));
    }
}
