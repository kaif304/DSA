package Backtracking;
// COMPLETED

public class ValidSudoku36 {
    static boolean isSafeToPlace(char[][] grid, int row, int col, char ch){
        // row/horizontal check
        for (int i = 0; i < 9; i++) {
            if(i != col && grid[row][i] == ch) return false;
        }

        // column/vertical check
        for (int i = 0; i < 9; i++) {
            if(i != row && grid[i][col] == ch) return false;
        }

        // 3 x 3 grid check
        int startRow = (row/3) * 3, startCol =  (col/3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if(i != row && j != col && grid[i][j] == ch) return false;
            }
        }

        return true;
    }
    static boolean dfs(char[][] grid, int row){
        if(row == 9) return true;

        for (int i = 0; i < 9; i++) {
            if(grid[row][i] != '.'){
                if(!isSafeToPlace(grid, row, i, grid[row][i])){
                    return false;
                }
            }
        }

        return dfs(grid, row+1);
    }
    static boolean isValidSudoku(char[][] board) {
        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
                if(board[row][col] != '.' && !isSafeToPlace(board, row, col, board[row][col])){
                    return false;
                }
            }
        }

        return true;
    }
    static boolean isValidSudoku2(char[][] board) {
        return dfs(board, 0);
    }
    public static void main(String[] args) {
        String[][] grid = // Output = true
                {{"5","3",".",".","7",".",".",".","."}
                ,{"6",".",".","1","9","5",".",".","."}
                ,{".","9","8",".",".",".",".","6","."}
                ,{"8",".",".",".","6",".",".",".","3"}
                ,{"4",".",".","8",".","3",".",".","1"}
                ,{"7",".",".",".","2",".",".",".","6"}
                ,{".","6",".",".",".",".","2","8","."}
                ,{".",".",".","4","1","9",".",".","5"}
                ,{".",".",".",".","8",".",".","7","9"}};

        // let's convert it to character grid according to question

        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = grid[i][j].charAt(0);
            }
        }

        String[][] grid2 =
                {{"8","3",".",".","7",".",".",".","."}
                ,{"6",".",".","1","9","5",".",".","."}
                ,{".","9","8",".",".",".",".","6","."}
                ,{"8",".",".",".","6",".",".",".","3"}
                ,{"4",".",".","8",".","3",".",".","1"}
                ,{"7",".",".",".","2",".",".",".","6"}
                ,{".","6",".",".",".",".","2","8","."}
                ,{".",".",".","4","1","9",".",".","5"}
                ,{".",".",".",".","8",".",".","7","9"}};

        char[][] board2 = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board2[i][j] = grid2[i][j].charAt(0);
            }
        }

        String[][] grid3 = {{".", ".", ".", ".", ".", ".", "5", ".", "."},
                            {".", ".", ".", ".", ".", ".", ".", ".", "."},
                            {".", ".", ".", ".", ".", ".", ".", ".", "."},
                            {"9", "3", ".", ".", "2", ".", "4", ".", "."},
                            {".", ".", "7", ".", ".", ".", "3", ".", "."},
                            {".", ".", ".", ".", ".", ".", ".", ".", "."},
                            {".", ".", ".", "3", "4", ".", ".", ".", "."},
                            {".", ".", ".", ".", ".", "3", ".", ".", "."},
                            {".", ".", ".", ".", ".", "5", "2", ".", "."}};

        System.out.println(isValidSudoku(board));
        System.out.println(isValidSudoku(board2));
    }
}
