package StringQuestions;
// COMPLETED
public class ValidWordsInSentence2047 {
    static int punctuationC = 0; // C = Count
    static int hyphenC = 0;
    static void countSpecial(String word){
        for(int i=0; i<word.length(); i++){
            if (word.charAt(i) == '-'){
                hyphenC++;
            }
            if (word.charAt(i) == ','){
                punctuationC++;
            }
            if (word.charAt(i) == '!'){
                punctuationC++;
            }
            if (word.charAt(i) == '.'){
                punctuationC++;
            }
        }
    }
    static boolean containsDigit(String word) {
        for (int i=0;i<word.length(); i++) {
            if (Character.isDigit(word.charAt(i))) {
                return true;
            }
        }
        return false;
    }
    static int punctuationIndex(String word){
        int punc = -1;
        if(word.indexOf('!') != -1){
            punc = word.indexOf('!');
        }
        else if(word.indexOf(',') != -1){
            punc = word.indexOf(',');
        }
        else if(word.indexOf('.') != -1){
            punc = word.indexOf('.');
        }
        return punc;
    }
    static boolean validHyphen(String word, int index){
        return index != -1 && index != 0 && index != word.length() - 1
                &&
            ( (int) word.charAt(index - 1) >= 97 && (int) word.charAt(index - 1) <= 122 )
                &&
            ( (int) word.charAt(index + 1) >= 97 && (int) word.charAt(index + 1) <= 122 );
    }
    static int countValidWords(String sentence) {
        int count = 0;
        String[] words = sentence.trim().split("\\s+");

        for (String word : words) {
            countSpecial(word);
            boolean digits = containsDigit(word);
            int punch = punctuationIndex(word);

            int hyphenIndex = word.indexOf('-');
            boolean validHyphen = validHyphen(word, hyphenIndex);

            if (( punctuationC <= 1 && hyphenC <=1 )
                    &&
                    !digits
                    &&
                    (hyphenIndex == -1 || validHyphen)
                    &&
                    (punch == -1 || punch == word.length() - 1)) {
                count++;
            }
            punctuationC = 0;
            hyphenC = 0;
        }
        return count;
    }
    public static void main(String[] args) {
//        System.out.println(countValidWords("cat   and dog"));
//        System.out.println(countValidWords("!this 1-s b8d!"));
//        System.out.println(countValidWords("he bought 2 pencils, 3 erasers, and 1  pencil-sharpener."));
//        System.out.println(countValidWords("a-b-c"));
//        System.out.println(countValidWords("j.iylyg!"));
//        System.out.println(countValidWords("jrt3y9,i.elhaitz38c"));
        System.out.println(countValidWords("w1ijubj 55vj  n!fsyn55  k7-q v  ov xt  z q24  9hw8 k!2  i9849r h z1!!r pz  jrt3y9,i.elhaitz38c 53g6wed e t5  1 j.iylyg! n5 4gi1q5jt 0 r5k  r6 s 9!r3 -.toh!1x2c 9xdscd9u qri w7ueed87c rq,4u nhr1c  386l8j r3i, 2w7   ! b g  3wxf.vip 1,48q44l  bm  2  7 0 xl 9 v6jn  iv67lo a r .e4  - ,x p b1  -ln w zpk 5jm jxxium esng80 6-bs2a!3,1f1 9f1.vg uvuohi.  s  usy6yt e vok  qxixwtk7x2b3 lwb.2f6os9!ru kzot3q ng  4,22wjoqn yg9p2 2m8q w3ovo4  38paet0. wu fsy3b 7wl m !3   a5z49-,cm8uu9u.k10aq7o5oco b  ! 2pf  ,1 .nr t0d5s  pfwnyc86i oc  r.3.f48   -  s!sx p8j8 hjdty p htz z -v 8mjmm y-j uyz7j5.b7gt1 vs876gl68c   4hw 5.0!-!ae vun24  91 z mrd e,3r .dbx ens6s!5c2 !th3sn sv1pn z,6ur  bq4 kr 9.o7  mgk c8ft39i 3u7wms8txqrbtfb 2 , .q7zs  f xta f r mx7fj, ,s7i xx uy6u 6 jx   n5num -on7s!v y  jq8undap4z d c  8 s  tll    t i0hxizs qlx9u yr. 9  8a6.j lck6xa9nf w xjs  yh6,l6 t kqy t3,lz1!"));
    }
}
