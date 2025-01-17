package Question;

import java.util.Arrays;
import java.util.HashMap;

public class RankTransformArr1331 {
    static int[] arrayRankTransform(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int[] arrCopy = Arrays.copyOfRange(arr,0,arr.length);
        Arrays.sort(arrCopy);
        System.out.println(Arrays.toString(arrCopy));
        map.put(arrCopy[0], 1);

        int rank = 1;
        for(int i=1; i<arrCopy.length; i++){
            if(arrCopy[i] == arrCopy[i-1]){
                map.put(arrCopy[i], rank);
            }
            else{
                rank++;
                map.put(arrCopy[i], rank);
            }
        }
        System.out.println(map);

        for(int i=0; i<arr.length; i++){
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {40,10,20,30};
        int[] arr2 = {2,-11,24,15,26,-31,-48,-49,22,37,-36};
//        int[] ans = arrayRankTransform(arr);
        int[] ans2 = arrayRankTransform(arr2);
        System.out.println(Arrays.toString(ans2));
    }
}
