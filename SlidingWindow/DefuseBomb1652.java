package SlidingWindow;
// COMPLETED
import java.util.Arrays;

public class DefuseBomb1652 {
    static int windowSum(int[] arr, int l, int r){
        int sum = 0;
        while(l <= r){
            sum += arr[l++];
        }
        return sum;
    }
    static int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];

        if(k == 0) return result;

        int left = 1, right = k;
        if(k < 0){
            left = n - Math.abs(k);
            right = n - 1;
        }

        int sum = windowSum(code, left, right);

        for(int i=0; i<n; i++){
            result[i] = sum;

            sum -= code[left];
            left++;
            left = left % n;

            right++;
            right = right % n;
            sum += code[right];
        }

        return result;
    }
    public static void main(String[] args) {
        int[] code = {5,7,1,4};
        int[] code2 = {2,4,9,3};
        System.out.println(Arrays.toString(decrypt(code, 3)));
        System.out.println(Arrays.toString(decrypt(code2, -2)));
    }
}
