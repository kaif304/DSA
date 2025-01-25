package StringQuestions;
// COMPLETED
import java.util.Arrays;
public class RearrangeCharsMakeTargetStr2287 {
        static int rearrangeCharacters(String s, String target) {
            int[] freqS = new int[26];
            int[] freqTarget = new int[26];
            for (int i = 0; i < s.length(); i++) {
                freqS[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < target.length(); i++) {
                freqTarget[target.charAt(i) - 'a']++;
            }

            int count = Integer.MAX_VALUE;
            for (int i = 0; i < 26; i++) {
                if(freqTarget[i] > 0){
                    count = Math.min(count, freqS[i]/freqTarget[i]);
                }
            }

            return count;
        }

        public static void main(String[] args) {
            System.out.println(rearrangeCharacters("ilovecodingonleetcode", "code"));
            System.out.println(rearrangeCharacters("abbaccaddaeea", "aaaaa"));
            System.out.println(rearrangeCharacters("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "a"));
        }
    }


