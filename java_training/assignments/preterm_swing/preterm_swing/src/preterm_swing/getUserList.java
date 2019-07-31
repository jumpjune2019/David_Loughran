package preterm_swing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class getUserList {
	static Client[] clientArray = new Client[25];

	//read in file version 2
	public static String[] getListV2() throws IOException {
		String filePath = "c:\\Java_training\\assignments\\preterm_swing\\preterm_swing\\userList.csv";
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String line = reader.readLine();
		String[] record = line.split(",");
		String[] names = new String[25];

		//dynamically create new client objects and assign the necessary data to them
		for (int a=0; a<25; a++) {
			line = reader.readLine();
			record = line.split(",");
			clientArray[a] = new Client();
			clientArray[a].clientID = record[0];
			clientArray[a].firstName = record[2];
			clientArray[a].lastName = record[1];
			clientArray[a].clientInitials = "" + record[2].charAt(0) + record[1].charAt(0);
			names[a] = record[1] + ", " + record[2];
		}
		reader.close();
		return names;
	}
	
	public static Client[] grabObjectList() {
		return clientArray;
	}
}