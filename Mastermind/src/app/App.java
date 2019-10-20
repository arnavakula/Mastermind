package app;

import java.util.Scanner;
import app.Constants;
import app.Computer;

public class App {

    public static void main(String[] args) { 
        Scanner scan = new Scanner(System.in);
        String input = getUserInput(scan);
        System.out.println(isValidInput(input));
        Computer.getRandomSequence();
       
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