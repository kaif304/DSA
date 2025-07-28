package StackQs;
// COMPLETED

import java.util.Stack;

public class MaxScoreFromRemovingSubStr1717 {
    static int firstRemoveAB(String s, int x, int y) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int score = 0, n = s.length();

        // remove ab first
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if(!stack.isEmpty()){
                if(stack.peek() == 'a' && ch == 'b'){
                    stack.pop();
                    sb.deleteCharAt(sb.length()-1);
                    score += x;
                }
                else {
                    stack.push(ch);
                    sb.append(ch);
                }
            }
            else {
                stack.push(ch);
                sb.append(ch);
            }
        }

        // now remove ba
        stack.clear();
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);

            if(!stack.isEmpty()){
                if(stack.peek() == 'b' && ch == 'a'){
                    stack.pop();
                    score += y;
                }
                else {
                    stack.push(ch);
                }
            }
            else {
                stack.push(ch);
            }
        }

        return score;
    }

    static int firstRemoveBA(String s, int x, int y) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int score = 0, n = s.length();

        // remove ba first
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if(!stack.isEmpty()){
                if(stack.peek() == 'b' && ch == 'a'){
                    stack.pop();
                    sb.deleteCharAt(sb.length()-1);
                    score += y;
                }
                else {
                    stack.push(ch);
                    sb.append(ch);
                }
            }
            else {
                stack.push(ch);
                sb.append(ch);
            }
        }

        // now remove ab
        stack.clear();
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);

            if(!stack.isEmpty()){
                if(stack.peek() == 'a' && ch == 'b'){
                    stack.pop();
                    score += x;
                }
                else {
                    stack.push(ch);
                }
            }
            else {
                stack.push(ch);
            }
        }

        return score;
    }
    static int maximumGain(String s, int x, int y) {
        if(x > y){
            return firstRemoveAB(s, x, y);
        }

        return firstRemoveBA(s, x, y);
    }

    public static void main(String[] args) {
        System.out.println(maximumGain("cdbcbbaaabab", 4, 5));
        System.out.println(maximumGain("aabbaaxybbaabb", 5, 4));
    }
}
