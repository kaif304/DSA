package Question;

public class LongestOddInString455 {
    static String largestOddNumber(String num){
        int odd = num.length()-1;
        while(odd >= 0){
            if((num.charAt(odd) - '0') % 2 == 1){
                break;
            }
            odd--;
        }
        return num.substring(0,odd+1);
    }

    public static void main(String[] args) {
        System.out.println(largestOddNumber("52"));
    }
}
