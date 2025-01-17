package RecursionQs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class KthPermutation {
    static String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> nums = new ArrayList<>();
        int[] fact = new int[n + 1]; // fact[i] := i!

        for (int i = 1; i <= n; ++i)
            nums.add(i);

        Arrays.fill(fact, 1);
        for (int i = 2; i <= n; ++i)
            fact[i] = fact[i - 1] * i;

        --k; // 0-indexed

        for (int i = n - 1; i >= 0; --i) {
            final int j = k / fact[i];
            k %= fact[i];
            sb.append(nums.get(j));
            nums.remove(j);
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        KthPermutation obj = new KthPermutation();
        System.out.println(obj.ans(9,138270));
        System.out.println(getPermutation(9,138270));
    }
    public ArrayList<String> list = new ArrayList<>();

    public String getString(int n){
        StringBuilder string = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            string.append(i);
        }
        return string.toString();
    }
    public String ans(int n, int k){
        String string = getString(n);
        permutations("", string,k);
        Collections.sort(list);
        String fAns = list.get(k-1);
//        System.out.println(list);
        return fAns;
    }

    public void permutations(String p, String up,int k){
//        if(list.size() >= k){
//            return;
//        }
        if(up.isEmpty()){
            list.add(p);
            return;
        }

        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i);
            permutations( f+up.charAt(0)+s, up.substring(1),k);
        }
    }
}
