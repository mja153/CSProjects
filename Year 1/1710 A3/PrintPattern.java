import java.util.Scanner;
public class PrintPattern {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the size:");
		int width = in.nextInt();		
		String character;
		int lineNumb = 0;
		
												//printing commands
		character = "=";						//sets character to "="
		printChar(character, width, lineNumb);	//calls method printChar to print "=" lines
		for (int m = 0; m < width/2; m++){ 		//create loop for number of lines to write "+" combinations
		character = "+";						//prints the pattern of "+" and " " 
		printChar(character, width, lineNumb);
		character = " ";
		printChar(character, width, lineNumb);
		character = "+";
		printChar(character, width, lineNumb);
		lineNumb++;								//increment line number
		System.out.println();					
		}
		character = "=";						//repeat line of =
		printChar(character, width, lineNumb);
	}
	public static void printChar(String character, int width, int lineNumb) {
		
		if (character.compareTo("=") == 0){ 	//follow equals printing
				for (int j = 0; j < width; j++) 
				System.out.print(character);
				System.out.println();
				lineNumb++;
		}
		
		if (character.compareTo("+") == 0){ 	// follow plus printing
			for (int k = 0; k <= lineNumb; k++)
				System.out.print(character);
		}

		if (character.compareTo(" ") == 0){ 	// follow space printing 
			for (int l = 0; l < (width - (2*lineNumb) - 2); l++){
				System.out.print(character);			
			}
			lineNumb++;	
		}
	return;
	}
}