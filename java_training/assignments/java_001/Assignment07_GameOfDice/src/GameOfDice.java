import java.util.Scanner;

public class GameOfDice {
	public static void main(String[] args) {
		String input = null;
		Scanner console = new Scanner(System.in);				//initializing Scanner for user input
		System.out.println("Welcome to the dice throw challenge!\nDo you feel lucky? Punk… Do ya?\nPress any key and ENTER to throw your dice or press (Q or q) to chicken your butt off…");
		input = console.nextLine();
		if (input.equalsIgnoreCase("q")){				//checking user input
			System.out.println("See ya later alligator!");
		} else {
			gamePlay();
		}
		while (!input.equalsIgnoreCase("q")) {		//allowing user to continue the program until they quit
		input =	playAgain(input);
		}
	}
	
	public static String getTag(int check1, int check2) {
		String[][] multi = new String[][] {										//initializing the string matrix
			{ "", "1", "2", "3", "4", "5", "6" },
			{ "1", "Snake Eyes", "Australian Yo", "Little Joe From Kokomo", "No field five", "Easy Six", "Six one you're done" },
			{ "2", "Ace caught a deuce", "Ballerina", "The Fever", "Jimmie Hicks", "Benny Blue", "Easy Eight" },
			{ "3", "Easy Four", "OJ", "Brooklyn Fores", "Big Red", "Eighter from Decatur", "Nina from Pasadena" },
			{ "4", "Little Phoebe", "Easy Six", "Skinny McKinney", "Square Pair", "Railroad nine", "Big one on the end" },
			{ "5", "Sixic from Dixie", "Skinny Dugan", "Easy Eight", "Jesse James", "Puppy paws", "Yo" },
			{ "6", "The Devil", "Easy Eight", "Lou Brown", "Tennessee", "Six five no jive", "Midnight" }
		};
		return multi[check1][check2];										//return tag line for dice roll
	}
	
	public static void gamePlay() {
		int playerDie1 = diceRoll();						//rolling player dice
		int playerDie2 = diceRoll();
		int eDie1 = diceRoll();								//rolling computer dice
		int eDie2 = diceRoll();
		int playerTotal = playerDie1 + playerDie2;			//get totals of dice
		int eTotal = eDie1 + eDie2;
		String pTag = getTag(playerDie1, playerDie2);		//get tag lines for dice rolls
		String eTag = getTag(eDie1, eDie2);
		
		//displaying results
		System.out.println("You have rolled " + playerDie1 + " and " + playerDie2 + " > the " + pTag);
		System.out.println("I have rolled " + eDie1 + " and " + eDie2 + " > the " + eTag);
		
		//checking for the winner and loser
		if (playerTotal > eTotal) {
			System.out.print("You Win!!!\nDid you cheat?? Gimme another try, c’mon ");
		} else if (eTotal > playerTotal) {
			System.out.print("I Win!!!\nWanna try again? ");
		} else if (playerTotal == eTotal) {							//on a tie a check for doubles is performed
			int pDCheck = doublesCheck(playerDie1, playerDie2);
			int eDCheck = doublesCheck(eDie1, eDie2);
			if (pDCheck == 1 & eDCheck == 0) {						//the double check also checks that the other player does not have a double
				System.out.print("Damn! You win on a Double! What Luck!\nDid you cheat?? Gimme another try, c’mon ");
			} else if (eDCheck == 1 & pDCheck == 0) {
				System.out.print("Damn! I win on a Double! Ah! I pity you fool!\nWanna try again? ");
			} else {
				System.out.print("Stalemate! You’re tough, let’s try for a tie-breaker ");
			}
		}
	}
	
	public static int doublesCheck(int check1, int check2) {			//doubles check returns a value for later purpose
		if (check1 == check2) {
			return 1;
		} else {
			return 0;
		} 
	}
	
	public static int diceRoll() {								//generates and returns random number from 1 to 6
		double rand = Math.floor((Math.random() * 6) + 1);
		return (int)rand;
	}
	
	public static String playAgain(String input) {
		Scanner console = new Scanner(System.in);				//initializing Scanner for user input
		System.out.println("Press any key and ENTER to throw your dice or press (Q or q) to quit");
		input = console.nextLine();
		if (input.equalsIgnoreCase("q")) {			//checking user input
			System.out.println("Thanks for being a sport! laters!");
		} else {
			gamePlay();
		}
		return input;
	}
}
