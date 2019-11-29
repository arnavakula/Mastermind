package app;

import java.util.ArrayList;
import java.util.Scanner;

import app.board.Board;
import app.board.Spot;

public class App {

    public static void main(String[] args) { 
        Spot[][] board = Board.getInitialBoard();
        Scanner scan = new Scanner(System.in);
        String input;
        String compMove = Computer.getRandomSequence();
    
        int[] results = new int[2];
        boolean isGameOver = false;

        System.out.println("The computer has chosen a move: ");
        while(!isGameOver){
            for(int i = 0; i < Constants.TURNS; i++){
                Board.drawBoard(board);
                if(i != 0){System.out.println(i + " Exact ones: " + results[0] + " | Different spot: " + results[1]);}
                input = getUserInput(scan);
                results = checkGuess(input, compMove);
                if(results[1] == 0 && results[0] == Constants.SEQUENCE_LENGTH){
                    handleWin();
                    isGameOver = true;
                    break;
                } else if(i == Constants.TURNS){
                    System.out.println("GAME IS OVER");
                    handleLoss(compMove);
                    isGameOver = true;
                    break;
                }
                setNewRow(input, i, board);
            }
        }
        
        scan.close();
    }

    public static void handleWin(){
        System.out.println("Congratulations you won I guess");
    }

    public static void handleLoss(String compMove) {
        System.out.println();
        System.out.println("The computer's sequence was " + compMove);
        System.out.println("Better luck next time I guess");
    }

    public static int[] checkGuess(String input, String compMove){
        int[] results = {0, 0};
        ArrayList<Character> doubleCheck = new ArrayList<Character>(); //exact 0, same loc. 1
      
        for(int i = 0; i < Constants.SEQUENCE_LENGTH; i++){ //handles input
            for(int j = 0; j < Constants.SEQUENCE_LENGTH; j++){ //handles compMove
                if(i == j && input.charAt(i) == compMove.charAt(j)){
                    // System.out.println("EXACT MATCH FOR " + input.charAt(i));
                    results[0]++;
                } else if(i != j && input.charAt(i) == compMove.charAt(j)){
                    // System.out.println("WRONG LOCATION FOR " + input.charAt(i));
                    results[1]++;
                }
            }
        }


        return results;
    }

    public static void setNewRow(String input, int row, Spot[][] board){
        for(int i = 0; i < Constants.SEQUENCE_LENGTH; i++){
            board[Constants.TURNS - 1 - row][i].setSpotColor(input.charAt(i));
        }
    }

    public static String getUserInput(Scanner scan){
        String input;

        System.out.println("These are the valid options: red(r), green, blue(b), yellow(y), silver(s), orange(o), purple(p), white(w)");
        while (true){
            System.out.print("Please enter your input: ");
            input = scan.nextLine();
            input = input.toLowerCase();
            if(isValidInput(input)){
                return input;
            }
        }
    }

    public static boolean isValidInput(String s){
        boolean isValid = false;
        
        if(s.length() != Constants.SEQUENCE_LENGTH || hasDuplicates(s)){
            return false;
        }

        for(int i = 0; i < 4; i++){
            isValid = false;
            for(int j = 0; j < Constants.COLORS.length; j++){
                if(s.charAt(i) == Constants.COLORS[j]){
                    isValid = true;
                    break;
                }
            }
            // --> break enters here
            if(!isValid){ return false; }
            if(i == 4){ return isValid; }
        }

        return true;
    }

    public static boolean hasDuplicates(String s){
        for(int i = 0; i < s.length(); i++){
            if(i == 4){ break; } //for index errors - C++ formatting technique lol
            for(int j = i + 1; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j)){
                    return true;
                }
            }
        }

        return false;
    }




}