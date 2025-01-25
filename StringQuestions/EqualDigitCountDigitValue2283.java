package StringQuestions;

import java.util.Arrays;

public class EqualDigitCountDigitValue2283 {
    static boolean digitCount(String num){
        int[] map = new int[10];
        for (int i = 0; i < num.length(); i++) {
            map[num.charAt(i)-'0']++;
        }
        for (int i = 0; i < num.length(); i++) {
            if(map[i] != num.charAt(i)-'0'){
                return false;
            }
        }
        System.out.println(Arrays.toString(map));
        return true;
    }
    public static void main(String[] args) {
        System.out.println(digitCount("1210"));
        System.out.println(digitCount("030"));
    }
}
