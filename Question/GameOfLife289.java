package Question;

public class GameOfLife289 {
    static void gameOfLife(int[][] board){
        int[][] copy = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            System.arraycopy(board[i], 0, copy[i], 0, board[0].length);
        }

        for (int i = 0; i < copy.length; i++) {

            for (int j = 0; j < copy[0].length; j++) {

                int sum = sumOfNeighbors(copy, i, j);

                if(copy[i][j] == 1){

                    if(sum < 2 || sum > 3){
                        board[i][j] = 0;
                    }
                    else{
                        board[i][j] = 1;
                    }

                }
                else{
                    if(sum == 3){
                        board[i][j] = 1;
                    }
                }
            }
        }
    }

    static int sumOfNeighbors(int[][] copy, int i, int j){
        int rl = copy.length-1; // row length
        int cl = copy[0].length-1; // column length
        int sum = 0;

        if(j != 0){ sum += copy[i][j-1]; }
        if(j != cl){ sum += copy[i][j+1]; }

        if(i != 0){ sum += copy[i-1][j]; }
        if(i != rl){ sum += copy[i+1][j]; }

        if(i != 0 && j != 0){ sum += copy[i-1][j-1]; }
        if(i != 0 && j != cl){ sum += copy[i-1][j+1]; }

        if(i != rl && j != 0){ sum += copy[i+1][j-1]; }
        if(i != rl && j != cl){ sum += copy[i+1][j+1]; }

        return sum;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
        };
        gameOfLife(arr);
        for(int[] array:arr){
            for(int e:array){
                System.out.print(e+" ");
            }
            System.out.println();
        }
    }
}
