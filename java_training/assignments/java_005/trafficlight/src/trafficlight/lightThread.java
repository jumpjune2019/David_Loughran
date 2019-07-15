package trafficlight;
import java.util.concurrent.TimeUnit;

public class lightThread implements Runnable {
	Thread thrd;
	boolean suspend;
	boolean stop;
	lightThread (String threadName){
		thrd = new Thread (this, threadName);
		suspend = false;
		stop = false;
		thrd.start();
	}
	
	public void run() {
		System.out.println("Traffic Light simulator is a Go!");
		//initialize the starting state of the light
		LightCycle LC;
		LC = LightCycle.Green;
		try {
			Thread.sleep(250);			
			while (!stop) {
				//Switch statement controls the flow of the program
				//Each case prepares the next 
				switch(LC) {
					case Green:
						System.out.println("Light is " + LC + " - Go!");
						LC = LightCycle.Yellow;
						TimeUnit.SECONDS.sleep(5);
					break;
					case Yellow:
						System.out.println("Light is " + LC + " - Beware!");
						LC = LightCycle.Red;
						TimeUnit.SECONDS.sleep(2);
					break;
					case Red:
						System.out.println("Light is " + LC + " - Stop!");
						LC = LightCycle.Green;
						TimeUnit.SECONDS.sleep(3);
					break;
				}
			}
		} catch(InterruptedException exc) {
			System.out.println(thrd.getName() + " interrupted.");
		}
	}
	//Stop the thread
	synchronized void myStop() {
		stop = true;
		suspend = false;
		notify();
		System.out.println("Traffic Light simulator is done.");
	}
}
