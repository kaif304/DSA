package Question;
import java.util.ArrayList;
import java.util.List;
public class PhoneLetterCombination {
    static void phonePad(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) - '0';
        for(int i=(digit-1)*3; i<digit*3; i++){
            phonePad(p + (char)('a'+i),up.substring(1));
        }
    }
    // Add all combinations into a ArrayList
    static List<String> phonePad2(String p, String up){
        if(up.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> ans = new ArrayList<>();
        int digit = up.charAt(0) - '0';
        for(int i=(digit-1)*3; i<digit*3; i++){
            ans.addAll(phonePad2(p + (char)('a'+i),up.substring(1)));
        }
        return ans;
    }
    public static void main(String[] args) {
        phonePad("","23");
//        System.out.println(phonePad2("","23"));
    }
}
