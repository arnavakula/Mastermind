package app.board;

import app.Constants;

public class Board{

    int rows, cols;
    Spot[][] board;
    public Board(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        board = getInitialBoard();
    }

    public static Spot[][] getInitialBoard(){
        //only used at the beginning of a game - creates instance of board
        // IMPORTANT: creates and returns a board as well

        Spot[][] board = new Spot[Constants.TURNS][Constants.SEQUENCE_LENGTH];
        board = new Spot[Constants.TURNS][Constants.SEQUENCE_LENGTH];
        for(int i = 0; i < Constants.TURNS; i++){
            for(int j = 0; j < Constants.SEQUENCE_LENGTH; j++){
                if(i == 0){
                    board[i][j] = new Spot(i, j, Constants.COMPUTER_CHAR);
                } else {
                    board[i][j] = new Spot(i, j, Constants.BLANK_CHAR);
                    if(i == Constants.TURNS && j == Constants.SEQUENCE_LENGTH){
                        return board;
                    }
                }
            }
        }
        return board;
    }

    public static void drawBoard(Spot[][] board){
        System.out.println();
        System.out.print(" ");
        for(int i = 0; i < Constants.BOARD_TOP_LENGTH; i++){
            System.out.print("-");
        }

        System.out.println();

        for(int i = 0; i < Constants.TURNS; i++){
            System.out.print("|");
            for(int j = 0; j < Constants.SEQUENCE_LENGTH; j++){
                System.out.print(" " + board[i][j].getColor());
            }
            System.out.print(" |");
            System.out.println();
        }

        
        System.out.print(" ");
        for(int i = 0; i < Constants.BOARD_TOP_LENGTH; i++){
            System.out.print("-");
        }

        System.out.println();
    }


}