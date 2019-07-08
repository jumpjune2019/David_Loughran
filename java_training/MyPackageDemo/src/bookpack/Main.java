package bookpack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String heads = "Heads";
		String tails = "Tails";
		double rand = Math.floor((Math.random() * 2) + 1);
		System.out.println("Coin flip program");
		if (rand == 1) {
			System.out.println("The Coin Flip is: " + heads);
		} else if (rand == 2) {
			System.out.println("The Coin Flip is: " + tails);
		}
		

	}

}
