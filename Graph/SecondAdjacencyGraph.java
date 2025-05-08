package Graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SecondAdjacencyGraph {
    static void createGraph(ArrayList<Integer>[] graph){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(1);

        graph[1].add(0);
        graph[1].add(2);
        graph[1].add(3);

        graph[2].add(1);
        graph[2].add(3);
        graph[2].add(4);

        graph[3].add(1);
        graph[3].add(2);

        graph[4].add(2);
    }

    static void bfs(ArrayList<Integer>[] graph, int V){
        boolean[] vis = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while(!q.isEmpty()){
            int curr = q.poll();

            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr] = true;

                q.addAll(graph[curr]); // add all its edges to queue
            }
        }
    }

    static void dfs(ArrayList<Integer>[] graph, int curr, boolean[] vis){
        if(vis[curr]) return;

        System.out.print(curr+" ");
        vis[curr] = true;

        for(int edge : graph[curr]){
            if(!vis[edge]){
                dfs(graph, edge, vis);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Integer>[] graph = new ArrayList[V];

        createGraph(graph);

//        bfs(graph, V);

        boolean[] vis = new boolean[V];
        dfs(graph, 0, vis);
    }
}
