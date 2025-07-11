package SlidingWindow;
// COMPLETED

public class SubstringsContainingABC1358 {
    static int numberOfSubstrings(String s) {
        int n = s.length();
        int a = 0, b = 0, c = 0;
        int left = 0, right = 0, count = 0;

        while(right < n){
            int rightChar = s.charAt(right);

            if(rightChar == 'a') a++;
            if(rightChar == 'b') b++;
            if(rightChar == 'c') c++;

            while(a >= 1 && b >= 1 && c >= 1){
                count += n - right;

                int leftChar = s.charAt(left);

                if(leftChar == 'a') a--;
                if(leftChar == 'b') b--;
                if(leftChar == 'c') c--;

                left++;
            }

            right++;
        }

        return count;
    }
    static int numberOfSubstrings2(String s) {
        int n = s.length();
        int[] freq = new int[3];
        int left = 0, right = 0, count = 0;

        while(right < n){
            int rightCharPosition = s.charAt(right) - 'a';
            freq[rightCharPosition]++;

            while(freq[0] >= 1 && freq[1] >= 1 && freq[2] >= 1){
                count += n - right;

                int leftCharPosition = s.charAt(left) - 'a';
                freq[leftCharPosition]--;
                left++;
            }

            right++;
        }

        return count;
    }

    public static void main(String[] args) {
        String s1 = "abcabc";
        String s2 = "aaacb";

        System.out.println(numberOfSubstrings(s1));
        System.out.println(numberOfSubstrings(s2));
    }
}
