package Arrays;
import java.util.HashMap;
// COMPLETED
public class CompletelyPaintedRowColumn2661 {
    static int firstCompleteIndex2(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        HashMap<Integer, Integer> row = new HashMap<>();
        HashMap<Integer, Integer> col = new HashMap<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                row.put(mat[i][j], i);
                col.put(mat[i][j], j);
            }
        }

        HashMap<Integer, Integer> rowCells = new HashMap<>();
        HashMap<Integer, Integer> colCells = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
//            int ele = arr[i];
//            int rowPosition = row.get(ele);
//            int colPosition = col.get(ele);

            rowCells.put(row.get(arr[i]), rowCells.getOrDefault(row.get(arr[i]), 0) + 1);
            colCells.put(col.get(arr[i]), colCells.getOrDefault(col.get(arr[i]), 0) + 1);

            if(rowCells.containsKey(row.get(arr[i])) && rowCells.get(row.get(arr[i])) == n) return i;
            if(colCells.containsKey(col.get(arr[i])) && colCells.get(col.get(arr[i])) == m) return i;
        }
        return -1;
    }

    // Well optimized by just replacing HashMap with Array
    static int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] row = new int[m * n + 1];
        int[] col = new int[m * n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[mat[i][j]] = i;
                col[mat[i][j]] = j;
            }
        }

        int[] rowCells = new int[m];
        int[] colCells = new int[n];

        for (int i = 0; i < arr.length; i++) {
            int r = row[arr[i]];
            int c = col[arr[i]];

            rowCells[r]++;
            colCells[c]++;

            if (rowCells[r] == n || colCells[c] == m) {
                return i;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {50,65,33,27,53,76,8,5,72,46,30,23,37,67,1,28,12,42,63,38,24,74,9,16,6,
                26,34,59,39,18,19,73,62,47,68,41,4,51,21,22,3,31,49,29,70,2,57,14,75,32,48,
                54,45,52,11,44,13,20,71,35,61,15,17,60,58,64,40,43,56,55,25,10,69,36,66,7};

        int[][] mat = {{60,4,63,69,10,68,9,17,76,57,41,74,52,30,50,35,19,51,11,
                14,42,55,49,21,2,39,15,70,26,45,46,53,34,29,22,8,1,13},
                {65,6,7,47,27,37,54,64,38,71,73,32,61,43,5,66,25,33,20,
                        18,16,75,72,56,58,12,67,24,3,31,59,62,28,48,44,23,36,40}};

        System.out.println(firstCompleteIndex(arr, mat));
    }
}
