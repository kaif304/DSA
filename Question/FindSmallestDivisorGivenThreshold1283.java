package Question;
import java.util.Arrays;
public class FindSmallestDivisorGivenThreshold1283 {
    static int smallestDivisor(int[] nums, int threshold) {
        Arrays.sort(nums);
        int ans = nums[nums.length-1];
        int s = 0;
        int e = nums.length-1;
        while(s <= e){
            int mid = s + (e-s)/2;

            int d = nums[mid];

            int sum = 0;
            for(int ele:nums){
                sum += (ele + mid - 1) / mid;
            }

            if(sum <= threshold){
                ans =  d;
                e = mid - 1;
            }
            else{
                s = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {44,33,22,11,1};
        System.out.println(smallestDivisor(arr,5));
//        System.out.println((1 + 22 - 1) / 22);
    }
}
