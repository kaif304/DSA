package StringQuestions;
// COMPLETED

import java.util.Arrays;

public class ShiftingLetters848 {
    // Suffix sum is making it optimized : O(n^2) to O(n)
    static int[] generateSuffix(int[] arr){
        int[] suffix = new int[arr.length];
        long sum = 0;
        for (int i = arr.length-1; i >= 0; i--) {
            sum = (sum + arr[i]) % 26;
            suffix[i] = (int) sum;
        }
        return suffix;
    }
    static String shiftingLetters(String s, int[] shifts) {
        int[] suffixes = generateSuffix(shifts);

        char[] charArr = s.toCharArray();

        for (int i = 0; i < charArr.length; i++) {
            int x = suffixes[i] % 26;
            char currChar = charArr[i];
            char shiftedChar = (char) ('a' + (currChar - 'a' + x) % 26 );

            charArr[i] = shiftedChar;
        }

        return new String(charArr);
    }
    static String shiftingLetters2(String s, int[] shifts) {
        char[] charArr = s.toCharArray();

        for (int i = 0; i < charArr.length; i++) {
            int x = shifts[i];

            for (int j = 0; j < i+1; j++) {
                char currChar = charArr[j];
                char shiftedChar = (char) ('a' + (currChar - 'a' + x) % 26 );

                charArr[j] = shiftedChar;
            }

            System.out.println(Arrays.toString(charArr));
        }

        return new String(charArr);
    }

    public static void main(String[] args) {
        String s = "abc";
        int[] shifts = {3,5,9};

        String s2 = "mkgfzkkuxownxvfvxasy";
        int[] shifts2 = {505870226,437526072,266740649,224336793,532917782,311122363,567754492,595798950,81520022,684110326,137742843,275267355,856903962,148291585,919054234,467541837,622939912,116899933,983296461,536563513};

        System.out.println(shiftingLetters(s2, shifts2));
//        test(shifts2);
    }
}
