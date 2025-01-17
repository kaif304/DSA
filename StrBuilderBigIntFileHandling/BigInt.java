package StrBuilderBigIntFileHandling;

import java.math.BigInteger;

public class BigInt {
    public static void main(String[] args) {
        int n = 541549513;
        BigInteger a = BigInteger.valueOf(5431684135468543546L);
        BigInteger b = BigInteger.valueOf(54154951349454L);
        BigInteger c = new BigInteger("54648454");
        BigInteger sum = a.add(b);
        System.out.println(sum +" "+ c);
    }
}
