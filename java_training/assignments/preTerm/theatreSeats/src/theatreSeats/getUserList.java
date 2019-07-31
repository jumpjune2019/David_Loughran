package theatreSeats;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class getUserList {
	static Scanner console = new Scanner(System.in);			//initializing Scanner for user input
	//Get user input	
	public static void getInput() throws IOException {
		String input = null;
		System.out.println("L - Login/Logout\nR - Register\nQ - Quit\nMake your selection then press Enter: ");
			input = console.nextLine();

		//Loop user input until proper selection is made
		boolean exitLoop = false;
		while (!exitLoop) {	
			switch (input.toUpperCase()) {
			  case "Q":
			    System.out.println("Have a nice day!");
			    exitLoop = true;
			    break;
			  case "L":
			    getLogin();
			    exitLoop = true;
			    break;
			  case "R":
			    System.out.println("Not added yet :D");
			    //Successfully add a line to a file without over writing
			    writeToFile.addToFile();
			    exitLoop = true;
			    break;
			  default:
			    System.out.println("Invalid input, please try again: ");
			    input = console.nextLine();
			}
		}
	}
	
	//Get the user ID
	public static void getLogin() throws IOException {
		System.out.println("Enter your User ID: ");
		String userID = console.nextLine();
		getList(userID);
	}
	
	//read in file
	public static void getList(String fName) throws IOException {
		String filePath = "c:\\Java_training\\assignments\\preTerm\\theatreSeats\\userList.csv";
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String line = reader.readLine();
		String[] record = line.split(",");
		String[][] seat = new String[11][11];
		for (int a=0; a<25; a++) {
			line = reader.readLine();
			record = line.split(",");
			//Booking Seats
			seat = roomTest.getSeats(record[0], record[2], record[1]);
			
			/*System.out.println(Arrays.toString(record));
			if (fName.equals(record[2])) {
				System.out.println("FOUND IT!!!");
				break;
			}*/
		}
		reader.close();
		//Fill vacant seats and print results
		roomTest.fillVacant(seat);
		printSeats(seat);
		System.out.println("\n");
		listTest.printList();

	}
	//Print the view of the seats
	public static void printSeats(String[][] seat) {
		for (int a=0; a<11; a++) {
			for (int b=0; b<11; b++) {
				System.out.printf("%-20s",seat[a][b]);
			}
			System.out.println();
		}
	}
}
