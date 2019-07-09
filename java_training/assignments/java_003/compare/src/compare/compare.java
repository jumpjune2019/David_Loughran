package compare;
import java.util.Scanner;
import java.io.*;

public class compare {
	public static void main(String[] args) throws IOException {

		String input1 = null; String input2 = null;
		Scanner console = new Scanner(System.in);
		
		System.out.println("Select which files you would like to compare.");
		System.out.println("1) test1.txt\n2) test2.txt\n3) test3.txt");
		System.out.println("Type a number then press Enter: ");
		input1 = console.nextLine();											//get user selection
		String path1 = getPath(input1);											//get file path for user selection
		System.out.println("You have selected " + input1);
		System.out.println("Type a number then press Enter: ");
		input2 = console.nextLine();											//get user selection
		String path2 = getPath(input2);											//get file path for user selection
		
		BufferedReader reader1 = new BufferedReader(new FileReader(path1));		//prepare readers with selected files
		BufferedReader reader2 = new BufferedReader(new FileReader(path2));

		boolean areEqual = true;
		int count1 = 0;
		int count2 = 0;
		String line1 = reader1.readLine();										//read initial lines of files
		String line2 = reader2.readLine();
		
		while (line1 != null || line2 != null) {								//compare files line by line
			if(line1 == null || line2 == null) {
				areEqual = false;												//If either file ends before the other a difference is located
			}
			else if(! line1.equals(line2)) {
				areEqual = false;												//compare actual contents of file line by line
			}
			count1 += line1.length();											//get length of each line
			count2 += line2.length();
			line1 = reader1.readLine();											//read next line
			line2 = reader2.readLine();

		}
		if(areEqual) {															//display results if identical
			System.out.println("Identical content.");
			System.out.println("Character length for files: " + count1);
        }
        else {
            System.out.println("Different content.");							//display results if not identical
            System.out.println("Character length for first file: " + count1);
            System.out.println("Character length for second file: " + count2);
        }
        reader1.close();
        reader2.close();

	}
	
	public static String getPath(String input) {
		String filePath1 = "c:\\Java_training\\assignments\\java_003\\compare\\test1.txt";			//define file paths
		String filePath2 = "c:\\Java_training\\assignments\\java_003\\compare\\test2.txt";
		String filePath3 = "c:\\Java_training\\assignments\\java_003\\compare\\test3.txt";
		String path = null;
		
		if (input.equals("1")) {			//check user input for correct file path
			path = filePath1;
		} else if (input.equals("2")) {
			path = filePath2;
		} else if (input.equals("3")) {
			path = filePath3;
		} 
		return path;
	}
	
}
