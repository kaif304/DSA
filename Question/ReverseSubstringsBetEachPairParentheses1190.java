package Question;
import java.util.Stack;
public class ReverseSubstringsBetEachPairParentheses1190 {
    static void reverse(StringBuilder sb, int s, int e){
        while(s < e){
            char temp = sb.charAt(s);
            sb.setCharAt(s, sb.charAt(e));
            sb.setCharAt(e, temp);
            s++;
            e--;
        }
    }
    static String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> st = new Stack<>();

        int i = 0;
        while (i < sb.length()) {
            if(sb.charAt(i) == '('){
                st.push(i);
                i++;
            }
            else if(sb.charAt(i) == ')'){
                int openingIndex = st.pop();
                reverse(sb, openingIndex+1, i-1);
                sb.deleteCharAt(openingIndex);
                sb.deleteCharAt(i-1);
                i = i-1;
            }
            else{
                i++;
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(reverseParentheses("(u(love)i)"));
        System.out.println(reverseParentheses("(ed(et(oc))el)"));
        System.out.println(reverseParentheses("n(ev(t)((()lfevf))yd)cb()"));
        System.out.println("ndyfvefltvecb");
    }
}
