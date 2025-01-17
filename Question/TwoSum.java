package Question;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class TwoSum {
    static int[] twoSum(int[] arr, int tar){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i] + arr[j] == tar){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
    // Most optimized
    public static int[] twoSum2(int[] arr, int tar) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = tar - arr[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(arr[i], i);
        }
        System.out.println(map);
        return new int[]{-1, -1};
    }
    public static void main(String[] args) {
        int[] arr = {1,23,4,7,6,8};
        System.out.println(Arrays.toString(twoSum2(arr,10)));
    }
}
