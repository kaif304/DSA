package StringQuestions;

public class StringIsPrefixOfArray1961 {
    static boolean isPrefixString(String s, String[] words) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < words.length; i++){
            if(sb.length() >= s.length()) break;
            sb.append(words[i]);
        }

        String substring = sb.toString();

        if(substring.length() == s.length() && substring.equals(s)){
            return true;
        }

        return false;
    }
    public static void main(String[] args) {
        String s = "iloveleetcode";
        String[] words = {"i", "love", "leetcode"};
        String s1 = "a";
        String[] words1 = {"aa", "aaaa", "banana"};
        String s2 = "iloveleetcode";
        String[] words2 = {"apples","i","love","leetcode"};

        System.out.println(isPrefixString(s, words));
        System.out.println(isPrefixString(s1, words1));
        System.out.println(isPrefixString(s2, words2));
    }
}
