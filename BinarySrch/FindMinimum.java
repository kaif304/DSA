package BinarySrch;

public class FindMinimum {
    static int findMinimum(int[] nums){
        int s = 0;
        int e = nums.length-1;
        while(s < e){
            int mid = s + (e-s)/2;
            if(nums[mid] < nums[e]){
                e = mid;
            }
            else{
                s = mid + 1;
            }
        }
        return nums[s];
    }
    // with duplicate elements
    static int findMinimum2(int[] nums){
        int s = 0;
        int e = nums.length-1;
        while(s < e){
            int mid = s + (e-s)/2;

            if (nums[mid] == nums[e]){
                e--;
            }
            else if(nums[mid] < nums[e]){
                e = mid;
            }
            else{
                s = mid + 1;
            }
        }
        return nums[s];
    }
    public static void main(String[] args) {
//        int[] arr = {3,4,1,2};
        int[] arr2 = {1,3,3};

//        System.out.println(findMinimum(arr));
        System.out.println(findMinimum2(arr2));
    }
}
