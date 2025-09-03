package Backtracking;
// COMPLETED

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class GenerateParentheses22 {
    static boolean isValid(StringBuilder sb){
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);

            if(!stack.isEmpty()){
                if(stack.peek() == '(' && ch == ')'){
                    stack.pop();
                }
                else{
                    stack.push(ch);
                }
            }
            else{
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }
    static void dfs2(StringBuilder sb, int openCount, int closeCount, int n, List<String> res){
        if(sb.length() == n + n){
            if(isValid(sb)){
                res.add(new String(sb));
            }
            return;
        }

        if(openCount < n){
            sb.append('(');
            dfs2(sb, openCount+1, closeCount, n, res);
            sb.deleteCharAt(sb.length()-1);
        }

        sb.append(')');
        dfs2(sb, openCount, closeCount+1, n, res);
        sb.deleteCharAt(sb.length()-1);
    }

    // Optimized with pruning
    static void dfs(StringBuilder sb, int openCount, int closeCount, int n, List<String> res){
        if(sb.length() == n + n){
            res.add(new String(sb));
            return;
        }

        if(openCount < n){
            sb.append('(');
            dfs(sb, openCount+1, closeCount, n, res);
            sb.deleteCharAt(sb.length()-1);
        }

        if(closeCount < openCount){
            sb.append(')');
            dfs(sb, openCount, closeCount+1, n, res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        dfs(new StringBuilder(), 0, 0, n, result);

        return result;
    }
    public static void main(String[] args) {
        int n = 3; // no. of parentheses pairs
        System.out.println(generateParenthesis(n));

        int n2 = 2; // no. of parentheses pairs
        System.out.println(generateParenthesis(n2));
    }
}
