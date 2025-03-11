package SlidingWindow;
// COMPLETED

public class SubstringsWithDistinctChar1876 {
    static int countGoodSubstrings(String s) {
        if(s.length() < 3) return 0;
        int n = s.length();
        int count = 0;

        for (int i = 2; i < n; i++) {
            if(s.charAt(i) != s.charAt(i-1) &&
               s.charAt(i) != s.charAt(i-2) &&
               s.charAt(i-1) != s.charAt(i-2)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countGoodSubstrings("xyzzaz"));
        System.out.println(countGoodSubstrings("aababcabc"));
    }
}
