package Question;

import java.util.HashSet;

public class LongestPalindrome409 {
    static int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int length = 0;

        for(char e: s.toCharArray()){
            if(set.contains(e)){
                set.remove(e);
                length += 2;
            }
            else{
                set.add(e);
            }
        }
        if(!set.isEmpty()){
            length += 1;
        }
        return length;
    }
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }
}
