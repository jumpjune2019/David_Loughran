public class StringArrayUtilities {
	
	public static boolean arrayHasExactMatch(String[] myList, String item, boolean expected) {
		boolean result = false;
		for(int a=0; a<7; a++) {
			if(expected == false) {				//check control operator for type of processing, false == case sensitive off, true == case sensitive on
				if(item.toUpperCase().equals(myList[a].toUpperCase())) {
					result = true;
					break;
				} else {
					result = false;
				}
			} else {						//regardless of control operator the passed term is searched for within the passed array
				if(item.equals(myList[a])) {
					result = true;
					break;
				} else {
					result = false;
				}
			}
		}
		return result;					//the result of the query is returned by the function
	}
	
	public static int indexOfOccuranceInArray(String[] myList, String item, boolean expected) {
		int result = 0;
		for(int a=0; a<7; a++) {
			if(expected == false) {                //check control operator for type of processing, false == case sensitive off, true == case sensitive on
				if(item.toUpperCase().equals(myList[a].toUpperCase())) {
					result = a;
					break;
				} else {
					result = -1;
				}
			} else {								//regardless of control operator the passed term is searched for within the passed array
				if(item.equals(myList[a])) {
					result = a;
					break;
				} else {
					result = -1;
				}
			}
		}
		return result;								//the returned result is the location of the identified term
	}

	public static void main(String[] args) {
		String myList[] = {"Bozo", "FooBar", "Delta", "Foozball", "Demo", "Money", "Zoo"};		//initialize primary array
		boolean found;
		int foundIndexes[] = {0, 0, 0, 0, 0, 0, 0};			//initialize primary count array
		String output = "This is the a test of the arrayHasExactMatch and indexOfOccurenceInArray methods.\nThe array to test contains the following items “Bozo”, “FooBar”, “Delta”, “Foozball”, “Demo”, “Money”, “Zoo”";
		String sh = " arrayHasExactMatch (myList, ";			//initialize repeated text
		int a=0;		//initialize secondary count
		
		System.out.println(output);													//initiale statement
		found = arrayHasExactMatch (myList, "zo", false);							//each statement passes the array, a term to be checked, and a control operator
			System.out.println("\nScenario 1" + sh + "“zo”, false): is " + found);	//after processing, the result is displayed
		found = arrayHasExactMatch (myList, "zoo", false);
			System.out.println("Scenario 2" + sh + "“zoo”, false): is " + found);
		found = arrayHasExactMatch (myList, "zoo", true);
			System.out.println("Scenario 3" + sh + "“zoo”, true): is " + found);
		found = arrayHasExactMatch (myList, "foo", true);
			System.out.println("Scenario 4" + sh + "“foo”, true): is " + found);
		found = arrayHasExactMatch (myList, "foo", false);
			System.out.println("Scenario 5" + sh + "“foo”, false): is " + found);
		found = arrayHasExactMatch (myList, "delta", true);
			System.out.println("Scenario 6" + sh + "“delta”, true): is " + found);
		found = arrayHasExactMatch (myList, "Delta", true);
			System.out.println("Scenario 7" + sh + "“Delta”, true): is " + found);
			
		sh = " indexOfOccuranceInArray (myList, ";																//reset repeated text
		foundIndexes[a] = indexOfOccuranceInArray (myList, "zo", false);										//each statement passes the array, a term to be checked, and a control operator
			System.out.println("\nScenario 1" + sh + "“zo”, false) returns [" + foundIndexes[a] + "]"); a++;	//after processing, the result is displayed
		foundIndexes[a] = indexOfOccuranceInArray (myList, "zoo", false); 
			System.out.println("Scenario 2" + sh + "“zoo”, false) returns [" + foundIndexes[a] + "]"); a++;
		foundIndexes[a] = indexOfOccuranceInArray (myList, "zoo", true);
			System.out.println("Scenario 3" + sh + "“zoo”, true) returns [" + foundIndexes[a] + "]"); a++;
		foundIndexes[a] = indexOfOccuranceInArray (myList, "foo", true);
			System.out.println("Scenario 4" + sh + "“foo”, true) returns [" + foundIndexes[a] + "]"); a++;
		foundIndexes[a] = indexOfOccuranceInArray (myList, "foo", false);
			System.out.println("Scenario 5" + sh + "“foo”, false) returns [" + foundIndexes[a] + "]"); a++;
		foundIndexes[a] = indexOfOccuranceInArray (myList, "delta", true);
			System.out.println("Scenario 6" + sh + "“delta”, true) returns [" + foundIndexes[a] + "]"); a++;
		foundIndexes[a] = indexOfOccuranceInArray (myList, "Delta", true);
			System.out.println("Scenario 7" + sh + "“Delta”, true) returns [" + foundIndexes[a] + "]"); a++;
	}
}
