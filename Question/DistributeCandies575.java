package Question;
import java.util.HashSet;
public class DistributeCandies575 {
    static int distributeCandies(int[] candyType) {
        HashSet<Integer> set = new HashSet<>();
        int limit = candyType.length / 2;

        for(int e:candyType){
            if(set.size() == limit){
                break;
            }
            set.add(e);
        }

        return set.size();
    }
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3};
        System.out.println(distributeCandies(arr));
    }
}
