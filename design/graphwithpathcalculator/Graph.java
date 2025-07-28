package design.graphwithpathcalculator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Graph {
    ArrayList<Edge>[] graph;

    public Graph(int n, int[][] edges) {
        this.graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        createGraph(edges);
    }

    private void createGraph(int[][] edges){
        for(int[] edge : edges){
            int source = edge[0], destination = edge[1], cost = edge[2];
            Edge newEdge = new Edge(source, destination, cost);
            graph[source].add(newEdge);
        }
    }

    public void addEdge(int[] edge) {
        int source = edge[0], destination = edge[1], cost = edge[2];
        Edge newEdge = new Edge(source, destination, cost);
        graph[source].add(newEdge);
    }

    public void printGraph(){
        for(int i = 0; i < graph.length; i++){
            System.out.print(i+"-> ");
            for (int j = 0; j < graph[i].size(); j++) {
                Edge connection = graph[i].get(j);
                System.out.print("["+connection.source+", "+connection.destination+", "+connection.cost+"] ");
            }
            System.out.println();
        }
    }

    private void dijkstra(int src, int[] dis){
        boolean[] vis = new boolean[graph.length];

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));

        pq.add(new Pair(src, 0));

        while(!pq.isEmpty()){
            Pair curr = pq.remove();

            if(!vis[curr.node]){
                vis[curr.node] = true;

                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    int u = e.source;
                    int v = e.destination;
                    
                    if(dis[u] + e.cost < dis[v]){
                        dis[v] = dis[u] + e.cost;
                        pq.add(new Pair(v, dis[v]));
                    }
                }
            }
        }
    }

    public int shortestPath(int node1, int node2) {
        int[] distances = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(i != node1) distances[i] = Integer.MAX_VALUE;
        }

        dijkstra(node1, distances);

        if(distances[node2] == Integer.MAX_VALUE) return -1;

        return distances[node2];
    }
}

/*
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */
