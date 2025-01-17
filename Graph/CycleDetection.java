package Graph;

import java.util.ArrayList;

public class CycleDetection {
    public class Edge{
        int src;
        int destination;
        public Edge(int s, int d){
            this.src = s;
            this.destination = d;
        }
    }

    public void createGraph(ArrayList<Edge>[] graph){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,2));
        graph[1].add(new Edge(1,0));
        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,0));
    }

    public boolean detectCycle(ArrayList<Edge>[] graph, int curr, boolean[] vis, boolean[] rStack){
        vis[curr] = true;
        rStack[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(rStack[e.destination]){
                return true;
            }
            else if(!vis[e.destination] && detectCycle(graph, e.destination, vis, rStack)){
                return true;
            }
        }
        rStack[curr] = false;
        return false;
    }
    public static void main(String[] args) {
        CycleDetection obj = new CycleDetection();

        int v = 4;
        boolean[] vis = new boolean[v];
        boolean[] rStack = new boolean[v];

        ArrayList<Edge>[] graph = new ArrayList[v];
        obj.createGraph(graph);
        System.out.println(obj.detectCycle(graph, 0, vis, rStack));

        // Below implementation is used for non-connected components of graph
//        for (int i = 0; i < v; i++) {
//            if(!vis[i]){
//                boolean cycle = obj.detectCycle(graph, 0, vis, rStack);
//                if(cycle) System.out.println(cycle);
//                break;
//            }
//        }

    }
}
