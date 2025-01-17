package Question;
import java.util.ArrayList;
import java.util.List;
public class NumberOfBeautifulSubsets2597 {
    public boolean isBeautiful(List<Integer> list, int key){
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(Math.abs(list.get(i) - list.get(j)) == key){
                    return false;
                }
            }
        }
        return true;
    }
    int count = 0;
    public void helper(int[] nums, int i, List<Integer> subset, int key) {
        if(i == nums.length){
            if(!subset.isEmpty() && isBeautiful(subset, key)) {
                count++;
            }
            return;
        }
        subset.add(nums[i]);
        helper(nums, i+1, subset,key);
        subset.remove(subset.size()-1);
        helper(nums, i+1, subset,key);
    }
    public int beautifulSubsets(int[] nums, int key){
        List<Integer> temp = new ArrayList<>();
        count = 0;
        helper(nums,0, temp,key);
        return count;
    }
    public static void main(String[] args) {
        NumberOfBeautifulSubsets2597 obj = new NumberOfBeautifulSubsets2597();
        int[] arr = {2,4,6};
        System.out.println(obj.beautifulSubsets(arr,2));
    }
}
