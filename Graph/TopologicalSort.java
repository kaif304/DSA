package Graph;
import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    static class Edge{
        int src, destination;
        public Edge(int s, int d){
            this.src = s;
            this.destination = d;
        }
    }
    static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,0));
        graph[1].add(new Edge(1,1));

        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));
    }

    static void topologicalSort(ArrayList<Edge>[] graph,int curr,boolean[] vis, Stack<Integer> stack){
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.destination]){
                topologicalSort(graph, e.destination, vis, stack);
            }
        }
        stack.push(curr);
    }

    public static void main(String[] args) {
        int v = 6;
        boolean[] vis = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);

        for(int i=0; i<v; i++){
            topologicalSort(graph, i, vis, stack);
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
}
