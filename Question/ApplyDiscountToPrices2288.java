package Question;

import java.util.Arrays;

public class ApplyDiscountToPrices2288 {

    static String makeDicount(String word, int discount){
        if (word.substring(1).contains("$")) {
            return word;
        }
//        long price = Long.parseLong(word.substring(1));
//        double discountedPrice = price - ((price * (double) discount) / 100);
//        return "$"+String.format("%.2f", discountedPrice);

        try{
            long price = Long.parseLong(word.substring(1));
            double discountedPrice = price - ((price * (double) discount) / 100);
            return "$"+String.format("%.2f", discountedPrice);
        }
        catch(Exception e){
            return word;
        }
    }
    static String discountPrices(String sentence, int discount) {
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if(words[i].length() > 1 && !words[i].contains(lowercase) && words[i].charAt(0) == '$'){
                words[i] = makeDicount(words[i], discount);
            }
        }
        return String.join(" ",words);
    }
    public static void main(String[] args) {
        String s = "there are $1 $2 and 5$ candies in the shop";
        String s2 = "1 2 $3 4 $5 $6 7 8$ $9 $10$";
        String s3 = "$7383692 5q $5870426";
        String s4 = "706hzu76jjh7yufr5x9ot60v149k5 $7651913186 pw2o $6";
        System.out.println(discountPrices(s4,28));
    }
}
