package Question;

import java.util.HashMap;

public class LargestIntegerWithItsNegative2441 {
    static int ans(int[] nums){
        int largest = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int e: nums){
            if(e < 0){
                map.put(-1*e, e);
            }
        }
        for(int e: nums){
            if(e > 0 && !map.isEmpty()){
                if(map.containsKey(e) && e > largest){
                    largest = e;
                }
            }
        }
        map = null;
        return largest;
    }
    public static void main(String[] args) {
        int[] arr = {-1,2,-3,3};
        int[] arr2 = {-1,10,6,7,-7,1};
        int[] arr3 = {-10,8,6,7,-2,-3};
        System.out.println(ans(arr2));
    }
}
