package Question;
import java.util.List;
import java.util.ArrayList;
public class Subsets78 {
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }
        return result;
    }
    public List<List<Integer>> result = new ArrayList<>();
    public void helper(int[] nums,int i,List<Integer> subset) {
        if(i == nums.length){
            result.add(new ArrayList<>(subset));
            System.out.println(subset);
            return;
        }
        subset.add(nums[i]);
        helper(nums, i+1, subset);
        subset.remove(subset.size()-1);
        helper(nums, i+1, subset);
    }
    public List<List<Integer>> subsets(int[] nums){
        List<Integer> temp = new ArrayList<>();
        helper(nums,0, temp);
        return result;
    }
    public static void main(String[] args) {
        Subsets78 s = new Subsets78();
        int[] arr = {1,2,3};
        int[] arr2 = {1,3};
        System.out.println(s.subsets2(arr2));
    }
}
