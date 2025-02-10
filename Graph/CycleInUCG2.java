package Graph;
import java.util.ArrayList;

public class CycleInUCG2 {
    static void createGraph(ArrayList<Integer>[] graph){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(1);
        graph[0].add(2);

        graph[1].add(0);
        graph[1].add(2);
        graph[1].add(3);

        graph[2].add(0);
        graph[2].add(1);
        graph[2].add(4);

        graph[3].add(1);
        graph[3].add(4);
        graph[3].add(5);

        graph[4].add(2);
        graph[4].add(3);
        graph[4].add(5);

        graph[5].add(3);
        graph[5].add(4);
        graph[5].add(6);
    }
    static boolean isCycle(ArrayList<Integer>[] graph, int curr, int parent, boolean[] vis){
        vis[curr] = true;
        for(int neighbor:graph[curr]){
            if(vis[neighbor] && neighbor != parent){
                return true;
            }
            if(!vis[neighbor]) {
                if (isCycle(graph, neighbor, curr, vis)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 7;
        boolean[] vis = new boolean[V];
        ArrayList<Integer>[] graph = new ArrayList[V];
        createGraph(graph);
        System.out.println(isCycle(graph,0,-1,vis));
    }
}
