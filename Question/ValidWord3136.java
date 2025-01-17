package Question;

public class ValidWord3136 {
    static boolean isValid(String word) {
        if(word.length() < 3){
            return false;
        }
        int vCh = 0;
        int cCh = 0;

        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);

            if(Character.isLetter(ch)){
                if("aeiouAEIOU".indexOf(ch) != -1){
                    vCh++;
                }
                else{
                    cCh++;
                }
            }
            else if(!Character.isDigit(ch)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "AhI";
        String s2 = "#wzI";
        System.out.println(isValid(s2));
    }
}
