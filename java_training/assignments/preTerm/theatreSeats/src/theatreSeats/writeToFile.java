package theatreSeats;
import java.io.*;

public class writeToFile {
	 public static void addToFile() {
	  try{
		  FileWriter fstream = new FileWriter("test.csv",true);
		  BufferedWriter out = new BufferedWriter(fstream);
		  out.write("Line Added on: " + new java.util.Date()+"\n");
		  out.close();
	  }catch (Exception e) {
		 System.err.println("Error while writing to file: " +
	          e.getMessage());
	  }
	  }
}
