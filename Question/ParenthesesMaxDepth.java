package Question;

import java.util.Stack;

public class ParenthesesMaxDepth {
    static int depth(String s){
//        Stack<Character> st = new Stack<Character>();
        int max = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
//            if(s.charAt(i) == '('){
//                st.push(s.charAt(i));
//                count++;
//            }
//            if(s.charAt(i) == ')'){
//                st.pop();
//                if(count >= max){
//                    max = count;
//                }
//                count -= 1;
//            }
            if (s.charAt(i) == '(') {
                count++;
                max = Math.max(max, count);
            } else if (s.charAt(i) == ')') {
                count--;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(depth("(1+(2*3)+((8)/4))+1"));
    }
}
