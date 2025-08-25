package matrix;
// COMPLETED

public class MiniAreaToCoverAllOnesI3195 {
    static int minimumArea(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int top = m, bottom = -1;
        int left = m, right = -1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // for height
                    top = Math.min(top, i);
                    bottom = Math.max(bottom, i);

                    //for width
                    left = Math.min(left, j);
                    right = Math.max(right, j);
                }
            }
        }

        return (bottom - top + 1) * (right - left + 1);
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,0},{1,0,1}};
        System.out.println(minimumArea(grid));
    }
}
