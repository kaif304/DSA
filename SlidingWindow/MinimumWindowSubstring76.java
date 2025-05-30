package SlidingWindow;
// COMPLETED - Hard

// Using int array for storing character frequencies is very efficient than hashmap

public class MinimumWindowSubstring76 {
    static String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";

        int[] tFreq = new int[128];
        for (int i = 0; i < t.length(); i++) tFreq[t.charAt(i)]++;

        int[] windowFreq = new int[128]; // to track frequency of t chars in window

        int finalLeft = -1, finalRight = -1;
        int minLen = Integer.MAX_VALUE;

        int need = 0, have = 0; // to track unique chars that are found completely in window
        for (int freq : tFreq) {
            if (freq > 0) need++;
        }

        int left = 0, right = 0;

        while(right < s.length()){
            char ch = s.charAt(right);
            windowFreq[ch]++;

            if(tFreq[ch] != 0 && windowFreq[ch] == tFreq[ch]){ // is present in both s & t
                have++;
            }

            while(have == need){
                if((right-left+1) <= minLen){
                    minLen = right-left+1;
                    finalLeft = left;
                    finalRight = right;
                }

                char leftChar = s.charAt(left);
                windowFreq[leftChar]--;

                // if present in both s & t
                if (tFreq[leftChar] != 0 && windowFreq[leftChar] < tFreq[leftChar]) {
                    have--;
                }

                left++;
            }

            right++;
        }

        if(minLen == Integer.MAX_VALUE) return "";

        return s.substring(finalLeft, finalRight+1);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));
    }
}
