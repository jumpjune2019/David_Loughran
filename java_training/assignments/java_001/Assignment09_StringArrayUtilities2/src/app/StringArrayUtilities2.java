package app;
import arrayutils.ArrUtil;								//importing the methods from the ArrUtil class

public class StringArrayUtilities2 {
	
	public static void main(String[] args) {		
		String myList[] = {"Bozo", "FooBar", "Delta", "Foozball", "Demo", "Money", "Zoo"};		//initialize primary array
		boolean found;
		int foundIndexes[] = {0, 0, 0, 0, 0, 0, 0};			//initialize primary count array
		String output = "This is the a test of the arrayHasExactMatch and indexOfOccurenceInArray methods.\nThe array to test contains the following items “Bozo”, “FooBar”, “Delta”, “Foozball”, “Demo”, “Money”, “Zoo”";
		String sh = " arrayHasExactMatch (myList, ";			//initialize repeated text
		int a=0;		//initialize secondary count
		
		System.out.println(output);													//initiale statement
		found = ArrUtil.arrayHasExactMatch (myList, "zo", false);							//each statement passes the array, a term to be checked, and a control operator
			System.out.println("\nScenario 1" + sh + "“zo”, false): is " + found);	//after processing, the result is displayed
		found = ArrUtil.arrayHasExactMatch (myList, "zoo", false);
			System.out.println("Scenario 2" + sh + "“zoo”, false): is " + found);
		found = ArrUtil.arrayHasExactMatch (myList, "zoo", true);
			System.out.println("Scenario 3" + sh + "“zoo”, true): is " + found);
		found = ArrUtil.arrayHasExactMatch (myList, "foo", true);
			System.out.println("Scenario 4" + sh + "“foo”, true): is " + found);
		found = ArrUtil.arrayHasExactMatch (myList, "foo", false);
			System.out.println("Scenario 5" + sh + "“foo”, false): is " + found);
		found = ArrUtil.arrayHasExactMatch (myList, "delta", true);
			System.out.println("Scenario 6" + sh + "“delta”, true): is " + found);
		found = ArrUtil.arrayHasExactMatch (myList, "Delta", true);
			System.out.println("Scenario 7" + sh + "“Delta”, true): is " + found);
			
		sh = " indexOfOccuranceInArray (myList, ";																//reset repeated text
		foundIndexes[a] = ArrUtil.indexOfOccuranceInArray (myList, "zo", false);										//each statement passes the array, a term to be checked, and a control operator
			System.out.println("\nScenario 1" + sh + "“zo”, false) returns [" + foundIndexes[a] + "]"); a++;	//after processing, the result is displayed
		foundIndexes[a] = ArrUtil.indexOfOccuranceInArray (myList, "zoo", false); 
			System.out.println("Scenario 2" + sh + "“zoo”, false) returns [" + foundIndexes[a] + "]"); a++;
		foundIndexes[a] = ArrUtil.indexOfOccuranceInArray (myList, "zoo", true);
			System.out.println("Scenario 3" + sh + "“zoo”, true) returns [" + foundIndexes[a] + "]"); a++;
		foundIndexes[a] = ArrUtil.indexOfOccuranceInArray (myList, "foo", true);
			System.out.println("Scenario 4" + sh + "“foo”, true) returns [" + foundIndexes[a] + "]"); a++;
		foundIndexes[a] = ArrUtil.indexOfOccuranceInArray (myList, "foo", false);
			System.out.println("Scenario 5" + sh + "“foo”, false) returns [" + foundIndexes[a] + "]"); a++;
		foundIndexes[a] = ArrUtil.indexOfOccuranceInArray (myList, "delta", true);
			System.out.println("Scenario 6" + sh + "“delta”, true) returns [" + foundIndexes[a] + "]"); a++;
		foundIndexes[a] = ArrUtil.indexOfOccuranceInArray (myList, "Delta", true);
			System.out.println("Scenario 7" + sh + "“Delta”, true) returns [" + foundIndexes[a] + "]"); a++;
	}
}
