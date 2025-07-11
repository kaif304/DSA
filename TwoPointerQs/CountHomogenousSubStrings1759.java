package TwoPointerQs;
// COMPLETED

public class CountHomogenousSubStrings1759 {
    // Good Problem
    static int countHomogenous(String s) {
        int mod = 1000000007;
        int count = 0;
        int left = 0, right = 0, n = s.length();

        while(right < n){
            if(right < n-1 && s.charAt(right) == s.charAt(right + 1)){
                right++;
            }
            else {
                int currLength = right - left + 1;
                long totalSubstrings = ((long) currLength * (currLength + 1) ) / 2;
                count = (int) (count + totalSubstrings) % mod;

                right++;
                left = right;
            }
        }

        return count;
    }
    public static void main(String[] args) {
        String s = "abbcccaa";
        String s2 = "zzzzz";
        System.out.println(countHomogenous(s));
        System.out.println(countHomogenous(s2));
    }
}
