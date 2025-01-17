package Question;

public class FindDuplicateNumber287 {
    static int findDuplicate(int[] nums) {
        int s = 0;
        int e = nums.length-1;

        while(s < nums.length-1){
            if(nums[s] == nums[e]){
                break;
            }
            else if(e == s+1){
                e = nums.length-1;
                s++;
            }
            else if(e > s + 1){
                e--;
            }
        }
        return nums[s];
    }
    public static void main(String[] args) {
        int[] arr1 = {1,3,4,2,2};
        int[] arr2 = {2,2};
        int[] arr3 = {1,2};
        System.out.println(findDuplicate(arr3));
    }
}
