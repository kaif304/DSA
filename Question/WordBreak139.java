package Question;
import java.util.ArrayList;
import java.util.List;
public class WordBreak139 {
    static boolean wordBreak(String s, List<String> dict, int dictI){
        if(dictI == dict.size()){
            return true;
        }
        String subString = s.substring(0,dict.get(dictI).length());
        String dictString = dict.get(dictI);
        System.out.println(subString + " " + dictString);
        if(!subString.equals(dictString)){
            return false;
        }
        else{
            return wordBreak(s.substring(dict.get(dictI).length()), dict, dictI+1);
        }
    }
    public static void main(String[] args) {
        List<String> dict = new ArrayList<>();
        dict.add("apple");
        dict.add("pen");
        System.out.println(wordBreak("applepenapple", dict, 0));
    }
}
