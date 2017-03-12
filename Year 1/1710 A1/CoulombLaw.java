import java.util.Scanner;
import java.math.*;
public class CoulombLaw{
	public static void main( String[] args) {
	Scanner in = new Scanner(System.in);
	System.out.println("Please enter the value of Q1: ___"+"Coulombs");
	double Q1 = in.nextDouble();
	System.out.println("Please enter the value of Q2: ___ "+"Coulombs");
	double Q2 = in.nextDouble();
	System.out.println("Please enter the value of r: ___ "+"meters");
	double r = in.nextDouble();
	double e = (8.854)*(Math.pow(10,-12));
	double electricforce = (Q1*Q2)/(4*(Math.PI)*e*r*r);
	System.out.print("The Electric Force between charged particles of charge Q1 and Q2 is: ");
	System.out.printf("%.4f",electricforce);
	System.out.print("N");
	}
	}