package preterm_swing;


import java.io.IOException;
import javax.swing.*;

public class Main {

	
	
	
	public static void main(String args[]) throws IOException {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				SwingM displayTheSeats = new SwingM();
				displayTheSeats.displayTheSeats();
				displayTheSeats.displayLowerButtons();
				displayTheSeats.displayUserList();
			}
		}); 
	}
}
