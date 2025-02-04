package Arrays;
// COMPLETED
public class ArrayIsSortedAndRotated1752 {
    static boolean check(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i=0; i<n; i++){
            if(nums[i] > nums[(i+1)%n]){
                count++;
            }
            if(count > 1) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr = {2,1,3,4};
        int[] arr2 = {1,2,3};
        System.out.println(check(arr));
        System.out.println(check(arr2));
    }
}
