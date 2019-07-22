package gridlayoutchallenge;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class challengeM implements ActionListener{
	private JFrame mainFrame = new JFrame("Grid Layout Challenge");
	private JLabel header = new JLabel("Basic Matrix Demo", JLabel.CENTER);
	private JLabel footer = new JLabel("No seat selected", JLabel.CENTER);
	private JPanel panelGrid = new JPanel();
	
	public challengeM() {
		prepareGUI();
	}
	
	//Set up the user display
	private void prepareGUI() {
		mainFrame.add(header, BorderLayout.NORTH);
		mainFrame.add(panelGrid, BorderLayout.CENTER);
		mainFrame.add(footer, BorderLayout.SOUTH);
		header.setPreferredSize(new Dimension(80, 80));
		footer.setPreferredSize(new Dimension(80, 80));
		
		// old school way to close a window
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
				// this is the way to force a java application to gracefully exit
				// when not going to end via the main method entry point
				System.exit(0);
			}        
		}); 
		mainFrame.setVisible(true);
	}
	
	private void showGridLayoutDemo() throws NullPointerException {
		JPanel boxGrid = new JPanel();
		int row = dieRoll();
		int col = dieRoll();
		GridLayout layout = new GridLayout(row, col);
		layout.setHgap(2);
		layout.setVgap(2);
		boxGrid.setLayout(layout);
		JButton[][] buttons = new JButton[row][col];
		
		//dynamically create JPanels with BoxLayout
		//dynamically create JLabels with some text
		//dynamically create JButtons with an ActionListener
		//add each JLabel and the JButton into the JPanels
		//add each JPanel into the panelGrid JPanel
		for (int x=0; x<row; x++) {
			for (int y=0; y<col; y++) {
				JPanel containers = new JPanel();
				containers.setPreferredSize(new Dimension(50, 50));
				containers.setBorder(BorderFactory.createLineBorder(Color.black));
				containers.setLayout(new BoxLayout(containers, BoxLayout.Y_AXIS));
				String rowLabel = getLetter(x + 1) + "-" + (y + 1);
				JLabel tag = new JLabel(rowLabel);
					containers.add(tag);
					buttons[x][y] = new JButton(rowLabel);
					buttons[x][y].addActionListener(this);
					buttons[x][y].setFont(new Font(Font.SERIF, Font.PLAIN, 8));
					containers.add(buttons[x][y]); 
					boxGrid.add(containers);
			}
		}
     
		panelGrid.add(boxGrid);
		//allow the layout manager to determine the JFrame size necessary 
		//utilizes the preferred size of each JPanel
		mainFrame.pack();  
		mainFrame.setVisible(true);  
	}
	//set the foot text to whatever button was just pressed
	public void actionPerformed(ActionEvent ae) {
		footer.setText(ae.getActionCommand());
	}
	//take an int that represents a row and return the corresponding letter
	public static char getLetter(int Row) {
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
		}
		return cRow;
	}
	//generates and returns random number of 2 or 5
	public static int dieRoll() {
		double rand = Math.floor((Math.random() * 4) + 2);
		return (int)rand;
	}

	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				challengeM gridLayoutDemo = new challengeM();  
				gridLayoutDemo.showGridLayoutDemo();
			}
		}); 

	}
}


