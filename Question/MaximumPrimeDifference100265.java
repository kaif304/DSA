package Question;

public class MaximumPrimeDifference100265 {
    static int findDiff(int[] nums){
        int leftPrime = -1;
        int rightPrime = -1;

        int left = 0;
        int right = nums.length-1;

        while(left <= right && (leftPrime == -1 || rightPrime == -1)){
            if(leftPrime == -1){
                if(primeOrNot(nums[left])){
                    leftPrime = left;
                }
                else{
                    left++;
                }
            }
            if(rightPrime == -1){
                if(primeOrNot(nums[right])){
                    rightPrime = right;
                }else{
                    right--;
                }
            }
        }
        return rightPrime - leftPrime;
    }
    static boolean primeOrNot(int n){
        if (n < 2) {
            return false;
        }
        for(int i = 2; i < n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr = {4,2,9,5,3};
        int[] arr2 = {2,2};
        int[] arr3 = {4,8,2,8};
        System.out.println(findDiff(arr3));
    }
}
