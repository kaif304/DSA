package GraphQs;
// COMPLETED

import java.util.ArrayList;
import java.util.List;
public class KeysAndRooms841 {
    static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] vis = new boolean[rooms.size()];
        dfs(rooms, 0, vis);

        for(boolean visited : vis){
            if(!visited) return false;
        }

        return true;
    }
    static void dfs(List<List<Integer>> graph, int curr, boolean[] vis){
        if(vis[curr]) return;
        vis[curr] = true;

        for(int i = 0; i < graph.get(curr).size(); i++){
            int edge = graph.get(curr).get(i);
            if(!vis[edge]){
                dfs(graph, edge, vis);
            }
        }
    }
    public static void main(String[] args) {
        // ((1,3),(3,0,1),(2),(0))-> edges
        //    0      1     2   3  -> nodes
        List<List<Integer>> rooms = new ArrayList<>();

        List<Integer> edgeList1 = new ArrayList<>();
        edgeList1.add(1);
        edgeList1.add(3);

        List<Integer> edgeList2 = new ArrayList<>();
        edgeList2.add(3);
        edgeList2.add(0);
        edgeList2.add(1);

        List<Integer> edgeList3 = new ArrayList<>();
        edgeList3.add(2);

        List<Integer> edgeList4 = new ArrayList<>();
        edgeList4.add(0);

        rooms.add(edgeList1);
        rooms.add(edgeList2);
        rooms.add(edgeList3);
        rooms.add(edgeList4);

        boolean canVisit = canVisitAllRooms(rooms);
        System.out.println(canVisit);
    }
}
