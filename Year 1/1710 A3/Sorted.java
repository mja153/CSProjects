import java.util.Scanner;
public class Sorted{
	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	System.out.println("Please enter three values:");
	double a = in.nextDouble();
	double b = in.nextDouble();
	double c = in.nextDouble();
	boolean answer = sorted(a,b,c);
		if (answer==true){
		System.out.print("The values are sorted within the argument.");
		}
		else{
		System.out.print("The values are NOT sorted within the argument.");
		}
	}
	public static boolean sorted(double a, double b, double c){
		boolean sort;
		if (a<b && b<c)
			sort = true;
		else
			sort = false;
	return sort;
	}
}