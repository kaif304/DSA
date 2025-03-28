package Arrays;

import java.util.Arrays;
import java.util.Stack;

// COMPLETED
public class FinalPrices1475 {
    // Monotonic Stack
    static int[] finalPrices(int[] prices) {
        int[] ans = prices.clone();
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < prices.length; i++){
            while(!st.isEmpty() && prices[st.peek()] >= prices[i]){
                ans[st.pop()] -= prices[i];
            }
            st.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] prices = {8,4,6,2,3};
        System.out.println(Arrays.toString(finalPrices(prices)));
    }
}
