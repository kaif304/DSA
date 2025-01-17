package Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class DivideArrayIntoKConsecutiveNumbers1296 {
    static boolean isPossibleDivide(int[] nums, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        Arrays.sort(nums);
        for (int num : nums) {
            list.add(num);
        }
        System.out.println(list);

        while(!list.isEmpty()) {
            List<Integer> temp = new ArrayList<>();

            while(temp.size() != k){
                for (int i = 0; i < list.size(); i++) {
                    if(temp.isEmpty() && list.get(i) > temp.get(temp.size()-1)){
                        temp.add(list.get(i));
                        list.remove(i);
                    }else{
                        temp.add(list.getFirst());
                        list.removeFirst();
                    }
                }
            }
            if(temp.size() != k){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,4,4,5,6};
        int[] arr2 = {3,2,1,2,3,4,3,4,5,9,10,11};
        System.out.println(isPossibleDivide(arr2,3));
    }
}
