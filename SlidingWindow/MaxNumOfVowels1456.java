package SlidingWindow;
// COMPLETED

public class MaxNumOfVowels1456 {
    static int maxVowels(String s, int k) {
        int count = 0;

        for (int i = 0; i < k; i++) {
            if(isVowel(s.charAt(i))) count++;
        }

        int max = count;

        for (int i = k; i < s.length(); i++) {
            if(isVowel(s.charAt(i-k))) count--;
            if(isVowel(s.charAt(i))) count++;

            max = Math.max(max, count);
        }

        return max;
    }
    static boolean isVowel(char ch){
        return "aeiou".indexOf(ch) != -1;
    }

    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef", 3));
    }
}
