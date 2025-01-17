package Question;
public class ReversePrefixOfWord2000 {
    static String reversePrefix2(String word, char ch) {
        int j = word.indexOf(ch);
        if (j != -1) {
            return new StringBuilder(word.substring(0, j + 1)).reverse().toString() + word.substring(j + 1);
        }
        return word;
    }
    public static void main(String[] args) {
        String word = "abcdefgh";
        System.out.println(reversePrefix2(word,'d'));
    }
}
