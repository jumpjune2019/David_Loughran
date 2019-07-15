package genarrayswap;

public class swapMain {
	public static void main(String args[]) {
		String sArray[] = {"one", "two", "three"};
		Integer iArray[] = {1, 2, 3};
		int Zero=0; int One=1; int Two=2;
		
		//Pass the String array to the Generic method 
		System.out.println("--String array swap--");
		genPrint(sArray);
		genSwap(sArray, Zero, One);
		genSwap(sArray, One, Two);
		genSwap(sArray, Zero, Two);
		System.out.println();
		
		//Pass the Integer array to the Generic method
		System.out.println("--Integer array swap--");
		genPrint(iArray);
		genSwap(iArray, Zero, One);
		genSwap(iArray, One, Two);
		genSwap(iArray, Zero, Two);
		System.out.println();
	}
	
	//Print the Generic array passed
	public static <Type> void genPrint(Type[] arrayOne) {
		for (int a=0; a<3; a++) {
		System.out.print(arrayOne[a] + " ");
		}
		System.out.println();
	}
	
	//Manipulate the Generic array passed
	public static <Type> void genSwap(Type[] list, int a, int b) {
		Type temp;
		temp = list[a];
		list[a] = list[b];
		list[b] = temp;
		genPrint(list);
	}
}
