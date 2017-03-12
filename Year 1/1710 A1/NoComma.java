import java.util.Scanner;
public class NoComma{
	public static void main( String[] args) {
	Scanner in = new Scanner(System.in);
	System.out.println("Please enter an integer between 1,000 and 999,999:  ");
	String number = in.next();
	int n = number.length();
	String beforecomma = number.substring(0,n-4);
	String aftercomma = number.substring(n-3,n);
	String nocomma = (beforecomma+aftercomma);
	System.out.println(nocomma);
	}
	}