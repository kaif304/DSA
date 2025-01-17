package Question;

import java.util.Stack;

public class MakeTheStringGreat1544 {
    static String make(String s){
        if(s.isEmpty()){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        int i = 0;
        while(i < s.length()){
            if(!st.isEmpty() && Math.abs(st.peek() - s.charAt(i)) == 32){
                st.pop();
            } else{
                st.push(s.charAt(i));
            }
            i++;
        }
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        sb.reverse();
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(make("leEeetcode"));
    }
}
