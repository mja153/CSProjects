import java.util.Scanner;

public class NumberOver10{
	public static void main( String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter your list of 1-digit and 2-digit integer numbers(ending with the value 100): ");
		int numCount = 0;
		int value = 0; 
		while (value!=100){
			value = in.nextInt();
			if (value > 10)
				numCount++;
		}
		System.out.println("The frequency of the number greater then 10 are " + (numCount-1));
	}
}
	