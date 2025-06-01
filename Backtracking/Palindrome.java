package Backtracking;

public class Palindrome {
    static boolean palindrome(String s, int left, int right){
        if(left >= right) return true;

        // if any corresponding chars are not equal
        if(s.charAt(left) != s.charAt(right)) return false;

        // check for the next two
        return palindrome(s, left+1, right-1);
    }
    public static void main(String[] args) {
        String s = "madam";
        System.out.println(palindrome(s, 0, s.length()-1));
    }
}
