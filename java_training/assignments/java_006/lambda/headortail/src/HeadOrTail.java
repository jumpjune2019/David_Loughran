public class HeadOrTail {
	
	public static void main(String[] args) {										
		int result = coinFlip();								//initializing variable with result of function
		System.out.println("Coin Flip Program");
		String coinFace = coinShow(result);						//initializing variable with result of function 
		System.out.println("The Coin Flip is: " + coinFace);	//and passing a variable
	}
	
	public static int coinFlip() {								//generates and returns random number of 1 or 2
		double rand = Math.floor((Math.random() * 2) + 1);
		return (int)rand;
	}

	public static String coinShow(int result) {					//assigns variable a specific set of data depending 
		String coinFace = null;									//the variable it was passed
		if (result == 1) {
			coinFace = "Heads";
		} else if (result == 2) {
			coinFace = "Tails";
		}
		return coinFace;
	}
}
