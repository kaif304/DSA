package Question;
import java.util.Set;
import java.util.HashSet;
public class LongestSubstringWithoutRepeatingCharacters3 {
    static int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int left = 0;
        int right = 0;
        HashSet<Character> set = new HashSet<>();

        while(right < s.length()){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            }
            else{
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}