import java.util.Scanner;
import java.lang.Math;

public class Recursion{
private String text;
private String str;
private int n;
private int x;

public Recursion(){
	text = "";
	str = "";
}
public static boolean find(String text, String str){
	if(text.length()<str.length()){
		return false;
	}
	else if(text.substring(0, str.length()).equals(str)){
		return true;
	}
	else {
		text = text.substring(1);
		return find(text, str);
	}
	}


public static String oneToN(int n, int x){
	if (x>n)
		return "";
	if (x<= n && x==1){
		System.out.print(x);
		System.out.println();
		return oneToN(n, ++x);
	}
	else if (x<= n && x!=1){
		for(int i=0; i<x-1; i++){
			System.out.print(x+", ");
		}
		System.out.print(x);
		System.out.println();
		return oneToN(n, ++x);
	}
	return "";
}

public static double recursiveLogs(int n, int x, double logValue){
if (x<=n){
	logValue+=(x*(Math.log10(x)));
	recursiveLogs(n, ++x, logValue);
}
else{
	System.out.println(logValue);	
	return logValue;
}
	return logValue;
}

public static double iterativeLogs(int n, double iterativeLogValue){
	for(int i=1; i<=n; i++){
	iterativeLogValue+=(i*(Math.log10(i)));
	}
	System.out.println(iterativeLogValue);
	return iterativeLogValue;
}

public static double polygonArea(int corners, int triangleCounter, double area){
	Scanner in2 = new Scanner(System.in);
	if(corners-2==triangleCounter){
		System.out.println("The area of your polygon is: "+area);
		return area;
	}
	else if(triangleCounter == 0){
		System.out.println("Please enter the x and y coordinates of your first 3 corners: (x1 y1 x2 y2 x3 y3 etc)");
		double x1 = in2.nextDouble();
		double y1 = in2.nextDouble();
		double x2 = in2.nextDouble();
		double y2 = in2.nextDouble();
		double x3 = in2.nextDouble();
		double y3 = in2.nextDouble();
		area += (Math.abs((x1*y2)+(x2*y3)+(x3*y1)-(y1*x2)-(y2*x3)-(y3*x1)))*0.5;
		return polygonArea(corners, ++triangleCounter, area);
	}
	else{
		System.out.println("Please enter the x and y coordinates of your next 3 corners: (x1 y1 x2 y2 x3 y3 etc)");
		double x1 = in2.nextDouble();
		double y1 = in2.nextDouble();
		double x2 = in2.nextDouble();
		double y2 = in2.nextDouble();
		double x3 = in2.nextDouble();
		double y3 = in2.nextDouble();
		area += (Math.abs((x1*y2)+(x2*y3)+(x3*y1)-(y1*x2)-(y2*x3)-(y3*x1)))*0.5;
		return polygonArea(corners, ++triangleCounter, area);
	}
	}




public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	System.out.println("Which of the following options would you like to perform? Type the corresponding number to select:");
	System.out.println("1- Cross-reference a given text to see if it contains a certain string.");
	System.out.println("2- Compute the area of a polygon with n corners.");
	System.out.println("3- Produce a triangle of integers, from 1 to n.");
	System.out.println("4- Recursively and iteratively calculate the sum of 1*log(1)+2*log(2)+...+n*log(n). ");
	int option = in.nextInt();
	if(option == 1){
	System.out.println("Enter two words to see if the second is found within the first: (First Second)");
	if(find(in.next(), in.next()))
		System.out.println("Your second word was found within the first.");
	else
		System.out.println("No match.");
	}
	else if (option == 3){
	System.out.println("Enter a number to create a triangle from 1-n");
	oneToN(in.nextInt(), 1);
	}
	else if(option == 4){
	System.out.println("Enter a number to be recursively calculated using a sum of logs.");
	recursiveLogs(in.nextInt(), 1, 0);
	System.out.println("Enter a number to be iteratively calculated using a sum of logs.");
	iterativeLogs(in.nextInt(), 0);
	}
	else if (option == 2){
	System.out.println("How many corners would you like to have in your polygon?");
	polygonArea(in.nextInt(), 0, 0);
	}
	else{
		System.out.println("You have not selected a valid option.");
		System.exit(1);
	}
	
	}
}