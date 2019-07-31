package theatreSeats;

public class listTest {
	static String[][] list = new String[26][3];

	/*static String[][] list = new String[][] {										//initializing the string matrix
		{ "Client", "ID", "Seat"},
		{ "", "", "" },
		{ "", "", "" },
		{ "", "", "" },
		{ "", "", "" },
		{ "", "", "" },
		{ "", "", "" },
		{ "", "", "" },
		{ "", "", "" },
		{ "", "", "" },
		{ "", "", "" },
		{ "", "", "" },
		{ "", "", "" },
		{ "", "", "" },
		{ "", "", "" },
		{ "", "", "" },
		{ "", "", "" },
		{ "", "", "" },
		{ "", "", "" },
		{ "", "", "" },
		{ "", "", "" },
		{ "", "", "" },
		{ "", "", "" },
		{ "", "", "" },
		{ "", "", "" },
		{ "", "", "" }
	};*/
	
	static int count=1;
	
	//Receive information passed and fill the list
	public static void passToList(String id, String lName, String fName, int Row, int Col) {
		list[count][0] = fName + " " + lName;
		list[count][1] = id;
		list[count][2] = "" + getSeat(Row) + Col;
		count++;
	}
	//Take the number Row and get a char based off of it
	public static char getSeat(int Row) {
		char cRow = 'Z';
		switch (Row) {
		case 1:
			cRow = 'A';
			break;
		case 2:
			cRow = 'B';
			break;
		case 3:
			cRow = 'C';
			break;
		case 4:
			cRow = 'D';
			break;
		case 5:
			cRow = 'E';
			break;
		case 6:
			cRow = 'F';
			break;
		case 7:
			cRow = 'G';
			break;
		case 8:
			cRow = 'H';
			break;
		case 9:
			cRow = 'I';
			break;
		case 10:
			cRow = 'J';
			break;
		}
		return cRow;
	}
	//Print the list
	public static void printList() {
		list[0][0] = "Client";
		list[0][1] = "ID";
		list[0][2] = "Seat";
		for (int a=0; a<26; a++) {
			for (int b=0; b<3; b++) {
				System.out.printf("%-30s",list[a][b]);
			}
			System.out.println();
		}
	}
	
}
