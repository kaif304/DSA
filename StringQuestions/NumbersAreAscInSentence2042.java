package StringQuestions;

public class NumbersAreAscInSentence2042 {
    static boolean areNumbersAscending(String s) {
        int num = -1;
        String[] tokens = s.split(" ");
        for(String token : tokens){
            if("0123456789".indexOf(token.charAt(0)) != -1 && Integer.parseInt(token) > num){
                num = Integer.parseInt(token);
            }
            if("0123456789".indexOf(token.charAt(0)) != -1 && Integer.parseInt(token) < num){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
    }
}
