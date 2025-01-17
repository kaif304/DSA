package Question;
import java.util.Deque;
import java.util.List;
import java.util.LinkedList;

public class RemoveDupFromSortedArr80 {
    static int removeDuplicates(int[] nums) {
        Deque<Integer> list = new LinkedList<>();
        int i = 0;
        int count = 1;

        while(i < nums.length){
            if(nums[i] == nums[i+1]){
                count++;
            }
            i++;
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(arr));
    }
}
