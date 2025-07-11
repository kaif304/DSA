package SlidingWindow;

public class LongestSubstringWithoutRepeatingChars3 {
    static int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        int l = 0, r = 0, maxLength = 0;

        while(r < s.length()){
            char right = s.charAt(r);
            map[right]++;

            while(map[right] > 1){
                map[s.charAt(l++)]--;
            }

            maxLength = Math.max(maxLength, r - l +1);
            r++;
        }

        return maxLength;
    }
    public static void main(String[] args) {
        String s = "abcabcbb";
        String s2 = "pwwkew";

        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstring(s2));
    }
}
