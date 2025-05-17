package SlidingWindow;

import java.util.HashMap;

public class LongestSubstringWithoutRepeat3 {
    static int lengthOfLongestSubstring2(String s) {
        int n = s.length(), left = 0, right = 0;
        int maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while(right < n){
            char rightChar = s.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0)+1);

            while(map.get(rightChar) > 1){
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);

            right++;
        }

        return maxLength;
    }

    static int lengthOfLongestSubstring(String s) {
        int[] freq = new int[128];
        int left = 0, right = 0, maxLength = 0;

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            freq[rightChar]++;

            while (freq[rightChar] > 1) {
                char leftChar = s.charAt(left);
                freq[leftChar]--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }


    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
