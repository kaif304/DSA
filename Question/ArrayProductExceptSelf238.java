package Question;

public class ArrayProductExceptSelf238 {
    static void productExceptSelf(int[] nums){
        int[] answer = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            int left = i - 1;
            while(left >= 0){
                if(answer[i-1] == 0) {
                    answer[left] = nums[left];
                }
                else {
                    answer[i] *= nums[left];
                    left--;
                }
            }

            int right = i + 1;
            while(right < nums.length){
                if(answer[i+1] == 0) {
                    answer[right] = nums[right];
                }
                else {
                    answer[i] *= nums[right];
                    right++;
                }
            }
        }

        for(int e:answer){
            System.out.print(e+", ");
        }
    }
    public static void main(String [] args) {
        int[] arr = {1,2,3,4};
        productExceptSelf(arr);
    }
}
