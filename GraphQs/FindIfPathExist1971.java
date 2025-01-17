package GraphQs;
// COMPLETED
import java.util.*;
public class FindIfPathExist1971 {
    static boolean dfs(ArrayList<Integer>[] graph, int curr, int dest, boolean[] vis){
        if(curr == dest){
            return true;
        }
        vis[curr] = true;
        for (int i=0; i<graph[curr].size(); i++) {
            int e = graph[curr].get(i);

            if (!vis[e]) {
                if(dfs(graph, e, dest, vis)){
                    return true;
                }
            }
        }
        return false;
    }
    static boolean validPath2(int n, int[][] edges, int source, int destination) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        boolean[] vis = new boolean[n];
        return dfs(graph, source, destination, vis);
    }

    // Optimized iterative bfs
    static boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];

        q.offer(source);
        vis[source] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            if (node == destination) {
                return true;
            }
            for (int i=0; i<graph[node].size(); i++) {
                int e = graph[node].get(i);

                if (!vis[e]) {
                    vis[e] = true;
                    q.offer(e);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
//        int[][] graph = {{0,1},{1,2},{2,0}};
//        System.out.println(validPath(3, graph, 0, 2));

        int[][] graph2 = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        System.out.println(validPath(6, graph2, 0, 5));

        int[][] graph3 = {{4,3},{1,4},{4,8},{1,7},{6,4},{4,2},{7,4},{4,0},{0,9},{5,4}};
        System.out.println(validPath(10, graph3, 5, 9));
    }
}