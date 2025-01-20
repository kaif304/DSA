package Arrays;
import java.util.ArrayList;
public class SubSequence {
    static void helper(ArrayList<Integer> list, int[] arr, int i){
        if(i == arr.length){
            System.out.println(list);
            return;
        }
        list.add(arr[i]);
        helper(list, arr, i+1);
        list.remove(list.size()-1);
        helper(list, arr, i+1);
    }
    static void subSequence(int[] arr){
        helper(new ArrayList<>(), arr, 0);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        subSequence(arr);
    }
}
