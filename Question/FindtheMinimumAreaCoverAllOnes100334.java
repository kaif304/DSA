package Question;
public class FindtheMinimumAreaCoverAllOnes100334 {
    static int minimumArea(int[][] grid) {
        int len = grid.length;
        int[] row = new int[len];
        int[] col = new int[grid[0].length];

        for(int i= 0; i<len; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for(int i:row){
            System.out.print(i+",");
        }
        System.out.println();
        for(int i:col){
            System.out.print(i+",");
        }
        int fr = -1;
        int lr = -1;

        int fc = -1;
        int lc = -1;

        for(int i=0; i<row.length; i++){
            if(row[i] == 1){
                lr = i;
            }
            if(fr < 0 && row[i] != 0){
                fr = i;
            }
        }
        for(int i=0; i<col.length; i++){
            if(col[i] == 1){
                lc = i;
            }
            if(fc < 0 && col[i] != 0){
                fc = i;
            }
        }
        return ((lr - fr) + 1) * ((lc - fc) + 1);
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,0},{1,0,1}};
        int[][] grid2 = {{0,0},{1,0}};
        System.out.println(minimumArea(grid));
    }
}
