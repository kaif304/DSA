package Question;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision735 {
    static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        int i = 0;
        while(i < asteroids.length){
            if(!st.isEmpty()){
                if(st.peek() > 0 && asteroids[i] < 0) {
                    if (Math.abs(st.peek()) == Math.abs(asteroids[i])) {
                        st.pop();
                        i++;
                    } else {
                        if (Math.abs(st.peek()) < Math.abs(asteroids[i])) {
                            st.pop();
                        } else {
                            i++;
                        }
                    }
                }
                else{
                    st.push(asteroids[i]);
                    i++;
                }
            }
            else{
                st.push(asteroids[i]);
                i++;
            }
        }

        int[] ans = new int[st.size()];
        for (int j = ans.length-1; j >= 0; j--) {
            ans[j] = st.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] asteroids = {5,10,-5};
        int[] asteroids2 = {8,-8};
        int[] asteroids3 = {10,2,-5};
        int[] asteroids4 = {-2,-1,1,2};
        System.out.println(Arrays.toString(asteroidCollision(asteroids4)));
    }
}
