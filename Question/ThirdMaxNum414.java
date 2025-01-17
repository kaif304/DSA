package Question;

import java.util.Arrays;
import java.util.Stack;

public class ThirdMaxNum414 {
    static int thirdMax(int[] nums) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for(int e:nums){
            if(e >= first){
                first = e;
            }
        }
        for(int e:nums){
            if(e >= second && e < first){
                second = e;
            }
        }
        boolean thirdChange = false;
        for(int e:nums){
            if(e >= third && e < second){
                third = e;
                thirdChange = true;
            }
        }
        if(thirdChange){
            return third;
        }
        return first;
    }
    static int thirdMax2(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        Stack<Integer> stack = new Stack<>();

        for(int i=len-1; i>=0; i--){
            if(stack.size() == 3){
                break;
            }
            if(!stack.isEmpty() && nums[i] < stack.peek()){
                stack.push(nums[i]);
            }
            if(stack.isEmpty()){
                stack.push(nums[i]);
            }
        }

        if(stack.size() == 3){
            return stack.peek();
        }
        return nums[len-1];
    }

    public static void main(String[] args) {
        int[] arr = {2,2,3,1};
        int[] arr2 = {1,2,-2147483648};
        System.out.println(thirdMax(arr2));
    }
}
