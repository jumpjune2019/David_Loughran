package bookpack;



public class Main {
	
	public static void main() {
		int result = coinFlip();
		System.out.println("Coin Flip Program");
		String coinFace = coinShow(result);
		System.out.println("The Coin Flip is: " + coinFace);
	}
	
	public static int coinFlip() {
		double rand = Math.floor((Math.random() * 2) + 1);
		return (int)rand;
	}

	public static String coinShow(int result) {
		String coinFace;
		if (result == 1) {
			coinFace = "Heads";
		} else if (result == 2) {
			coinFace = "Tails";
		}
	}
}
