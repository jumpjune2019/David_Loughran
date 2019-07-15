package trafficlight;
import java.util.Scanner;

public class trafficlightMain {
	public static void main (String args[]) {
		System.out.println("Press 'Enter' to get out");
		//Call and name the thread
		lightThread ob1 = new lightThread("LightState");
		Scanner console = new Scanner(System.in);
		String input = null;
		
		//end the while loop
		input = console.nextLine();
		if (input.equals(null)) {
			ob1.myStop();
		}
	}
}
