package SlidingWindow;

public class SubStrsThatSatisfyKConstraintI3258 {
    static int countKConstraintSubstrings(String s, int k) {
        int count = 0;

        int left = 0, right = 0, n = s.length();
        int zeros = 0, ones = 0;

        while(right < n){
            if(s.charAt(right) == '0') zeros++;
            if(s.charAt(right) == '1') ones++;

            while(zeros > k || ones > k){
                if(s.charAt(left) == '0') zeros--;
                if(s.charAt(left) == '1') ones--;
                left++;
            }

            int size = right - left + 1;
            count += ((size * (size + 1)) / 2);

            right++;
        }

        return count;
    }
    public static void main(String[] args) {
        String s = "10101";

        System.out.println(countKConstraintSubstrings(s, 1));
    }
}
