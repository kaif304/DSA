package GraphQs;
// COMPLETED
import java.util.ArrayList;
import java.util.List;
public class AllPathsSrcToTar797 {
    static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(graph, 0, graph.length-1, new ArrayList<>(), ans);

        return ans;
    }

    static void dfs(int[][] graph, int curr, int target, List<Integer> path, List<List<Integer>> ans){
        if(curr == target){
            path.add(curr);
            ans.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }
        path.add(curr);

        for (int neighbor : graph[curr]) {
            dfs(graph, neighbor, target, path, ans);
        }

        path.remove(path.size()-1);
    }

    static void dfs2(int[][] graph, int curr, int target, List<Integer> path, List<List<Integer>> ans){
        path.add(curr);

        if(curr == target){
            ans.add(new ArrayList<>(path));
        }
        else {
            for (int neighbor : graph[curr]) {
                dfs(graph, neighbor, target, path, ans);
            }
        }

        path.remove(path.size()-1); // backtrack
    }
    public static void main(String[] args) {
        int[][] graph = {{1,2},{3},{3},{}};
        int[][] graph2 = {{4,3,1},{3,2,4},{3},{4},{}};

//        System.out.println(allPathsSourceTarget(graph));
        System.out.println(allPathsSourceTarget(graph2));
    }
}
