import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class ThreadControl {
	static String input = "start";
	static String input2 = "lol";
	static boolean layerControl = false;
	static MyThread01 ob1 = new MyThread01("1");
	static MyThread01 ob2 = new MyThread01("2");
	static MyThread01 ob3 = new MyThread01("3");
	static MyThread01 ob4 = new MyThread01("4");
	static MyThread01 ob5 = new MyThread01("5");
	public static void main(String Args[]) {
		
		JFrame frame = new JFrame("Key Listener");
		KeyListener listener = new KeyListener() {
			@Override
			public void keyPressed(KeyEvent event) {
				layerControl = !layerControl;
				if (layerControl) {
					setInput(event.getKeyChar() +"");
					System.out.println("You are now controlling Thread " + input);
					
				} else {
					setInput2(event.getKeyChar() +"");
				}
				grabThread();
				setInput2("lol");	
			}

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		};


		TextArea ta = new TextArea();
		ta.addKeyListener(listener);
		frame.add(ta);
		frame.setSize(200,200);
		frame.setVisible(true);
	} //end main
	
	public static void setInput (String in) {
		input = in;
	}
	public static void setInput2 (String in) {
		input2 = in;
	}
	
	public static void grabThread() {
		//System.out.println("input1: " + input);
		//System.out.println("input2: " + input2);
		int tracker=0;
		boolean end = false;
		try {
					if (input.equals("1")) {
						tracker = ob1.inputUsage(ob1, end, tracker, input, input2);
					} else if (input.equals("2")) {
						tracker = ob2.inputUsage(ob2, end, tracker, input, input2);
					} else if (input.equals("3")) {
						tracker = ob3.inputUsage(ob3, end, tracker, input, input2);
					} else if (input.equals("4")) {
						tracker = ob4.inputUsage(ob4, end, tracker, input, input2);
					} else if (input.equals("5")) {
						tracker = ob5.inputUsage(ob5, end, tracker, input, input2);
					}

					Thread.sleep(250);

						boolean state1 = ob1.checkState(ob1);
						boolean state2 = ob2.checkState(ob2);
						boolean state3 = ob3.checkState(ob3);
						boolean state4 = ob4.checkState(ob4);
						boolean state5 = ob5.checkState(ob5);
						if (!state1) {System.out.println("Thread 1 running: " + !ob1.suspend + " - Press 1 to control");}
						if (!state2) {System.out.println("Thread 2 running: " + !ob2.suspend + " - Press 2 to control");}
						if (!state3) {System.out.println("Thread 3 running: " + !ob3.suspend + " - Press 3 to control");}
						if (!state4) {System.out.println("Thread 4 running: " + !ob4.suspend + " - Press 4 to control");}
						if (!state5) {System.out.println("Thread 5 running: " + !ob5.suspend + " - Press 5 to control");}

		} catch (InterruptedException exc) {
			System.out.println("Main thread Interrupted");
		} //end catch
	}
}
