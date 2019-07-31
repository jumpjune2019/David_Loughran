package preterm_swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.*;


public class SwingM implements ActionListener, ListSelectionListener {
	public JFrame window = new JFrame("PreTerm_Swing");
	public JPanel footerPanel = new JPanel();
	public JPanel panelGrid = new JPanel();
	public JPanel userListPanel = new JPanel();
	int row = 10;
	int col = 10;
	int nameIdx = -1;
	JLabel header = new JLabel("My 2nd Matrix Demo", JLabel.CENTER);
	JLabel[][] seatState = new JLabel[row][col];
	JButton[][] bookUnbook = new JButton[row][col];
	JList<String> userList;
	DefaultListModel<String> model = new DefaultListModel<>();
	Seat[][] seatArray = new Seat[row][col];
	Client[] clientArray = new Client[25];
	String[] names;
	
	public SwingM() {
		prepareGUI();
	}
	
	public void prepareGUI() {
		window.add(header, BorderLayout.NORTH);
		window.add(userListPanel, BorderLayout.WEST);
		window.add(panelGrid, BorderLayout.CENTER);
		window.add(footerPanel, BorderLayout.SOUTH);
		
		// old school way to close a window
		window.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
				// this is the way to force a java application to gracefully exit
				// when not going to end via the main method entry point
				System.exit(0);
			}        
		}); 
		window.setVisible(true);
	}
	
	public void displayTheSeats() throws NullPointerException {
		JPanel seatGrid = new JPanel();
		JLabel rows;
		JLabel columns = new JLabel("");

		GridLayout layout = new GridLayout(row+1, col+1);
		layout.setHgap(1);
		layout.setVgap(1);
		seatGrid.setLayout(layout);
		//add column labels to grid
		seatGrid.add(columns);
		for (int a=0; a<col; a++) {
			columns = new JLabel("Seat " + (a+1));
			seatGrid.add(columns);	
		}
		//dynamically create JPanels with BoxLayout
		//dynamically create JLabels with some text
		//dynamically create JButtons with an ActionListener
		//add each JLabel and the JButton into the JPanels
		//add each JPanel into the panelGrid JPanel
		for (int x=0; x<row; x++) {
			//add row labels to grid
			rows = new JLabel("Row " + listTest.getSeat(x+1));
			seatGrid.add(rows);
			//start button initialization
			for (int y=0; y<col; y++) {
				JPanel containers = new JPanel();
				containers.setBorder(BorderFactory.createLineBorder(Color.black));
				containers.setLayout(new BoxLayout(containers, BoxLayout.Y_AXIS));
				containers.setSize(100, 100);
				String seatLabel = listTest.getSeat(x + 1) + "-" + (y + 1);
				
				seatArray[x][y] = new Seat();
				seatState[x][y] = new JLabel(seatArray[x][y].label);
					containers.add(seatState[x][y]);
					bookUnbook[x][y] = new JButton("Book");
					bookUnbook[x][y].addActionListener(this);
					//Set the location of the button
					bookUnbook[x][y].setActionCommand(Integer.toString(x) + "," + Integer.toString(y) + "," +  seatLabel);
					bookUnbook[x][y].setFont(new Font(Font.SERIF, Font.PLAIN, 10));
					//set button size
					bookUnbook[x][y].setPreferredSize(new Dimension(70, 20));
					bookUnbook[x][y].setMaximumSize(new Dimension(70, 20));
					
					containers.add(bookUnbook[x][y]); 
					seatGrid.add(containers);
			}
		}
		panelGrid.add(seatGrid);
		//allow the layout manager to determine the JFrame size necessary 
		//utilizes the preferred size of each JPanel
		window.pack();  
		window.setVisible(true);  
	}
	
	//Populates the JList with Client names
	public void displayUserList() {
		
		try {
			names = getUserList.getListV2();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//populate JList
		for (int a=0; a<names.length; a++) {
			model.addElement(names[a]);
		}
		userList = new JList<String>(model);
		clientArray = getUserList.grabObjectList();

		
		// Set the list selection mode to single-selection.
		userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// Add list selection handler.
		userList.addListSelectionListener(this);
		
		//add list into the JFrame
		userListPanel.setLayout(new BorderLayout());
		userListPanel.add(new JScrollPane(userList), BorderLayout.CENTER);
		//set panel size
		userListPanel.setPreferredSize(new Dimension(200, 300));
		userListPanel.setMaximumSize(new Dimension(200, 300));
		window.pack();
		window.setVisible(true);
	}	
	
	//Display buttons at bottom of page
	public void displayLowerButtons() {
		JPanel btnHolder = new JPanel();
		btnHolder.setLayout(new BoxLayout(btnHolder, BoxLayout.X_AXIS));
		JButton reset = new JButton("Reset Seats");
		reset.addActionListener(this);
		JButton printList = new JButton("Print Assigned Seats");
		printList.addActionListener(this);
		btnHolder.add(reset);
		btnHolder.add(Box.createRigidArea(new Dimension(40, 0)));
		btnHolder.add(printList);
		footerPanel.add(btnHolder, BorderLayout.CENTER);
		window.pack();  
		window.setVisible(true);  
	}
	
	// Handle list selection events.
	public void valueChanged(ListSelectionEvent le) {
		// Get the index of the changed item.
		int idx = userList.getSelectedIndex();
		//set selection identifier
		if(idx != -1) {
			nameIdx = idx;
		} 
	}
	
	//set the foot text to whatever button was just pressed
	public void actionPerformed(ActionEvent ae) {
		String getAction = ae.getActionCommand();
		//unbook all currently booked seats
		if (getAction.equals("Reset Seats")) {
			for (int a=0; a<10; a++) {
				for (int b=0; b<10; b++) {
					for (int c=0; c<25; c++) {
						unbook(a, b, c);
					}	
				}
			}
		//print all currently assigned seats
		} else if (getAction.equals("Print Assigned Seats")) {
			System.out.printf("%-30s", "Client");
			System.out.printf("%-30s", "ID");
			System.out.printf("%-30s", "Seat");
			System.out.println();
			for (int a=0; a<25; a++) {
				if (!clientArray[a].seat.equals("")) {
					System.out.printf("%-30s", clientArray[a].firstName + " " + clientArray[a].lastName);
					System.out.printf("%-30s", clientArray[a].clientID);
					System.out.printf("%-30s", clientArray[a].seat);
					System.out.println();
				}
			}
		//individually book and unbook seats	
		} else {
			//retrieve the button location coordinates
			String[] temp = getAction.split(",");
			int rowIdx = Integer.parseInt(temp[0]);
			int colIdx = Integer.parseInt(temp[1]);
			int objIdx = -1;
			String seatLabel = temp[2];
			String btnState = bookUnbook[rowIdx][colIdx].getText();
			
			//book seat for user
			if (btnState.equals("Book")) {
				//confirm that a client is selected
				if (nameIdx != -1) {
					//retrieve accurate tracking id for clientArray
					String[] name = (String[])model.getElementAt(nameIdx).split(",");
					for (int a=0; a<25; a++) {
						if (name[0].equals(clientArray[a].lastName)) {
							objIdx = a;
							break;
						}
					}
					//populate the seatArray with the target values
					seatArray[rowIdx][colIdx].firstName = clientArray[objIdx].firstName;
					seatArray[rowIdx][colIdx].lastName = clientArray[objIdx].lastName;
					seatArray[rowIdx][colIdx].clientID = clientArray[objIdx].clientID;
					seatArray[rowIdx][colIdx].clientInitials = clientArray[objIdx].clientInitials;
					clientArray[objIdx].seat = seatLabel;
					//set the label in the target cell to the target client's information
					String label = "id: " + clientArray[objIdx].clientID + "/" + clientArray[objIdx].clientInitials;
					seatArray[rowIdx][colIdx].label = label;
					seatState[rowIdx][colIdx].setText(seatArray[rowIdx][colIdx].label);
					bookUnbook[rowIdx][colIdx].setText("Unbook");
					//remove client from JList
					model.remove(nameIdx);
					//reset selector value
					nameIdx = -1;				
				} else {
					System.out.println("No client selected");
				}
			
			//unbook seat from user	
			} else if (btnState.equals("Unbook")){
				unbook(rowIdx, colIdx, objIdx);
			}
		}
	}
	
	//unbook seats
	public void unbook(int rowIdx, int colIdx, int objIdx) {
		if (!seatArray[rowIdx][colIdx].label.equals("Vacant")) {
			String checkID = seatArray[rowIdx][colIdx].clientID;
			for (int a=0; a<25; a++) {
				if (checkID.equals(clientArray[a].clientID)) {
					objIdx = a;
					break;
				}
			}
			//return name to JList
			String name = clientArray[objIdx].lastName + ", " + clientArray[objIdx].firstName;
			model.addElement(name);
			//reset seat label
			String label = "Vacant";
			seatArray[rowIdx][colIdx].label = label;
			seatState[rowIdx][colIdx].setText(label);
			//reset seat information
			seatArray[rowIdx][colIdx].firstName = "";
			seatArray[rowIdx][colIdx].lastName = "";
			seatArray[rowIdx][colIdx].clientID = "";
			seatArray[rowIdx][colIdx].clientInitials = "";
			clientArray[objIdx].seat = "";
			//reset button label
			bookUnbook[rowIdx][colIdx].setText("Book");
		}
	}
}
