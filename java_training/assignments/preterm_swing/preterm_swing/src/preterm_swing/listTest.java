package preterm_swing;

public class listTest {

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
}