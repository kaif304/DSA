package Graph;
import java.util.ArrayList;

// Cycle detection in an Undirected Cyclic Graph
public class CycleInUCG {
    static void createGraph(ArrayList<Integer>[] graph){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(1);
        graph[0].add(2);

        graph[1].add(3);
        graph[1].add(0);

        graph[3].add(5);
        graph[3].add(1);

        graph[5].add(3);
        graph[5].add(4);
        graph[5].add(6);

        graph[4].add(5);
        graph[4].add(2);

        graph[2].add(4);
        graph[2].add(0);
    }

    static boolean detectCycle(ArrayList<Integer>[] graph, int curr, boolean[] vis, int parent){
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            int destination = graph[curr].get(i);
            if(vis[destination] && destination != parent){
                return true;
            }
            if(!vis[destination]){
                if(detectCycle(graph, destination, vis, curr)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int v = 7;
        boolean[] vis = new boolean[v];
        ArrayList<Integer>[] graph = new ArrayList[v];
        createGraph(graph);

        System.out.println(detectCycle(graph, 0, vis, -1));
    }
}
