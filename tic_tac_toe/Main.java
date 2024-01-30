package com.tic_tac_toe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        // create our board
        for(int row = 0; row<board.length;row++){
            for (int col = 0; col < board[row].length ; col++) {
                board[row][col] = ' ';
            }
        }
        System.out.println("------------------------");
        System.out.println(" WELCOME to TIC TAC TOE ");
        System.out.println("------------------------");
        char player = 'x';
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);

        while(!gameOver){
            printBoard(board);
            System.out.println("Player "+player+" enter: ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            if(board[row][col] == ' '){
                // place the element
                board[row][col] = player;
                gameOver = haveWon(board, player);
                if(gameOver){
                    System.out.println("--------------------------------");
                    System.out.println("    PLAYER "+player+" HAS WON    ");
                    System.out.println("--------------------------------");

                } else {
                    if(player =='x'){
                        player = 'O';
                    }else{
                        player = 'x';
                    }
                }
            }
            else{
                System.out.println("Invaild move. Try again!");
            }
        }
        printBoard(board);
    }

    private static boolean haveWon(char[][] board, char player) {
        //check the row -wise
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1]== player && board[row][2]==player) {
                return true;
            }
        }

        // check column - wise
        for (int col = 0; col < board[0].length ; col++) {
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player){
                return true;
            }
        }

        // check diagonal wise;
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }

        if(board[2][0] == player && board[1][1] == player && board[0][2] == player ){
            return true;
        }

        return false;

    }

    public static void printBoard(char[][] board){
        for(int row = 0; row<board.length;row++){
            for (int col = 0; col < board[row].length ; col++) {
                System.out.print(board[row][col]+ " | ");
            }
            System.out.println();
        }
    }
}
