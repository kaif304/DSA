package design.graphwithpathcalculator;

public class Edge {
    int source;
    int destination;
    int cost;

    public Edge(int source, int destination, int cost){
        this.source = source;
        this.destination = destination;
        this.cost = cost;
    }
}
