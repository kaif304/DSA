package DP;

import java.util.HashMap;

public class TotalCharsAfterTransformation3335 {
    static int lengthAfterTransformations(String s, int t) {
        int mod = 1000000007;
        StringBuilder result = new StringBuilder(s);
        HashMap<Character, String> dp = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            result.append(transform(ch, t, dp));
        }

        return result.length() % mod;
    }

    static String transform(char ch, int t, HashMap<Character, String> dp){
        if(dp.containsKey(ch)){
            return dp.get(ch);
        }

        StringBuilder result = new StringBuilder();
        result.append(ch);

        for(int i = 0; i < t; i++){
            StringBuilder sb = new StringBuilder();

            for(int j = 0; j < result.length(); j++){
                char chr = result.charAt(j);

                if(ch == 'z'){
                    sb.append("ab");
                }
                else{
                    sb.append((char)(chr + 1));
                }
            }

            result = sb;
        }

        dp.put(ch, result.toString());
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(lengthAfterTransformations("jqktcurgdvlibczdsvnsg", 7517));
    }
}
