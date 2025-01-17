package Graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    static class Edge{
        int src;
        int dest;
        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }
    static void createGraph(ArrayList<Edge>[] graph){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));
    }
    static void bfs(ArrayList<Edge>[] graph, int V){
        boolean[] vis = new boolean[V]; // to track visited nodes

        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while(!q.isEmpty()){
            int curr = q.poll();
            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr] = true;
                for(int i=0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    // if graph has components
    static void bfs2(ArrayList<Edge>[] graph, boolean[] vis, int startPoint){
        Queue<Integer> q = new LinkedList<>();
        q.add(startPoint);

        while(!q.isEmpty()){
            int curr = q.poll();
            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr] = true;
                for(int i=0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    public static void main(String[] args) {
        int V = 7;
        /*
              1 --- 3
             /      | \
            0       |  5 --- 6
             \      | /
              2 --- 4
        */
//        ArrayList<Edge>[] graph = new ArrayList[V];
//        createGraph(graph);
//        bfs(graph, V);

        boolean[] vis = new boolean[V]; // to track visited nodes
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        bfs2(graph, vis,0);
        bfs2(graph, vis,4);
    }
}
