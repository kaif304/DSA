package Question;
import java.util.Arrays;
import java.util.HashSet;

public class MaxTotalImportanceOfRoads2285 {
    static void arraysSortMethod() {
        int[] connections = {3, 1, 4, 1, 5, 9, 2, 6, 5};
        Integer[] indices = new Integer[connections.length];

        // Initialize indices
        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }
        
        // Sort indices based on the values in connections array in descending order
        Arrays.sort(indices, (a, b) -> Integer.compare(connections[b], connections[a]));

        System.out.println(Arrays.toString(indices));

        // Output sorted indices and corresponding values
        System.out.println("Sorted indices based on values in the connections array:");
        for (int index : indices) {
            System.out.println("Index: " + index + ", Value: " + connections[index]);
        }
    }
    static long maximumImportance(int n, int[][] roads) {
        int[] connections = new int[n];

        for(int[] road : roads){
            connections[road[0]]++;
            connections[road[1]]++;
        }

        // Array to hold the city indices
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        // Sort cities based on the number of connections in descending order
        Arrays.sort(indices, (a, b) -> Integer.compare(connections[b], connections[a]));

        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[indices[i]] = n - i;
        }

        long valueSum = 0;
        for(int[] road : roads){
            valueSum += (long)(values[road[0]] + values[road[1]]);
        }

        return valueSum;
    }

    public static void main(String[] args) {
        int[][] cities = {{0,1},{1,2},{2,3},{0,2},{1,3},{2,4}};
        int[][] cities2 = {{0,3},{2,4},{1,3}};
        int[][] cities3 = {{0,1}};
        int[][] cities4 = {{3,2},{0,2}};
//        System.out.println(maximumImportance(5,cities3));

        arraysSortMethod();
    }
}
