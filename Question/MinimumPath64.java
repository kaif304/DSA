package Question;

public class MinimumPath64 {
    static int min = Integer.MAX_VALUE;

    // DP Solution
    static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        // Initialize the starting point
        dp[0][0] = grid[0][0];

        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // Fill the DP table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m - 1][n - 1];
    }
    static void helper(int[][] grid,int i, int j, int sum){
        sum += grid[i][j];
        if(i == grid.length-1 && j == grid[0].length-1){
            min = Math.min(min, sum);
            return;
        }
        if(j < grid[0].length-1){
            helper(grid, i, j+1, sum);
        }
        if(i < grid.length-1){
            helper(grid, i+1, j, sum);
        }
        sum -= grid[i][j];
    }
    public static void main(String[] args) {
        int[][] grid = {{1,2},{1,1}};
        System.out.println(minPathSum(grid));
    }
}
