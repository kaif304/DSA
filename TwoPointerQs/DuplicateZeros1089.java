package TwoPointerQs;
import java.util.Arrays;
import java.util.Stack;

public class DuplicateZeros1089 {
    static void duplicateZeros2(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();

        for(int e : arr){
            if(st.size() == n) {
                System.out.println("reached break statement");
                break;
            }

            st.push(e);
            System.out.println(st);
            System.out.println(st.size());

            if(st.peek() == 0 && st.size() < n) st.push(0);
        }

        System.out.println(st);

        for(int i = n-1; i >= 0; i--){
            arr[i] = st.pop();
        }
    }

    static void duplicateZeros(int[] arr) {
        int n = arr.length;
        int zeros = 0;

        for (int e : arr) {
            if(e == 0) zeros++;
        }

        int l = n-zeros, r = n-1;

        while (l >= 0){
            arr[r] = arr[l];

            if(arr[r] == 0 && l != r) {
                r--;
                arr[r] = 0;
            }

            l--;
            r--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {8,4,5,0,0,7};
        int[] arr2 = {8,0,6,0,4,0,7};
        duplicateZeros(arr);
        duplicateZeros(arr2);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
    }
}
