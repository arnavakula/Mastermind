package app;

public class Constants{
	//change for varying difficulty - maybe get user to decide difficulty within parameters 
    public static int SEQUENCE_LENGTH = 4;
    public static int TURNS = 10 + 1; //+1 is for the last row(comp row)
    public static char[] COLORS = {'r', 'g', 'b', 'y', 's', 'o', 'p', 'w'};
    public static int BOARD_TOP_LENGTH = 2 * SEQUENCE_LENGTH + 1;
    public static char BLANK_CHAR = '.';
    public static char COMPUTER_CHAR = '*';
}