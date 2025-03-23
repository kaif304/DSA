package GraphQs;
// COMPLETED
import java.util.ArrayList;
import java.util.HashSet;

public class PropertiesGraph3493 {
    static void createGraph(ArrayList<Integer>[] graph, int[][] properties, int k){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < properties.length; i++){ // node
            for(int j = 0; j < properties.length; j++){
                if(intersect(properties, i, j) >= k){
                    graph[i].add(j); // connection between i & j
                }
            }
        }
        System.out.println("Node connections : ");
        for (int i = 0; i < graph.length; i++) {
            System.out.println(i+" -> "+graph[i]);
        }
    }
    static int intersect(int[][] properties, int nodeA, int nodeB){
        HashSet<Integer> set = new HashSet<>();
        int common = 0;

        for(int num : properties[nodeA]){
            set.add(num);
        }

        for(int num : properties[nodeB]){
            if(set.contains(num)){
                common++;
                set.remove(num); // Ensures distinct count
            }
        }

        return common; // number of distinct common elements
    }
    static void dfs(ArrayList<Integer>[] graph, int curr, boolean[] vis){
        vis[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){
            int edge = graph[curr].get(i);

            if(!vis[edge]) dfs(graph, edge, vis);
        }
    }

    static int numberOfComponents(int[][] properties, int k) {
        int n = properties.length; // number of nodes

        ArrayList<Integer>[] graph = new ArrayList[n];

        createGraph(graph, properties, k);

        boolean[] vis = new boolean[n];
        int components = 0;

        for(int i = 0; i < n; i++){
            if(!vis[i]) {
                dfs(graph, i, vis);
                components++;
            }
        }

        return components;
    }

    public static void main(String[] args) {
        int[][] properties = {{1,2},{1,1},{3,4},{4,5},{5,6},{7,7}};
        int[][] properties2 = {{1,2,3},{2,3,4},{4,3,5}};

        System.out.println(numberOfComponents(properties, 1));
        System.out.println(numberOfComponents(properties2, 2));
    }
}
