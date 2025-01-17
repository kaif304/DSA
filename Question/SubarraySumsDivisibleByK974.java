package Question;
import java.util.HashMap;
public class SubarraySumsDivisibleByK974 {
    static int subarraysDivByK(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int l = i; l <= j; l++) {
                    sum += nums[l];
                }
                if(sum % k == 0){
                    count++;
                }
            }
        }

        return count;
    }
    public static void main(String[] args) {
        int[] arr = {4,5,0,-2,-3,1};
        System.out.println(subarraysDivByK(arr,5));
    }
}
