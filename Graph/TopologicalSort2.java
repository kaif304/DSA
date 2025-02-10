package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort2 {
    static void createGraph(ArrayList<Integer>[] graph){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[5].add(0);
        graph[5].add(2);

        graph[2].add(3);

        graph[3].add(1);

        graph[4].add(0);
        graph[4].add(1);
    }
    static void topSortUtil(ArrayList<Integer>[] graph, int curr, boolean[] vis, Stack<Integer> stack){
        vis[curr] = true;
        for (int edge : graph[curr]) {
            if(!vis[edge]){
                topSortUtil(graph, edge, vis, stack);
            }
        }
        stack.push(curr);
    }
    static void topSort(ArrayList<Integer>[] graph){
        int V = graph.length;
        Stack<Integer> stack = new Stack<>();
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if(!vis[i]){
                topSortUtil(graph,i,vis,stack);
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
    static void printGraph(ArrayList<Integer>[] graph){
        for (int i = 0; i < graph.length; i++) {
            System.out.print(i+" = ");
            for (int j = 0; j < graph[i].size(); j++) {
                System.out.print(graph[i].get(j)+",");
            }
            System.out.println();
        }
    }
    public static void main(String [] args){
        int V = 6;
        ArrayList<Integer>[] graph = new ArrayList[V];
        createGraph(graph);
        topSort(graph);
    }
}
