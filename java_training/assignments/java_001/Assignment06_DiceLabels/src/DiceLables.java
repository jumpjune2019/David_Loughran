public class DiceLables {
	public static void main(String[] args) {
		String[][] multi = new String[][] {										//initializing the string matrix
			{ "", "Die 1", "Die 2", "Die 3", "Die 4", "Die 5", "Die 6" },
			{ "Die 1", "Snake Eyes", "Australian Yo", "Little Joe From Kokomo", "No field five", "Easy Six", "Six one you're done" },
			{ "Die 2", "Ace caught a deuce", "Ballerina", "The Fever", "Jimmie Hicks", "Benny Blue", "Easy Eight" },
			{ "Die 3", "Easy Four", "OJ", "Brooklyn Fores", "Big Red", "Eighter from Decatur", "Nina from Pasadena" },
			{ "Die 4", "Little Phoebe", "Easy Six", "Skinny McKinney", "Square Pair", "Railroad nine", "Big one on the end" },
			{ "Die 5", "Sixic from Dixie", "Skinny Dugan", "Easy Eight", "Jesse James", "Puppy paws", "Yo" },
			{ "Die 6", "The Devil", "Easy Eight", "Lou Brown", "Tennessee", "Six five no jive", "Midnight" }
		};
		System.out.println("Dice Combinations Label Matrix");					//initial print statement
		System.out.print(multi[0][0]);											//print each line seperately
		System.out.print("\t" + multi[0][1]);									//every line has its own spacing requirements
		System.out.print("\t\t\t" + multi[0][2]);
		System.out.print("\t\t" + multi[0][3]);
		System.out.print("\t\t\t" + multi[0][4]);
		System.out.print("\t\t" + multi[0][5]);
		System.out.print("\t\t\t" + multi[0][6]);
		System.out.println();
		
		System.out.print(multi[1][0]);
		System.out.print("\t" + multi[1][1]);
		System.out.print("\t\t" + multi[1][2]);
		System.out.print("\t" + multi[1][3]);
		System.out.print("\t" + multi[1][4]);
		System.out.print("\t" + multi[1][5]);
		System.out.print("\t\t" + multi[1][6]);
		System.out.println();
		
		System.out.print(multi[2][0]);
		System.out.print("\t" + multi[2][1]);
		System.out.print("\t" + multi[2][2]);
		System.out.print("\t" + multi[2][3]);
		System.out.print("\t\t" + multi[2][4]);
		System.out.print("\t" + multi[2][5]);
		System.out.print("\t\t" + multi[2][6]);
		System.out.println();
		
		System.out.print(multi[3][0]);
		System.out.print("\t" + multi[3][1]);
		System.out.print("\t\t" + multi[3][2]);
		System.out.print("\t\t" + multi[3][3]);
		System.out.print("\t\t" + multi[3][4]);
		System.out.print("\t\t" + multi[3][5]);
		System.out.print("\t" + multi[3][6]);
		System.out.println();
		
		System.out.print(multi[4][0]);
		System.out.print("\t" + multi[4][1]);
		System.out.print("\t\t" + multi[4][2]);
		System.out.print("\t" + multi[4][3]);
		System.out.print("\t\t" + multi[4][4]);
		System.out.print("\t" + multi[4][5]);
		System.out.print("\t\t" + multi[4][6]);
		System.out.println();
		
		System.out.print(multi[5][0]);
		System.out.print("\t" + multi[5][1]);
		System.out.print("\t" + multi[5][2]);
		System.out.print("\t" + multi[5][3]);
		System.out.print("\t\t" + multi[5][4]);
		System.out.print("\t" + multi[5][5]);
		System.out.print("\t\t" + multi[5][6]);
		System.out.println();
		
		System.out.print(multi[6][0]);
		System.out.print("\t" + multi[6][1]);
		System.out.print("\t\t" + multi[6][2]);
		System.out.print("\t" + multi[6][3]);
		System.out.print("\t\t" + multi[6][4]);
		System.out.print("\t" + multi[6][5]);
		System.out.print("\t" + multi[6][6]);
	}
}
