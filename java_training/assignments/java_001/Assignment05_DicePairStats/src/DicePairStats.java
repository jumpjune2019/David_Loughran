public class DicePairStats {
	
	public static void main(String[] args) {		
		diceResults oneOne = new diceResults();					//initializing objects
		oneOne.tally = 0;										//initializing unique tally variable for each object
		diceResults oneTwo = new diceResults();
		oneTwo.tally = 0;
		diceResults oneThree = new diceResults();
		oneThree.tally = 0;
		diceResults oneFour = new diceResults();
		oneFour.tally = 0;
		diceResults oneFive = new diceResults();
		oneFive.tally = 0;
		diceResults oneSix = new diceResults();
		oneSix.tally = 0;
		diceResults twoTwo = new diceResults();
		twoTwo.tally = 0;
		diceResults twoThree = new diceResults();
		twoThree.tally = 0;
		diceResults twoFour = new diceResults();
		twoFour.tally = 0;
		diceResults twoFive = new diceResults();
		twoFive.tally = 0;
		diceResults twoSix = new diceResults();
		twoSix.tally = 0;
		diceResults threeThree = new diceResults();
		threeThree.tally = 0;
		diceResults threeFour = new diceResults();
		threeFour.tally = 0;
		diceResults threeFive = new diceResults();
		threeFive.tally = 0;
		diceResults threeSix = new diceResults();
		threeSix.tally = 0;
		diceResults fourFour = new diceResults();
		fourFour.tally = 0;
		diceResults fourFive = new diceResults();
		fourFive.tally = 0;
		diceResults fourSix = new diceResults();
		fourSix.tally = 0;
		diceResults fiveFive = new diceResults();
		fiveFive.tally = 0;
		diceResults fiveSix = new diceResults();
		fiveSix.tally = 0;
		diceResults sixSix = new diceResults();
		sixSix.tally = 0;
		
		int result1 = 0;
		int result2 = 0;
		int rollTotal;
		for (int a=0; a<1000; a++) {
			result1 = diceRoll();												//setting variables values to the result of a function
			result2 = diceRoll();
			rollTotal = result1 + result2;										//setting value to total of previous die rolls
			if (rollTotal == 2) {												//tallying the dice rolls for each result
				if (result1 == 1 && result2 == 1) {
					oneOne.tally++;
				}
			} else if (rollTotal == 3) {
				if (result1 == 1 || result1 == 2) {
					oneTwo.tally++;
				}
			} else if (rollTotal == 4) {
				if (result1 == 2 && result2 == 2) {
					twoTwo.tally++;
				} else if (result1 == 1 || result1 == 3) {
					oneThree.tally++;
				}
			} else if (rollTotal == 5) {
				if (result1 == 1 || result1 == 4) {
					oneFour.tally++;
				} else if (result1 == 2 || result1 == 3) {
					twoThree.tally++;
				}
			} else if (rollTotal == 6) {
				if (result1 == 1 || result1 == 5) {
					oneFive.tally++;
				} else if (result1 == 2 || result1 == 4) {
					twoFour.tally++;
				} else if (result1 == 3 && result2 == 3) {
					threeThree.tally++;
				}
			} else if (rollTotal == 7) {
				if (result1 == 1 || result1 == 6) {
					oneSix.tally++;
				} else if (result1 == 2 || result1 == 5) {
					twoFive.tally++;
				} else if (result1 == 3 || result1 == 4) {
					threeFour.tally++;
				}
			} else if (rollTotal == 8) {
				if (result1 == 2 || result1 == 6) {
					twoSix.tally++;
				} else if (result1 == 3 || result1 == 5) {
					threeFive.tally++;
				} else if (result1 == 4 && result2 == 4) {
					fourFour.tally++;
				}
			} else if (rollTotal == 9) {
				if (result1 == 3 || result1 == 6) {
					threeSix.tally++;
				} else if (result1 == 4 || result1 == 5) {
					fourFive.tally++;
				}
			} else if (rollTotal == 10) {
				if (result1 == 4 || result1 == 6) {
					fourSix.tally++;
				} else if (result1 == 5 && result2 == 5) {
					fiveFive.tally++;
				}
			} else if (rollTotal == 11) {
				if (result1 == 5 || result1 == 6) {
					fiveSix.tally++;
				}
			} else if (rollTotal == 12) {
				if (result1 == 6 && result2 == 6) {
					sixSix.tally++;
				}
			}
		}
		System.out.println("1000 Random 2 Dice Roll stats");					//displaying results	
		System.out.println("Dice 1 and 1: " + oneOne.tally + " times");
		System.out.println("Dice 1 and 2: " + oneTwo.tally + " times");
		System.out.println("Dice 1 and 3: " + oneThree.tally + " times");
		System.out.println("Dice 1 and 4: " + oneFour.tally + " times");
		System.out.println("Dice 1 and 5: " + oneFive.tally + " times");
		System.out.println("Dice 1 and 6: " + oneSix.tally + " times");
		System.out.println("Dice 2 and 2: " + twoTwo.tally + " times");
		System.out.println("Dice 2 and 3: " + twoThree.tally + " times");
		System.out.println("Dice 2 and 4: " + twoFour.tally + " times");
		System.out.println("Dice 2 and 5: " + twoFive.tally + " times");
		System.out.println("Dice 2 and 6: " + twoSix.tally + " times");
		System.out.println("Dice 3 and 3: " + threeThree.tally + " times");
		System.out.println("Dice 3 and 4: " + threeFour.tally + " times");
		System.out.println("Dice 3 and 5: " + threeFive.tally + " times");
		System.out.println("Dice 3 and 6: " + threeSix.tally + " times");
		System.out.println("Dice 4 and 4: " + fourFour.tally + " times");
		System.out.println("Dice 4 and 5: " + fourFive.tally + " times");
		System.out.println("Dice 4 and 6: " + fourSix.tally + " times");
		System.out.println("Dice 5 and 5: " + fiveFive.tally + " times");
		System.out.println("Dice 5 and 6: " + fiveSix.tally + " times");
		System.out.println("Dice 6 and 6: " + sixSix.tally + " times");
	}
	
	public static int diceRoll() {								//generates and returns random number from 1 to 6
		double rand = Math.floor((Math.random() * 6) + 1);
		return (int)rand;
	}
}