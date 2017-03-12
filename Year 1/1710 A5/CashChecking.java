import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class CashChecking{
	
	public static void main(String[] args) {	
	try{
	Scanner in = new Scanner(System.in);
	System.out.println("At the beginning of the day, how much cash is present?");
	double beginCash = in.nextDouble();
	System.out.println("At the end of the day, how much cash is present?");
	double endCash = in.nextDouble();
	System.out.println("Enter the file name of the transaction record:"); // to-do, add exception handling if filename is not present
	String fileName = in.next();
	
	File cashData = new File(fileName);
	Scanner cash = new Scanner(cashData);	
	Scanner cash2 = new Scanner(cashData);	//two scanners to calculate line numbers and everything else
	int no_Transactions = 0;	
	double curCash = beginCash;			
	no_Transactions = getNumberTransactions(no_Transactions, cash);
	double endTotal = getEndTotal(no_Transactions, cash2, curCash);
	enteredVSCalc(endTotal, endCash);
	cash.close();
	in.close();
	}
	catch (FileNotFoundException e) {
	System.out.printf("Error, no such file name in directory.");
	}
	}
	
	
	//get the number of transactions, by finding out how many lines there are
	public static int getNumberTransactions(int no_Transactions, Scanner cash){
	while (cash.hasNextLine()){
	cash.nextLine();
	no_Transactions++;
	}
	return no_Transactions;
	}
	
	//loop until there are no more transactions
	//read three values at a time, and disregard the first of each
	public static double getEndTotal(int no_Transactions, Scanner cash2, double curCash){
	for (int i = 0; i < no_Transactions; i++){
		cash2.next(); 		//do nothing with this, just prompt the Scanner
		double tempAmount = cash2.nextDouble();
		String tempType = cash2.next();
		if (tempType.compareTo("R") == 0)
			curCash+=tempAmount;
		if (tempType.compareTo("P") == 0)
			curCash-=tempAmount;
	}
	return curCash;
	}
	
	public static void enteredVSCalc(double calc, double given){
	if (Math.abs(calc-given) < 0.001)
		System.out.println("Given and calculated totals match.");
	else
		System.out.println("Given and calculated totals do not match.");
	}

	
	}