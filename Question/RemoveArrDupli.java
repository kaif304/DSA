package Question;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveArrDupli {
    static int removeDuplicates(int[] nums) {
        int k = 1;
        for(int i=1; i < nums.length; i++){
            if( nums[i] != nums[i-1]){
                nums[k++] = nums[i];
            }
        }
        return k;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,3,3,5,5,6,7};
        System.out.println(removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));
    }
}
