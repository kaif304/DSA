package StringQuestions;
// COMPLETED
import java.util.ArrayList;

public class SortSmallUpper {
    static String sort(String s){
        int n = s.length();
        ArrayList<Character> cap = new ArrayList<>();
        ArrayList<Character> small = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) != ' '){
                char ch = s.charAt(i);
                if((int)ch > 64 && (int)ch < 91){
                    cap.add(ch);
                }
                else {
                    small.add(ch);
                }
            }
        }
        for (int i = 0; i < cap.size()-1; i++) {
            int sm = i;
            for (int j = i+1; j < cap.size(); j++) {
                if((int)cap.get(j) < (int)cap.get(sm)){
                    sm = j;
                }
            }
            char temp = cap.get(i);
            cap.set(i, cap.get(sm));
            cap.set(sm, temp);
        }
        for (int i = 0; i < small.size()-1; i++) {
            int sm = i;
            for (int j = i+1; j < small.size(); j++) {
                if((int)small.get(j) < (int)small.get(sm)){
                    sm = j;
                }
            }
            char temp = small.get(i);
            small.set(i, small.get(sm));
            small.set(sm, temp);
        }
        
        cap.add(' ');
        cap.addAll(small);
        StringBuilder ans = new StringBuilder();
        for(char ch:cap){
            ans.append(ch);
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        System.out.println(sort("The Cat"));
    }
}
