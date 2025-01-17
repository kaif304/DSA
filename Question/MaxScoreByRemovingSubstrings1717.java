package Question;
// Lab Questions - 53, 493
public class MaxScoreByRemovingSubstrings1717 {
    static int makeAbScore(StringBuilder sb, int x){
        int score = 0;
        String remove = "ab";
        int startIndex;

        while(true){
            startIndex = sb.indexOf(remove);
            if(startIndex == -1){
                break;
            }
            score += x;
            sb.delete(startIndex, startIndex+remove.length());
        }

        return score;
    }
    static int makeBaScore(StringBuilder sb, int y){
        int score = 0;
        String remove = "ba";
        int startIndex;

        while(true){
            startIndex = sb.indexOf(remove);
            if(startIndex == -1){
                break;
            }
            score += y;
            sb.delete(startIndex, startIndex+remove.length());
        }

        return score;
    }
    static int maximumGain(String s, int x, int y) {
        StringBuilder sb = new StringBuilder(s);
        int ab = 0;
        int ba = 0;
        if(x > y){
            ab = makeAbScore(sb, x);
            ba = makeBaScore(sb, y);
        }
        else{
            ba = makeBaScore(sb, y);
            ab = makeAbScore(sb, x);
        }
        return ab + ba;
    }
    public static void main(String[] args) {
        System.out.println(maximumGain("cdbcbbaaabab",4,5));
        System.out.println(maximumGain("aabbaaxybbaabb",5,4));
    }
}
