package arrayutils;

public class ArrUtil {
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
}
