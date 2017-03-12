import java.util.Scanner;
public class ChipFlavours{
	public static void main( String[] args) {
	Scanner in = new Scanner(System.in);
	System.out.println("Please enter the amount of votes casted for the Banana Split flavour: ");
	double flav1 = in.nextDouble();
	System.out.println("Please enter the amount of votes casted for the Veggie Burger flavour: ");
	double flav2 = in.nextDouble();
	System.out.println("Please enter the amount of votes casted for the French Onion Soup flavour: ");
	double flav3 = in.nextDouble();
	double flavtotal = (flav1 + flav2 + flav3);
	double percenttotal1 = (flav1/flavtotal)*100;
	double percenttotal2 = (flav2/flavtotal)*100;
	double percenttotal3 = (flav3/flavtotal)*100;
	System.out.printf("%.2f",percenttotal1);
	System.out.println("% of contributers voted for the Banana Split flavour!");
	System.out.printf("%.2f",percenttotal2);
	System.out.println("% of contributers voted for the Veggie Burger flavour!");
	System.out.printf("%.2f",percenttotal3);
	System.out.println("% of contributers voted for the French Onion Soup flavour!");
	}
}