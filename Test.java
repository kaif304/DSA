// This class is for Testing of Small Code & Debugging
public class Test{
    static String helper(String s, char ch, StringBuilder ans){
        if(s.isEmpty()){
            return ans.toString();
        }
        if(s.charAt(0) != ch){
            ans.append(s.charAt(0));
        }
        return helper(s.substring(1), ch, ans);
    }
    static String removeChar(String s, char ch){
        StringBuilder sb = new StringBuilder();
        return helper(s, ch, sb);
    }

    static void subSequence(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subSequence(p+ch, up.substring(1));
        subSequence(p, up.substring(1));
    }
    public static void main(String [] args){
//        System.out.println(removeChar("bacaac", 'a'));
        subSequence("","abc");
    }
}