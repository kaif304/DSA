package StringQuestions;

import java.util.Arrays;

public class ShiftingLetters2381 {
    static void shiftRange(char[] arr, int start, int end, boolean forward){
        if(forward){
            for (int i = start; i <= end; i++) {
                char ch = arr[i];
                arr[i] = (char) ('a' + (ch - 'a' + 1) % 26);
            }
        }
        else {
            for (int i = start; i <= end; i++) {
                char ch = arr[i];
                arr[i] = (char) ('a' + (ch - 'a' - 1 + 26) % 26);
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    static String shiftingLetters(String s, int[][] shifts) {
        char[] charArr = s.toCharArray();

        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            boolean forward = shift[2] == 1;

            shiftRange(charArr, start, end, forward);
        }

        return new String(charArr);
    }
    public static void main(String[] args) {
        String s = "abc";
        int[][] shifts = {{0,1,0},{1,2,1},{0,2,1}};

        System.out.println(shiftingLetters(s, shifts));
    }
}
