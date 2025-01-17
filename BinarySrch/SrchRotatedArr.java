package BinarySrch;

public class SrchRotatedArr {
    static int srchRotatedArr(int[] nums, int target) {
        int s = 0;
        int e = nums.length-1;

        // 4,5,6,1,2,3
        while(s <= e){
            int mid = s + (e-s)/2;
            if(target == nums[mid]){
                return mid;
            }
            if(nums[s] <= nums[mid]){
                if(target >= nums[s] && target <= nums[mid]){
                    if(target == nums[s]){
                        return s;
                    }
                    else{
                        e = mid - 1;
                    }
                }
                else{
                    s = mid + 1;
                }
            }
            if(nums[mid] <= nums[e]){
                if(target >= nums[mid] && target <= nums[e]){
                    s = mid + 1;
                }
                else{
                    e = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {4,5,6,1,2,3};
        System.out.println(srchRotatedArr(arr,5));
    }
}
