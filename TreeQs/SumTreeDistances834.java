package TreeQs;
// Correct but having TLE

import java.util.Arrays;
import java.util.ArrayList;
public class SumTreeDistances834 {
    static void createTree(ArrayList<Integer>[] tree, int[][] edges){
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int ai = edge[0];
            int bi = edge[1];
            tree[ai].add(bi);
            tree[bi].add(ai);
        }
        System.out.println("Generated Tree:");
        for(int i=0; i< tree.length; i++){
            System.out.println(i+" -> "+tree[i]);
        }
    }
    static int[] sumOfDistancesInTree(int n, int[][] edges) {
        int[] ans = new int[n];
        boolean[] vis = new boolean[n];

        ArrayList<Integer>[] tree = new ArrayList[n];
        createTree(tree, edges);

        for(int i=0; i<n; i++){
            dfs(tree, i, 0, vis, ans);
        }

        System.out.println(Arrays.toString(ans));

        return ans;
    }

    static void dfs(ArrayList<Integer>[] tree, int curr, int dis, boolean[] vis, int[] ans){
        System.out.print(curr+" ");
        vis[curr] = true;
        ans[curr] += dis;

        for(int e : tree[curr]){
            if(!vis[e]){
                dfs(tree, e, dis+1, vis, ans);
            }
        }
        vis[curr] = false;
    }
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0,1},{0,2},{2,3},{2,4},{2,5}};
        System.out.println(Arrays.toString(sumOfDistancesInTree(n, edges)));
    }
}
