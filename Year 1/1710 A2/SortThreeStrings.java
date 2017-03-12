import java.util.Scanner;

public class Sort { 
	public static void main(String[] args) { 
		Scanner in = new Scanner(System.in);
		System.out.println("Enter three strings: ");
		
		String firstStr= in.next();
		String secondStr= in.next();
		String thirdStr= in.next();
		
		boolean swapped = false;
		do {
			swapped = false;
			if (secondStr.compareTo(firstStr) < 0) {		//if str1 comes after str2, continue.
				String tmp = secondStr;						//copy str2 to a temp location
				secondStr = firstStr;						//assigning str2 what str1 is for later printout
				firstStr = tmp;								//making first string what the original second string was, swapping them
				swapped = true;								//enabling the fact that they're swapped
		  }
		  if (thirdStr.compareTo(secondStr) < 0) {			//is str2 comes after str3, continue.
				String tmp = thirdStr;						//copy third string to a temp location
				thirdStr = secondStr;						//assigning third str what second str was
				secondStr = tmp;							//making 2nd string what original third string was, swapping them
				swapped = true;								//enabling the fact that they're swapped
		  }
		} while (swapped);									//if the conditions were met and the strings were swapped, loop. return to do loop and verify first/second again.

		System.out.println(firstStr);						//print results.
		System.out.println(secondStr);
		System.out.println(thirdStr);

   }
}