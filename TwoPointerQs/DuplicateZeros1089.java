package TwoPointerQs;

import java.util.Arrays;
import java.util.Stack;

public class DuplicateZeros1089 {
    static void duplicateZeros(int[] arr) {
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

        for(int i = n-1; i >= 0; i--){
            arr[i] = st.pop();
        }
    }

    public static void main(String[] args) {
        int[] arr = {8,4,5,0,0,0,0,7};
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }
}
