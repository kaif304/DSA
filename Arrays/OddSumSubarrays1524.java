package Arrays;

public class OddSumSubarrays1524 {
    static int oddSumSubArrays(int[] arr){
        int mod = 1000000007;
        int count = 0, preFixSum = 0, even = 1, odd = 0;
        for(int num:arr){
            preFixSum += num;
            System.out.print(preFixSum+" ");
            if(preFixSum % 2 == 0){
                count = (count + odd) % mod;
                even++;
            }
            else{
                count = (count + even) % mod;
                odd++;
            }
        }
        System.out.println();
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(oddSumSubArrays(arr));
    }
}
