package TwoPointerQs;
// COMPLETED
public class ArrayConcatination2562 {
    static long findTheArrayConcVal(int[] nums) {
        long cv = 0; // concatenation value
        int l = 0, r = nums.length-1;

        while(l <= r){
            if(l == r) return cv + nums[l];

            String stringVal = nums[l] + String.valueOf(nums[r]);
            cv += Integer.parseInt(stringVal);

            l++; r--;
        }

        return cv;
    }

    public static void main(String[] args) {
        int[] arr = {7,52,2,4};
        int[] arr2 = {5,14,13,8,12};
        System.out.println(findTheArrayConcVal(arr));
        System.out.println(findTheArrayConcVal(arr2));
    }
}
