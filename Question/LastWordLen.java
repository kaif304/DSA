package Question;

public class LastWordLen {
    static int len(String s){
        s = s.trim();
        int length = 0;
        for(int i = s.length()-1; i>=0; i--){
            if(s.charAt(i) == ' '){
                break;
            }
            length++;
        }
        return length;
    }
    public static void main(String[] args) {
        String s = "   kaif is   mywife   ";
        System.out.println(len(s));
    }
}
