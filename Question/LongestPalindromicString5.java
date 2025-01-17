package Question;

public class LongestPalindromicString5 {
    static StringBuilder ans = new StringBuilder();
    static String longestPalindrome(String s) {
        helper("", s);
        return ans.toString();
    }
    static void helper(String p, String up){
        if(up.isEmpty()){
            if(isPalindrom(p)){
                if(p.length() > ans.length()){
                    ans.replace(0, ans.length(), p);
                }
            }
            return;
        }

        helper(p + up.charAt(0), up.substring(1));
        helper(p, up.substring(1));
    }
    static boolean isPalindrom(String s){
        int i = 0;
        int j = s.length()-1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}
