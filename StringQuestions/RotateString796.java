package StringQuestions;

public class RotateString796 {
    static boolean rotateString2(String s, String goal){
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            if(sb.toString().equals(goal)){
                return true;
            }
            sb.insert(0, sb.charAt(sb.length()-1));
            sb.deleteCharAt(sb.length()-1);
        }
        return false;
    }
    static boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        String doubleS = s + s;
        // return doubleS.indexOf(goal) != -1;
        return doubleS.contains(goal);
    }
    public static void main(String[] args) {
        System.out.println(rotateString("abcde", "cdeab"));
        System.out.println(rotateString("defdefdefabcabc", "defdefabcabcdef"));
    }
}
