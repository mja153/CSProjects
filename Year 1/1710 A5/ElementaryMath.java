import java.util.Scanner;
public class ElementaryMath {

public static void main(String[] args){
Menu();
}

public static void Menu(){
	System.out.printf("Please select an option from the following menu.%n%n1 - Elementary Math with 1 digit%n2 - Elementary Math with 2 digits%n3 - Elementary Math with 3 digits%n%n");
	Scanner in = new Scanner(System.in);
	int choice = in.nextInt();
	if (choice == 1)
		oneDigit();
	if (choice == 2)
		twoDigit();
	if (choice == 3)
		threeDigit();
}

public static void oneDigit(){
System.out.println("How many questions would you like to evaluate?");
Scanner in = new Scanner(System.in);
int choice = in.nextInt();
int inputAns, tally = 0;
int temp = 0;
for (int i = 0; i < choice; i++){
	double picking = Math.random();
	int a = (int)(10* Math.random());
	int b = (int)(10* Math.random());
	int a_b = 0;
	if (picking <= 0.5){					//subtraction or addition?
		a_b = a+b;
		System.out.println(a + " + " + b);
		inputAns = in.nextInt();
	if (inputAns == a_b)
		tally = isRight(tally);
}
else if (picking > 0.5){
	if (a < b){
		temp = b;
		b = a;
		a = b;
	}
	a_b = a-b;
	System.out.println(a + " - " + b);
	inputAns = in.nextInt();
	if (inputAns == a_b)
		tally = isRight(tally);
}
}
//display user's score
displayScore(tally, choice);
}

public static void twoDigit(){
System.out.println("How many questions would you like to evaluate?");
Scanner in = new Scanner(System.in);
int choice = in.nextInt();
int inputAns, tally = 0;
int temp = 0;
for (int i = 0; i < choice; i++){
	double picking = Math.random();
	int a = (int)(100* Math.random());
	if (a < 10)
		a+=10;
	int b = (int)(100* Math.random());
	if (b < 10)
		b+=10;
	int a_b = 0;
	if (picking <= 0.5){
		a_b = a+b;
	System.out.println(a + " + " + b);
	inputAns = in.nextInt();
	if (inputAns == a_b)
		tally = isRight(tally);
}
else if (picking > 0.5){
	if (a < b){
		temp = b;
		b = a;
		a = b;
	}
	a_b = a-b;
	System.out.println(a + " - " + b);
	inputAns = in.nextInt();
	if (inputAns == a_b)
		tally = isRight(tally);
}
}
displayScore(tally, choice);
}

public static void threeDigit(){
System.out.println("How many questions would you like to evaluate?");
Scanner in = new Scanner(System.in);
int choice = in.nextInt();
int inputAns, tally = 0;
int temp = 0;
for (int i = 0; i < choice; i++){
	double picking = Math.random();
	int a = (int)(1000* Math.random());
	if (a < 100)
		a+=100;
	int b = (int)(1000* Math.random());
	if (b < 100)
		b+=100;
	int a_b = 0;
	if (picking <= 0.5){
		a_b = a+b;
	System.out.println(a + " + " + b);
	inputAns = in.nextInt();
	if (inputAns == a_b)
		tally = isRight(tally);
}
	else if (picking > 0.5){
		if (a < b){
			temp = b;
			b = a;
			a = b;
		}
	a_b = a-b;
	System.out.println(a + " - " + b);
	inputAns = in.nextInt();
	if (inputAns == a_b)
		tally = isRight(tally);
}
}
displayScore(tally, choice);
}

public static int isRight(int tally){
tally++;
return tally;
}

public static void displayScore(int noCount, int noQuestion){
System.out.println("Your score is " + noCount + "/" + noQuestion + ".");
}

}
