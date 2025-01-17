package StrBuilderBigIntFileHandling;

import java.util.Random;

public class SB {
    static String generate(int size){
        StringBuffer sb = new StringBuffer(size);
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int randomChar = 97 + (int)(random.nextFloat() * 26);
            sb.append((char)(randomChar));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer(); // constructor 1
        sb.append("kaif");
        sb.append(" is nice!");
        String str = sb.toString();
        System.out.println(str);
        StringBuffer sb2 = new StringBuffer(); // constructor 2
        StringBuffer sb3 = new StringBuffer(); // constructor 3

        System.out.println(SB.generate(20));
    }
}
