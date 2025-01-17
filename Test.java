// This class is for Testing of Small Code & Debugging
public class Test{
    static boolean validHyphen(String word, int index, int num){
        num = 10;
        return index != -1 && index != 0 && index != word.length() - 1
            &&
            ( (int) word.charAt(index - 1) >= 97 && (int) word.charAt(index - 1) <= 122 )
            &&
            ( (int) word.charAt(index + 1) >= 97 && (int) word.charAt(index + 1) <= 122 );
    }

    public static void main(String [] args){
        int num = 0;
        boolean valid = validHyphen("pencil-sharpener.",6, num);
        System.out.println(valid);
        System.out.println(num);
    }
}