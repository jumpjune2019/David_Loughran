public class HeadOrTailTally {
	
	public static void main(String[] args) {			
		int[] tally = {0, 0};										//initialize array to keep track of flips
		for (int a=0; a<1000; a++) {
			int result = coinFlip();								//initializing variable with result of function
			if (result == 1) {										//tallying the flips that result in Heads
				tally[0] = tally[0] + 1;
			} else if (result == 2) {								//tallying the flips that result in Tails
				tally[1] = tally[1] + 1;
			}
		}
		System.out.println("1000 Coin Flips");						//displaying results
		System.out.println("Count of Heads: " + tally[0]);
		System.out.println("Count of Tailss: " + tally[1]);
	}
	
	public static int coinFlip() {								//generates and returns random number of 1 or 2
		double rand = Math.floor((Math.random() * 2) + 1);
		return (int)rand;
	}
}