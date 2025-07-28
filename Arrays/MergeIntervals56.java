package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals56 {
    static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();
        int i = 0;

        while(i < n){
            int j = i + 1;
            int start = intervals[i][0];
            int end = intervals[i][1];

            while(j < n && intervals[j][0] <=  end){
                end = Math.max(end, intervals[j++][1]);
            }

            ans.add(new int[]{start, end});
            i = j;
        }

        return ans.toArray(new int[ans.size()][]);
    }
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};

        int[][] result = merge(intervals);

        for(int[] pair : result){
            System.out.println(Arrays.toString(pair));
        }
    }
}
