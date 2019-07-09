package phone;
import java.util.Scanner;
import java.io.*;


public class phone {
	public static void main(String[] args) {
		String[][] phoneBook = new String[][] {			//initialize 2D array with blank data
			{"Name", "Phone", "City"},
			{"0", "0", "0"},
			{"0", "0", "0"},
			{"0", "0", "0"},
			{"0", "0", "0"},
			{"0", "0", "0"}
		};
		String inputName = null;						//initialize input variables with no data
		String inputPhone = null;
		String inputCity = null;
		Scanner console = new Scanner(System.in);
		
		for (int a=1; a<6; a++) {
			int x=0;
			
			System.out.print("Enter Name: ");				
			inputName = console.nextLine();					//get name data
			inputName = baseCheck(inputName, "Name");		//check if user actually put dat and query them if they didn't
			
			System.out.print("Enter Phone: ");
			inputPhone = console.nextLine();				//get phone data
			inputPhone = baseCheck(inputPhone, "Phone");	//check data as above
			
			System.out.print("Enter City: ");
			inputCity = console.nextLine();					//get city data
			inputCity = baseCheck(inputCity, "City");		//check data as above

			System.out.print("You put " + inputName + " " + inputPhone + " " + inputCity + ". Did you want to keep that?\nType y or n then Enter: ");
			String inC = console.nextLine();				//query user if they are satisfied with their data entry
			if (inC.equalsIgnoreCase("y")) {
				System.out.println("Confirmed");			//confirm entry
			} else {
				inputName = confirm(inputName, "Name");		//get new data
				inputPhone = confirm(inputPhone, "Phone");	//
				inputCity = confirm(inputCity, "City");		//
				System.out.println("Updated");				//confirm change
			}
			phoneBook[a][x] = inputName;					//add data to array
			phoneBook[a][x+1] = inputPhone;
			phoneBook[a][x+2] = inputCity;
		}
		putInFile(phoneBook);								//print data and write it to file
	}
	
	public static void putInFile(String[][] book) {		
		try (FileWriter fw = new FileWriter("phone.txt")) {			//initialize file writer
			for (int a=0; a<6; a++) {
				for (int x=0; x<3; x++) {
					fw.append(String.format("%-30s", book[a][x]));		//cell by cell write data to file
				}
				fw.append("\r\n");
			}
			for (int a=0; a<6; a++) {
				for (int x=0; x<3; x++) {
					System.out.printf("%-30s", book[a][x]);			//cell by cell print data
				}
				System.out.println();
			}
		} catch (IOException exc) {
			System.out.println("I/O Error: " + exc);				//error catching on file write
		}
	}
	
	public static String baseCheck(String inputU, String stage) {
		Scanner console = new Scanner(System.in);
		if (inputU.isEmpty()) {
			System.out.print("You forgot that " + stage + ". Try again: ");		//query user to put data
			inputU = console.nextLine();										//get data
		}
		return inputU;															//send data
	}
	
	public static String confirm(String passedInput, String type) {
		Scanner console = new Scanner(System.in);
		System.out.print("Enter the " + type + ": ");							//
		passedInput = console.nextLine();										//Get desired up to date data
		passedInput = baseCheck(passedInput, type);								//query again for missing information
		return passedInput;														//send data
	}
}
