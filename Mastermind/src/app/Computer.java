package app;

import app.Constants;
import java.security.SecureRandom;
import java.util.Random;

public class Computer{
    Computer(int sequenceLength){
        sequenceLength = Constants.SEQUENCE_LENGTH;

    }

    public static String getRandomSequence(){
        int[] randomSequence  = new int[Constants.SEQUENCE_LENGTH];
        char[] colorSequence = new char[Constants.SEQUENCE_LENGTH];
        Random rand = new SecureRandom();

        //get int sequence
        while(true){
            for(int i = 0; i < Constants.SEQUENCE_LENGTH; i++){
            randomSequence[i] = rand.nextInt(8);
            // System.out.println("INT " + i + " is " + randomSequence[i]);
            colorSequence[i] = Constants.COLORS[randomSequence[i]];
            // System.out.println("CHAR " + i + " is " + colorSequence[i]);
            }

            String sequence = new String(colorSequence);
            // System.out.println("SEQUENCE IS " + sequence);

            if(App.isValidInput(sequence)){
                return sequence;
            }
        }
    }


}
