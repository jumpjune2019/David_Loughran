import java.util.Scanner;

public class SimpleDie {
	
	public static void main(String[] args) {
		
		String input = null;
		Scanner console = new Scanner(System.in);				//initializing Scanner for user input
		System.out.println("Press any key and Enter to roll a die: ");
		input = console.nextLine();
		if (input != null) {									//checking user input
			int result = diceRoll();							//initializing variable with result of function 
			System.out.println("You have rolled a: " + result);	
		} else {
			System.out.println("Ok Goodbye.");
		}
		input = "y";
		while (input.equals("y") || input.equals("Y")) {		//allowing user to continue the program until they quit
		input =	playAgain(input);
		}
	}
	
	public static int diceRoll() {								//generates and returns random number from 1 to 6
		double rand = Math.floor((Math.random() * 6) + 1);
		return (int)rand;
	}
	
	public static String playAgain(String input) {
		Scanner console = new Scanner(System.in);				//initializing Scanner for user input
		System.out.println("Would you like to play again?\nPress Y or y then Enter. Or any other key then Enter to quit: ");
		input = console.nextLine();
		if (input.equals("y") || input.equals("Y")) {			//checking user input
			int result = diceRoll();							//initializing variable with result of function 
			System.out.println("You have rolled a: " + result);	
		} else {
			System.out.println("Ok Goodbye.");
		}
		return input;
	}
}