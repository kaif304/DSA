package RecursionQs;
import java.util.ArrayList;
// Print subset of string and in other way also
class StrSubset {
    public  static void subset(String p, String up){
        if( up.isEmpty()){
            System.out.print(p+" ");
            return;
        }
        char ch = up.charAt(0);

        subset(p+ch, up.substring(1));
        subset(p, up.substring(1));
    }
    public static void main(String[] args) {
        subset("","abc");
    }
}