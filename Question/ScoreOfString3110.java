package Question;

public class ScoreOfString3110 {
    static int score(String s){
        int sum = 0;
        for (int i = 0; i < s.length()-1; i++) {
            sum += Math.abs( s.charAt(i) - s.charAt(i+1));
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(score("zaz"));
    }
}
