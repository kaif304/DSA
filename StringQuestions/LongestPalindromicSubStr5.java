package StringQuestions;

public class LongestPalindromicSubStr5 {
    static String longestPalindrome2(String s) {
        String ans = "";
        int n = s.length();
        int len = 0;

        for(int i=0; i<n; i++){
            int l = i, r = i;
            // odd length
            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
                if((r-l+1) > len){
                    ans = s.substring(l, r+1);
                    len = r-l+1;
                }
                l--;
                r++;
            }
            // even length
            l = i;
            r = i+1;
            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
                if((r-l+1) > len){
                    ans = s.substring(l, r+1);
                    len = r-l+1;
                }
                l--;
                r++;
            }
        }
        return ans;
    }

    // Manacher's Algorithm / O(n)

    static String longestPalindrome(String s) {
        if (s.length() == 0) return "";

        // Transform the string to handle even-length cases
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        for (char c : s.toCharArray()) {
            sb.append(c).append('#');
        }
        String t = sb.toString(); // Transformed string

        int n = t.length();
        int[] p = new int[n]; // Array to store palindrome radius
        int center = 0, right = 0;
        int maxLen = 0, maxCenter = 0;

        for (int i = 0; i < n; i++) {
            // Mirror index based on current center
            int mirror = 2 * center - i;

            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            // Expanding around center
            int a = i + p[i] + 1;
            int b = i - p[i] - 1;
            while (a < n && b >= 0 && t.charAt(a) == t.charAt(b)) {
                p[i]++;
                a++;
                b--;
            }

            // Update center and right boundary
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }

            // Update max length
            if (p[i] > maxLen) {
                maxLen = p[i];
                maxCenter = i;
            }
        }

        // Extract the palindrome from the original string
        int start = (maxCenter - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("abbbbsbsbs"));
    }
}
