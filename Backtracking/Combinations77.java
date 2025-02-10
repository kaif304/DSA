package Backtracking;
import java.util.List;
import java.util.ArrayList;
// COMPLETED
public class Combinations77 {
    static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(list, 1, ans, n , k);
        return ans;
    }
    static void helper(List<Integer> list,int up, List<List<Integer>> ans,int n,int k){
        if(list.size() == k){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(up > n){
            return;
        }

        list.add(up);
        helper(list, up+1, ans, n, k);
        list.remove(list.size()-1);

        helper(list, up+1, ans, n, k);
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
        System.out.println(combine(1, 1));
    }
}
