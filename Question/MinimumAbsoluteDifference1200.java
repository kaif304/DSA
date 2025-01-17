package Question;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class MinimumAbsoluteDifference1200 {
    static List<List<Integer>> absDiff(int[] arr){
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length-1; i++) {
            int diff = Math.abs(arr[i] - arr[i+1]);
            if(diff < minDiff){
                minDiff = diff;
            }
        }

        List<Integer> ans;
        for(int i=0; i< arr.length-1; i++){
            if(Math.abs(arr[i] - arr[i+1]) == minDiff){
                ans = new ArrayList<>();
                ans.add(arr[i]);
                ans.add(arr[i+1]);
                list.add(ans);
            }
        }

        return list;
    }
    public static void main(String[] args) {
        int[] arr = {4,2,1,3};
        int[] arr2 = {3,8,-10,23,19,-4,-14,27};
        int[] arr3 = {40,11,26,27,-20};
        System.out.println(absDiff(arr3));
    }
}
