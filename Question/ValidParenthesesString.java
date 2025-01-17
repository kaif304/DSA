package Question;

public class ValidParenthesesString {
    static String make(String s){
        int count = 0;
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        while(i<sb.length()){
            if(sb.charAt(i) == '('){
                count++;
                i++;
            }else if(sb.charAt(i) == ')'){
                if(count > 0){
                    count--;
                    i++;
                }
                else{
                    sb.deleteCharAt(i);
                }
            }
            else{
                i++;
            }
        }
        if(count == 0){
            return sb.toString();
        }
        i = sb.length()-1;
        count = 0;
        while(i >= 0){
            if(sb.charAt(i) == ')'){
                count++;
                i--;
            }else if(sb.charAt(i) == '('){
                if(count > 0){
                    count--;
                    i--;
                }
                else{
                    sb.deleteCharAt(i--);
                }
            }else{
                i--;
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(make("a)b(c)d"));
    }
}
