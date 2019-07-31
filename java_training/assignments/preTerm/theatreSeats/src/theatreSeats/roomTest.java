package theatreSeats;

public class roomTest {
	//String[][] seats = new String[11][11];
	static String[][] seat = new String[][] {										//initializing the string matrix
		{ " ", "Seat 1", "Seat 2", "Seat 3", "Seat 4", "Seat 5", "Seat 6", "Seat 7", "Seat 8", "Seat 9", "Seat 10" },
		{ "Row A", "", "", "", "", "", "", "", "", "", "" },
		{ "Row B", "", "", "", "", "", "", "", "", "", "" },
		{ "Row C", "", "", "", "", "", "", "", "", "", "" },
		{ "Row D", "", "", "", "", "", "", "", "", "", "" },
		{ "Row E", "", "", "", "", "", "", "", "", "", "" },
		{ "Row F", "", "", "", "", "", "", "", "", "", "" },
		{ "Row G", "", "", "", "", "", "", "", "", "", "" },
		{ "Row H", "", "", "", "", "", "", "", "", "", "" },
		{ "Row I", "", "", "", "", "", "", "", "", "", "" },
		{ "Row J", "", "", "", "", "", "", "", "", "", "" }
	};
	
	public static String[][] getSeats(String id, String fName, String lName) {
		int Row = getRan();
		int Col = getRan();
		if (seat[Row][Col].equals("")) {
			char fInitial = fName.charAt(0);
			char lInitial = lName.charAt(0);
			String initials = "" + fInitial + lInitial;
			seat[Row][Col] = "ID: " + id + "/" + initials;
			listTest.passToList(id, lName, fName, Row, Col);
			//System.out.println("First Try");
		} else {
			seat = getSeats(id, fName, lName);
			//System.out.println("Off the rebound");
		}
		return seat;
	}
	//Fill vacant seats
	public static String[][] fillVacant(String[][] seat){
		for(int a=0; a<11; a++) {
			for (int b=0; b<11; b++) {
				if (seat[a][b].equals("")) {
					seat[a][b] = "Vacant";
				}
			}
		}
		return seat;
	}
	//Generate random value
	public static int getRan() {
		double rand = Math.floor((Math.random() * 10) + 1);
		return (int)rand;
	}
}
