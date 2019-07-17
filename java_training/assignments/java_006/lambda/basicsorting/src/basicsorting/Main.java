/*The commented out code is the old method created before lambdas were introduced
 * They are kept in as reference for later projects but mostly as a trophy
 */
package basicsorting;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Integer[] numArr = { 10, 3, 4, 15, 7, 9, 1, 21 };
		String[] strArr = { "claude", "Phil", "lois", "clark", "Arthur", "Mera", "bruce" };

		//Sort String Array and checks for Ascending and Descending & Case sensitivity
		basicsorting<String> stringSort = (arr, ASC, CS) -> {
			if (ASC.equals("ASC") && CS.equals("OFF")) {
				Collections.sort(Arrays.asList(arr), String.CASE_INSENSITIVE_ORDER);
			}else if (ASC.equals("DESC") && CS.equals("OFF")) {
				Collections.sort(Arrays.asList(arr), String.CASE_INSENSITIVE_ORDER);
				Collections.reverse(Arrays.asList(arr));
			}
			if (ASC.equals("ASC") && CS.equals("ON")) {
				Collections.sort(Arrays.asList(arr));
			} else if (ASC.equals("DESC") && CS.equals("ON")) {
				Collections.sort(Arrays.asList(arr));
				Collections.reverse(Arrays.asList(arr));
			}
			System.out.print("Sorted " + ASC + " and Case Sensitive " + CS + ": ");
			return arr;
		};
		
		//Sort String Array and checks for Ascending and Descending
		basicsorting<Integer> intSort = (arr, ASC, CS) -> {
			if (ASC.equals("ASC")) {
				Collections.sort(Arrays.asList(arr));
			} else if (ASC.equals("DESC")) {
				Collections.sort(Arrays.asList(arr));
				Collections.reverse(Arrays.asList(arr));
			}
			System.out.print("Sorted " + ASC + ": ");
			return arr;
		};

		//Call lambdas and pass string arrays
		System.out.println("Initial String Array: ");
		String strANC[] = stringSort.arrSort(strArr, "ASC", "OFF");
		System.out.println(Arrays.toString(strANC));
		String strDNC[] = stringSort.arrSort(strArr, "DESC", "OFF");
		System.out.println(Arrays.toString(strDNC));
		String strAC[] = stringSort.arrSort(strArr, "ASC", "ON");
		System.out.println(Arrays.toString(strAC));
		String strDC[] = stringSort.arrSort(strArr, "DESC", "ON");
		System.out.println(Arrays.toString(strDC));
		
		//Call lambdas and pass integer arrays
		System.out.println("\nInitial String Array: ");
		Integer intANC[] = intSort.arrSort(numArr, "ASC", "");
		System.out.println(Arrays.toString(intANC));
		Integer intDNC[] = intSort.arrSort(numArr, "DESC", "");
		System.out.println(Arrays.toString(intDNC));
		
	/*	//Pass the String array to the Generic method 
		System.out.print("Initial String Array: ");
		System.out.println(Arrays.toString(strArr));
		sortArr(strArr);
		
		//Pass the Integer array to the Generic method
		System.out.println();
		System.out.print("Initial Integer Array: ");
		System.out.println(Arrays.toString(numArr));
		sortArr(numArr);
		System.out.println();*/
	}
	
	/*//Sort the String array with ascension and checks case
	public static void ascenSort3(String[] list, String CS) {
		int comp=1;
		for (int a=0; a<list.length; a++) {
			for (int b=0; b<list.length; b++) {
				if (CS.equals("OFF")) {
					comp = list[a].toLowerCase().compareTo(list[b].toLowerCase());
				} else if (CS.equals("ON")) {
					comp = list[a].compareTo(list[b]);
				}
				if (comp < 0) {
					swap(list, a, b);
				} 
			}
		}
		System.out.print("Sorted ASC and Case Sensitive " + CS + ": ");
		System.out.println(Arrays.toString(list));
	}
	
	//Sort the String array with descension and checks case
	public static void descenSort3(String[] list, String CS) {
		int comp=1;
		for (int a=0; a<list.length; a++) {
			for (int b=0; b<list.length; b++) {
				if (CS.equals("OFF")) {
					comp = list[a].toLowerCase().compareTo(list[b].toLowerCase());
				} else if (CS.equals("ON")) {
					comp = list[a].compareTo(list[b]);
				}
				if (comp > 0) {
					swap(list, a, b);
				} 
			}
		}
		System.out.print("Sorted DESC and Case Sensitive " + CS + ": ");
		System.out.println(Arrays.toString(list)); 
	}
	
	//Receive the passed array and check for underlying type
	public static <Type> void sortArr(Type[] list) {
	    if (list instanceof Integer[]) {
	    	Integer[] iList = (Integer[]) list;
			ascenSort(iList);
			descenSort(iList);
			
			
			
	    } else if (list instanceof String[]) {
	    	String[] sList = (String[]) list;
			ascenSort3(sList, "ON");
			descenSort3(sList, "ON");
			ascenSort3(sList, "OFF");
			descenSort3(sList, "OFF");
	    }
	}
	
	//Sort Integer array with ascension
	public static void ascenSort(Integer[] list) {
		for (int a=0; a<list.length; a++) {
			for (int b=0; b<list.length; b++) {
				if (list[a] < list[b]) {
					swap(list, a, b);
				} 
			}
		}
		System.out.print("Sorted ASC: ");
		System.out.println(Arrays.toString(list));
	}
	
	//Sort Integer array with descension
	public static void descenSort(Integer[] list) {
		for (int a=0; a<list.length; a++) {
			for (int b=0; b<list.length; b++) {
				if (list[a] > list[b]) {
					swap(list, a, b);
				} 
			}
		}
		System.out.print("Sorted DESC: ");
		System.out.println(Arrays.toString(list));
	}
	
	//check for underlying types and perform swaps
	public static <Type> void swap(Type[] list, int a, int b) {
	    if (list instanceof Integer[]) {
	    	Integer[] iList = (Integer[]) list;
			int temp = iList[a];
			iList[a] = iList[b];
			iList[b] = temp;
	    } else if (list instanceof String[]) {
	    	String[] sList = (String[]) list;
			String temp = sList[a];
			sList[a] = sList[b];
			sList[b] = temp;
	    }
	}*/
}
