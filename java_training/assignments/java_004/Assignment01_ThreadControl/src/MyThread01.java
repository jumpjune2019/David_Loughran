import java.util.Scanner;
import java.lang.*;

class MyThread01 implements Runnable {
	Thread thrd;
	boolean suspend;
	boolean stop;
	boolean go = true;
	
	MyThread01(String tIdentifier) {
		thrd = new Thread(this, tIdentifier);
		suspend = false;
		stop = false;
		thrd.start();
	}
	
	public int inputUsage(MyThread01 ob, boolean end, int tracker, String input, String input2) {
		String line1 = " Priority was "; String line2 = " but is now ";
		String stopLine = "Permanently stopping the execution of Thread ";
		
				if (input2.equals(input) && suspend == false) {			//check input after selection and peform selected process
					ob.mySuspend(ob);
				} else if (input2.equals(input) && suspend == true) {
					ob.myResume(ob);
				} else if (input2.equalsIgnoreCase("s")) {
					myStop();
					System.out.println(stopLine + input);
					end = true;
					
				} else if (input2.equalsIgnoreCase("t")) {
					int pr = ob.thrd.getPriority();
						ob.thrd.setPriority(10);
					int spr = ob.thrd.getPriority();
						System.out.println(input + line1 + pr + line2 + spr);
				} else if (input2.equalsIgnoreCase("L")) {
					int pr = ob.thrd.getPriority();
						ob.thrd.setPriority(1);
					int spr = ob.thrd.getPriority();
						System.out.println(input + line1 + pr + line2 + spr);
				} else if (input2.equalsIgnoreCase("n")) {
					int pr = ob.thrd.getPriority();
						ob.thrd.setPriority(5);
					int spr = ob.thrd.getPriority();
						System.out.println(input + line1 + pr + line2 + spr);
				} 

		tracker++;
		return tracker++;
	}//end inputUsage

	public void run() {
		System.out.println(thrd.getName() + " starting.");
		try {
			while(go) {
					Thread.sleep(2000);
				// Use synchronized block to check suspended and stopped.
				synchronized(this) {
					while(suspend) {
						System.out.println("Pausing Thread " + thrd.getName());
						wait();
					}
					System.out.println("Executing Thread " + thrd.getName());
					if(stop) {
						break;
					} 
				}
			} //end while
		} 	
		catch (InterruptedException exc) {
			System.out.println(thrd.getName() + " interrupted.");
		}
		System.out.println(thrd.getName() + " exiting.");
	}
	
	
	
	synchronized void myStop() {
		stop = true;
		// The following ensures that a suspended thread can be stopped.
		suspend = false;
		notify();
	}
	// Suspend the thread.
	synchronized void mySuspend(MyThread01 ob) {
		suspend = true;
	}
	// Resume the thread.
	synchronized void myResume(MyThread01 ob) {
		suspend = false;
		System.out.println("Resuming Thread " + thrd.getName());
		notify();
	}
	// Deliver current boolean value
	synchronized boolean checkState(MyThread01 ob) {
		return stop;
	}
}//end class
