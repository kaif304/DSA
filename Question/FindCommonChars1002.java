package Question;
import java.util.ArrayList;
import java.util.List;
public class FindCommonChars1002 {
    static List<String> commonChars(String[] words){
        List<String> ans = new ArrayList<>();
        for(char ch = 'a'; ch <= 'z'; ch++){
            int min = Integer.MAX_VALUE;
            for(String word: words){
                int count = 0;
                for(int i=0; i<word.length(); i++){
                    if(ch == word.charAt(i)){
                        count++;
                    }
                }
                min = Math.min(min,count);
            }
            for(int i=0; i<min; i++){
                ans.add(String.valueOf(ch));
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String[] words = {"bella","label","roller"};
        System.out.println(commonChars(words));
        for(int ch = 'a'; ch<='z'; ch++){
            System.out.println(ch);
        }
    }
}
