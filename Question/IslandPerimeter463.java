package Question;

public class IslandPerimeter463 {
    static int find(int[][] arr){
        int peri = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] == 1){
                    peri += 4;
                    if(j != 0 && arr[i][j-1] != 0){ // left
                        peri -= 1;
                    }if(j != arr[i].length-1 && arr[i][j+1] != 0){ // right
                        peri -= 1;
                    }if(i != 0 && arr[i-1][j] != 0){ // up
                        peri -= 1;
                    }if(i != arr.length-1 && arr[i+1][j] != 0){ // down
                        peri -= 1;
                    }
                }
            }
        }
        return peri;
    }
    public static void main(String[] args) {
        int[][] grid = {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}
        };
        System.out.println(find(grid));
    }
}
