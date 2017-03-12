import java.util.Scanner;
public class PrintNumberStats{
	public static void main( String[] args) {
	Scanner in = new Scanner(System.in);
	System.out.println("Please enter your first integer value:  ");
	int number1 = in.nextInt();
	System.out.println("Please enter your second integer value:  ");
	int number2 = in.nextInt();
	int sum = number1+number2;
	int difference = number1 - number2;
	int product = number1*number2;
	int average = (number1+number2)/2;
	int absolute = Math.abs(number1 - number2);
	int maximum = Math.max(number1,number2);
	int minimum = Math.min(number1,number2);
	System.out.print("Sum        = ");
	System.out.printf("%7d\n", sum);
	System.out.print("Difference = ");
	System.out.printf("%7d\n", difference);
	System.out.print("Product    = ");
	System.out.printf("%7d\n", product);
	System.out.print("Average    = ");
	System.out.printf("%7d\n", average);
	System.out.print("Distance   = ");
	System.out.printf("%7d\n", absolute);
	System.out.print("Maximum    = ");
	System.out.printf("%7d\n", maximum);
	System.out.print("Minimum    = ");
	System.out.printf("%7d\n", minimum);
	}
}