package Question;
import  java.util.Arrays;

// LeetCode 2971
public class Parameter {
    static long largestParameter(int[] arr){
        long sum = 0;
        Arrays.sort(arr);
        for(int num: arr){
            sum += num;
        }
        int n = arr.length;

        for (int i = n-1; i >= 2 ; i--) {
            sum -= arr[i];
            if(sum > arr[i]){
                return sum + arr[i];
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1,12,1,2,5,50,3};
        long largest  = largestParameter(arr);
        System.out.println(largest);
    }
}