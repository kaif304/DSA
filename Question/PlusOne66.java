package Question;

import java.util.Arrays;

public class PlusOne66 {
    static int[] plusOne(int[] digits) {
        int last = digits.length-1;
        if(digits[last] != 9){
            digits[last] += 1;
            return digits;
        }

        int[] ans = new int[last+2];
        for (int i = digits.length-1; i >= 0; i--) {
            ans[i+1] = digits[i];
        }

        int i = ans.length-1;
        ans[i] = (ans[i]+1)%10;
        while(i > 0 && ans[i] == 0){
            i--;
            ans[i] = (ans[i]+1)%10;
        }

        if(ans[0] == 0){
            return Arrays.copyOfRange(ans,1,ans.length);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {9};
        System.out.println(Arrays.toString(plusOne(arr)));
    }
}
