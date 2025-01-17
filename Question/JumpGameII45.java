package Question;

public class JumpGameII45 {
    static int jump2(int[] nums) {
        int jump = 0;
        int n = nums.length;
        if(n == 1){
            return jump;
        }

        int i = 0;
        while (i < n) {
            int max = i+1;
            for (int j = i+1; j <= i+nums[i]; j++) {
                if(nums[j] > nums[max]){
                    max = j;
                    if(max == n-1){
                        jump++;
                        return jump;
                    }
                }
            }
            i = max;
            jump++;
        }
        return jump;
    }
    static int jump(int[] nums) {
        int jump = 0 ;
        int max = 0 ;
        int last = 0;

        for(int i = 0 ; i < nums.length-1 ; i++){
            max = Math.max(max , i + nums[i]);
            if(i == last){
                jump++;
                last = max;
            }
            if(last >= nums.length-1){
                break;
            }
        }
        return jump;
    }
    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4};
        int[] arr2 = {2,3,0,1,4};
        int[] arr3 = {2,3,1,0,2};
        int[] arr4 = {1,2};
        System.out.println(jump(arr));
        System.out.println(jump(arr2));
        System.out.println(jump(arr3));
        System.out.println(jump(arr4));
    }
}
