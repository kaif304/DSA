package Backtracking;
// COMPLETED

import java.util.List;
import java.util.ArrayList;

public class GenerateBinaryStringsWithoutAdjacentZeros3211 {
    static void helper(StringBuilder p, int countOfOne, int n, List<String> result){
        if(p.length() == n){
            result.add(new String(p));
            return;
        }

        // first we are trying with putting 1
        p.append('1');
        helper(p, countOfOne+1, n, result);
        p.deleteCharAt(p.length()-1);
        // deleting last added one so that 0 can also be placed for its try

        // now trying to put 0 if the previous element is not 0
        if(p.isEmpty() || p.charAt(p.length()-1) != '0'){
            p.append('0');
            helper(p, countOfOne, n, result);
            p.deleteCharAt(p.length()-1);
        }
    }
    static List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();

        helper(new StringBuilder(), 0, n, result);

        return result;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(validStrings(n)); // Output: ["010","011","101","110","111"]
    }
}
