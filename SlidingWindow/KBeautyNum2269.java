package SlidingWindow;

import javax.swing.plaf.IconUIResource;

public class KBeautyNum2269 {
    static int divisorSubstrings(int num, int k) {
        String s = String.valueOf(num);
        int left = 0, right = k-1, count = 0;

        while(right < s.length()){
            int intSubStr = Integer.parseInt(s.substring(left, right+1));
            if(intSubStr != 0 && num % intSubStr == 0) {
                count++;
            }
            left++;
            right++;
        }

        return count;
    }

    public static void main(String[] args) {
//        System.out.println(divisorSubstrings(240, 2));
        System.out.println(divisorSubstrings(430043, 2));
    }
}
