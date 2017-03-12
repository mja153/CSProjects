import java.util.Scanner;
public class CreditCard{
	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	System.out.println("Please enter your 8-digit Credit Card Number: ");
	int cN=in.nextInt();
	
	int digit1=(cN / 10000000);
	int digit2=(cN % 10000000) / 1000000;
	int digit3=(cN % 1000000) / 100000;
	int digit4=(cN % 100000) / 10000;
	int digit5=(cN % 10000) / 1000;
	int digit6=(cN % 1000) / 100;
	int digit7=(cN % 100) /10;
	int digit8=cN % 10;


	int double1=2*digit1;
	if (double1 < 5)
		double1 = digit1;
	else
		double1 = digit1/10 + digit1%10;
		
	int double2 = 2*digit3;
	if (double2 < 5)
		double2 = digit3;
	else
		double2 = digit3/10 + digit3%10;
		
	int double3=2*digit5;
	if (double3 < 5)
		double3 = digit5;
	else
		double3 = digit5/10 + digit5%10;
	
	int double4=2*digit7;
	if (double4 < 5)
		double4 = digit7;
	else
		double4 = digit7/10 + digit7%10;
	
	int check1=(digit8+digit6+digit4+digit2);
	int check2=double1+double2+double3+double4;
	
	int sumchecks=check1+check2;
	int roundedsums = Math.round((sumchecks + 5)/ 10) * 10;
	int valid=sumchecks%10;
	
	

	if (valid == 0)
		System.out.println("Your credit card is valid.");
	else{
		System.out.println("Your credit card is invalid.");
		System.out.println("Your current check value is " + sumchecks + ".");
		System.out.println("You are advised to add " + (roundedsums - sumchecks));
		System.out.println("to your check digit to make it valid.");
		}
	}
	}