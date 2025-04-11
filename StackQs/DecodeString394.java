package StackQs;
// COMPLETED

import java.util.Stack;

public class DecodeString394 {
    // Most optimal
    static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder current = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            }
            else if (ch == '[') {
                countStack.push(k);
                stringStack.push(current);
                current = new StringBuilder();
                k = 0;
            }
            else if (ch == ']') {
                int count = countStack.pop();
                StringBuilder decoded = stringStack.pop();

                while (count-- > 0) {
                    decoded.append(current);
                }
                current = decoded;
            }
            else {
                current.append(ch);
            }
        }

        return current.toString();
    }

    static class Data{
        int digit;
        int substringStartIdx;
        int digitLength;
        public Data(int d, int index, int len){
            this.digit = d;
            this.substringStartIdx = index;
            this.digitLength = len;
        }
    }
    static String decodeString2(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Data> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if( Character.isDigit(s.charAt(i)) ) {
                int digit = 0;
                int len = 0;
                while(Character.isDigit(s.charAt(i))){
                    digit = (digit * 10) + s.charAt(i) - '0';
                    len++;
                    i++;
                }
                stack.push(new Data(digit, i+1, len));
            }
        }

        while(!stack.isEmpty()){
            Data data = stack.pop();
            int times = data.digit;
            int digitLen = data.digitLength;
            int start = data.substringStartIdx;
            int end = sb.indexOf("]", start);

            StringBuilder substring = new StringBuilder();

            for (int i = 0; i < times; i++) {
                substring.append(sb.substring(start, end));
            }

            sb.replace(start-digitLen-1, end+1, substring.toString());
        }

        return sb.toString();
    }

    static String decodeString3(String s) {
        StringBuilder sb = new StringBuilder(s);

        Stack<Integer> timesStack = new Stack<>();
        Stack<Integer> substringStartIdx = new Stack<>();
        Stack<Integer> timesLength = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if( Character.isDigit(s.charAt(i)) ) {
                int digit = 0;
                int len = 0;
                while(Character.isDigit(s.charAt(i))){
                    digit = (digit * 10) + s.charAt(i) - '0';
                    len++;
                    i++;
                }
                timesStack.push(digit);
                substringStartIdx.push(i+1);
                timesLength.push(len);
            }
        }

        while(!timesStack.isEmpty()){
            int times = timesStack.pop();
            int digitLen = timesLength.pop();
            int start = substringStartIdx.pop();
            int end = sb.indexOf("]", start);

            StringBuilder substring = new StringBuilder();

            for (int i = 0; i < times; i++) {
                substring.append(sb.substring(start, end));
            }

            sb.replace(start-digitLen-1, end+1, substring.toString());
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
        System.out.println(decodeString("100[leetcode]"));
    }
}
