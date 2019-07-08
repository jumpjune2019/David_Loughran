import java.util.Scanner;

public class PairOfDice {
	
	public static void main(String[] args) {
		
		String input = null;
		Scanner console = new Scanner(System.in);				//initializing Scanner for user input
		System.out.println("Press any key and Enter to roll some dice: ");
		input = console.nextLine();
		if (input != null) {									//checking user input
			gamePlay();
		} else {
			System.out.println("Ok Goodbye.");
		}
		input = "y";
		while (input.equals("y") || input.equals("Y")) {		//allowing user to continue the program until they quit
		input =	playAgain(input);
		}
	}
	
	public static void gamePlay() {
		int result1 = diceRoll();							//initializing variables with result of function
		int result2 = diceRoll();
		System.out.println("You have rolled the following: ");					//displaying results
		System.out.println("First Die: " + result1 + "\nSecond Die: " + result2);
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
			gamePlay();	
		} else {
			System.out.println("Ok Goodbye.");
		}
		return input;
	}
}