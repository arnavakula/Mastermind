package app;

import app.Constants;

public class Computer{
    Computer(int sequenceLength){
        sequenceLength = Constants.SEQUENCE_LENGTH;

    }

    public static String getRandomSequence(){
        int[] randomSequence  = new int[Constants.SEQUENCE_LENGTH];
        char[] colorSequence = new char[Constants.SEQUENCE_LENGTH];
        boolean current = false;
        

        //get int sequence
        while(!current){
            for(int i = 0; i < Constants.SEQUENCE_LENGTH; i++){
            randomSequence[i] = (int) (Math.random() * ((Constants.COLORS.length - 2) + 1) + 1);
            System.out.println("INT " + i + " is " + randomSequence[i]);
            colorSequence[i] = Constants.COLORS[i];
            System.out.println("CHAR " + i + " is " + colorSequence[i]);
            }

            String sequence = new String(colorSequence);
            System.out.println("SEQUENCE IS " + sequence);

            if(App.isValidInput(sequence)){
                
                current = true;
            }
        }



        return "hi";
        // 0.3 * 
    }


}