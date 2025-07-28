package design.graphwithpathcalculator;

public class GraphWithShortestPathCalculator2642 {
    public static void main(String[] args) {
        int[][] edges = {{0, 2, 5}, {0, 1, 2}, {1, 2, 1}, {3, 0, 3}};

        Graph g = new Graph(4, edges);

        System.out.println(g.shortestPath(3, 2)); // return 6. The shortest path from 3 to 2 in the first diagram above is 3 -> 0 -> 1 -> 2 with a total cost of 3 + 2 + 1 = 6.
        System.out.println(g.shortestPath(0, 3)); // return -1. There is no path from 0 to 3.

        g.addEdge(new int[]{1, 3, 4}); // We add an edge from node 1 to node 3, and we get the second diagram above.

        System.out.println(g.shortestPath(0, 3)); // return 6. The shortest path from 0 to 3 now is 0 -> 1 -> 3 with a total cost of 2 + 4 = 6.

//        g.printGraph();
    }
}
