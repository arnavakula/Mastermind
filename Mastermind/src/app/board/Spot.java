package app.board;

import app.Constants;


public class Spot{
    private int row;
    private int col;
    private char color;

    public Spot(int row, int col, char color){
        this.row = row;
        this.col = col;
        this.color = color;
    }

    //getter methods
    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    public char getColor(){
        return color;
    }

    //setter methods
    public void setSpotColor(char c){
        this.color = c;
    }

    public void setRowColors(String input, int r, Spot[][] board){
        for(int i = 0; i < Constants.SEQUENCE_LENGTH; i++){
            board[r][i].setSpotColor(input.charAt(i));
        }
    }
}