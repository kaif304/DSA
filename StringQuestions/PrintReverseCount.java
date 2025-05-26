package StringQuestions;

public class PrintReverseCount {
    static void reverseCountSeparatedBySpace(String s){
        int left = s.length()-1, right = s.length();

        while(left >= 0) {
            if(s.charAt(left) == ' '){
                System.out.println(s.substring(left+1, right));
                right = left;
            }
            else if (left == 0) {
                System.out.println(s.substring(left, right));
            }
            left--;
        }
    }
    public static void main(String[] args) {
        String spaceSeparated = "one two three four five six";
        reverseCountSeparatedBySpace(spaceSeparated);
    }
}
