package StringQuestions;
// COMPLETED

public class FindOriginalTypedString3330 {
    static int possibleStringCount2(String word) {
        int count = 0, n = word.length();

        // a b b c c c c
        for (int i = 0; i < n; i++) {
            while (i < n-1 && word.charAt(i) == word.charAt(i+1)) {
                count++;
                i++;
            }
        }

        return count + 1;
    }
    static int possibleStringCount(String word) {
        int n = word.length(), ans = 1;

        for (int i = 1; i < n; i++) {
            if (word.charAt(i - 1) == word.charAt(i)) {
                ans++;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        String word = "abbcccc";

        System.out.println(possibleStringCount(word));
    }
}
