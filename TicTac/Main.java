package TicTac;

import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void printBoard(char[][] board){
        for(int row=0; row<board.length; row++){
            for(int col=0; col<board[row].length; col++){
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }

    public static boolean haveWon(char[][] board, char player) {
        // check for rows
        for (char[] chars : board) {
            if (chars[0] == player && chars[1] == player && chars[2] == player) {
                return true;
            }
        }
        // check for col
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }
        //check for diagonal
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }
        return board[0][2] == player && board[1][1] == player && board[2][0] == player;
    }
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (char[] chars : board) {
            Arrays.fill(chars, ' ');
        }

        char player = 'X';
        boolean gameOver = false;
        Scanner sc = new Scanner(System.in);
        while(!gameOver){
            printBoard(board);
            System.out.println("Player " + player + " enter row,col: ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            if(board[row][col] == ' '){
                // place the element
                board[row][col] = player;
                gameOver = haveWon(board,player);
                if(gameOver){
                    System.out.println("Player "+player+" has won: ");
                }
                else{
                    player = (player=='X') ? '0' : 'X';
                }
            }
            else{
                System.out.println("Invalid move");
            }
        }
        printBoard(board);
    }


}
