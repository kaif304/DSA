package TreeQs;
import java.util.ArrayList;
// TLE
public class DFSStringsArePalindrome3327 {
    static void createTree(ArrayList<Integer>[] tree, int[] parent){
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 1; i < tree.length; i++) {
            int node = parent[i]; // i is node's childNode
            tree[node].add(i);
        }
        for(int i=0; i< tree.length; i++){
            System.out.println(i + " -> " + tree[i]);
        }
    }
    static boolean isPal(String s){
        int l = 0, r = s.length()-1;
        while(l < r){
            if(s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
    static boolean[] findAnswer(int[] parent, String s) {
        int n = parent.length;
        // Creating tree form of given nodes
        ArrayList<Integer>[] tree = new ArrayList[n];
        createTree(tree, parent);

        boolean[] ans = new boolean[n];
        // dfs
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            dfs(tree, i, sb, s);
            System.out.println(i + " -> " + sb);
            ans[i] = isPal(sb.toString());
        }

        return ans;
    }
    static void dfs(ArrayList<Integer>[] tree, int curr, StringBuilder sb, String s){
        for(int child : tree[curr]){
            dfs(tree, child, sb, s);
        }
        sb.append(s.charAt(curr));
    }

    public static void main(String[] args) {
        int[] parent = {-1,0,0,1,1,2};
        findAnswer(parent, "aababa");
    }
}
