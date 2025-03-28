package GraphQs;
// TLE
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountVisitedNodes2876 {
    static void createGraph(ArrayList<Integer>[] graph, List<Integer> edges){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
            graph[i].add(edges.get(i));
        }
        for (int i = 0; i < graph.length; i++) {
            System.out.println(i+" : "+graph[i]);
        }
    }
    static void dfs(ArrayList<Integer>[] graph, int curr, int src, boolean[] vis, int[] res){
        if(vis[curr]) return;

        vis[curr] = true;
        res[src] += 1;

        if(!graph[curr].isEmpty()){
            int destination = graph[curr].get(0);
            dfs(graph, destination, src, vis, res);
        }
    }
    static void dfs2(ArrayList<Integer>[] graph, int curr, int src, boolean[] vis, int[] res, int[] dp){
        if(vis[curr]) return;

        vis[curr] = true;
        res[src] += 1;

        if(!graph[curr].isEmpty()){
            int destination = graph[curr].get(0);
            dfs(graph, destination, src, vis, res);
        }
    }
    static int[] countVisitedNodes(List<Integer> edges) {
        int n = edges.size(); // number of nodes
        int[] result = new int[n];

        ArrayList<Integer>[] graph = new ArrayList[n];
        createGraph(graph, edges);

        for (int i = 0; i < n; i++) {
            boolean[] vis = new boolean[n];
            dfs(graph, i, i, vis, result);
        }

        return result;
    }
    public static void main(String[] args) {
        List<Integer> edges = new ArrayList<>();
        edges.add(1); edges.add(2); edges.add(0); edges.add(0);

        System.out.println(Arrays.toString(countVisitedNodes(edges)));
    }
}
