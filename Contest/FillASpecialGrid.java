package Contest;

import java.util.Arrays;
public class FillASpecialGrid {
     static int[][] specialGrid(int N) {
         int n = 1 << N; // 2^N
         int[][] grid = new int[n][n]; // n x n
         int number = 0;

         int half = n / 2;

         // top right quadrant
         // left = half, right = n - 1, up = 0, down = half - 1
         number = fill(grid, half, n-1, 0, half-1, number);

         // Bottom right quadrant
         // left = half, right = n - 1, up = half, down = n - 1
         number = fill(grid, half, n-1, half, n-1, number);

         // Bottom left quadrant
         // left = 0, right = half - 1, up = half, down = n - 1
         number = fill(grid, 0, half-1, half, n-1, number);

         // Top left quadrant
         // left = 0, right = half - 1, up = 0, down = half - 1
         number = fill(grid, 0, half-1, 0, half-1, number);

         return grid;
     }

     static int fill(int[][] grid, int left, int right, int up, int down, int num){
         while(up <= down && left <= right){
             // go down
             for(int i = up ; i<= down ; i++){
                 grid[i][right] = num;
                 num++;
             }
             right--;

             // go left
             if(left <= right){
                 for(int i = right ; i >= left ; i--){
                     grid[down][i] = num;
                     num++;
                 }
                 down--;
             }

             // go up
             if (left <= right && up <= down) {
                 for (int i = down; i >= up; i--) {
                     grid[i][left] = num++;
                 }
                 left++;
             }

             // go right
             if (up <= down) {
                 for (int i = left; i <= right; i++) {
                     grid[up][i] = num++;
                 }
                 up++;
             }
         }

         return num;
     }

    public static void main(String[] args) {
//         [[57,58,59,48,9,10,11,0],
//          [56,63,60,49,8,15,12,1],
//          [55,62,61,50,7,14,13,2],
//          [54,53,52,51,6,5,4,3],
//          [41,42,43,32,25,26,27,16],
//          [40,47,44,33,24,31,28,17],
//          [39,46,45,34,23,30,29,18],
//          [38,37,36,35,22,21,20,19]]

        // should be ->

//        [[63,60,51,48,15,12,3,0],
//         [62,61,50,49,14,13,2,1],
//         [59,56,55,52,11,8,7,4],
//         [58,57,54,53,10,9,6,5],
//         [47,44,35,32,31,28,19,16],
//         [46,45,34,33,30,29,18,17],
//         [43,40,39,36,27,24,23,20],
//         [42,41,38,37,26,25,22,21]]
        int[][] specialGrid = specialGrid(3);

        for(int[] row : specialGrid){
            System.out.println(Arrays.toString(row));
        }
    }
}
