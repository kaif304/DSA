package GraphQs;
// COMPLETED
import java.util.HashSet;
public class FindCityJudge997 {
    static int findJudge2(int n, int[][] trust) {
        int ans = -1;
        int[] arr = new int[n+1];
        for(int[] pair:trust){
            arr[pair[0]] = 1;
        }
        for(int i=1; i< arr.length; i++){
            if(arr[i] == 0){
                ans = i;
                break;
            }
        }

        HashSet<Integer> set = new HashSet<>();
        if(ans != -1){
            for(int[] pair:trust){
                if(pair[0] != ans && pair[1] == ans){
                    set.add(pair[0]);
                }
            }
            if(set.size() == n-1) return ans;
        }

        return -1;
    }
    static int findJudge(int n, int[][] trust) {
        int[] trustCount = new int[n+1];
        for(int[] pair:trust){
            trustCount[pair[0]] -= 1;
            trustCount[pair[1]] += 1;
        }
        for (int i = 1; i < trustCount.length; i++) {
            if(trustCount[i] == n-1) return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[][] edges = {{1,3},{1,4},{2,3},{2,4},{4,3}};
        System.out.println(findJudge(4,edges));

        int[][] edges2 = {{1,2},{2,3}};
        System.out.println(findJudge(3,edges2));
    }
}
