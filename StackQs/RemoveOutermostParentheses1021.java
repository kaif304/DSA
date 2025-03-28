package StackQs;
// COMPLETED

public class RemoveOutermostParentheses1021 {
    // Better Solution
    static String removeOuterParentheses(String s) {
        int counter = 0;
        StringBuilder result = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (counter > 0) result.append(ch); // Ignore outermost '('
                counter++;
            } else {
                counter--;
                if (counter > 0) result.append(ch); // Ignore outermost ')'
            }
        }

        return result.toString();
    }
    static String removeOuterParentheses2(String s) {
        int counter = 0;
        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder();


        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == '(') {
                temp.append(ch);
                counter++;
            }

            if(ch == ')' && counter > 1){
                temp.append(ch);
                counter--;
            }
            else if(ch == ')' && counter == 1){
                temp.deleteCharAt(0);
                counter--;
            }

            if(counter == 0){
                result.append(temp);
                temp.setLength(0);
            }
        }

        return result.toString();
    }
    public static void main(String[] args) {
        String s = "(()())(())";
        String s2 = "(()())(())(()(()))";
        System.out.println(removeOuterParentheses(s));
        System.out.println(removeOuterParentheses(s2));
    }
}
