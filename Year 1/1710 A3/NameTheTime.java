import java.util.Scanner;
public class NameTheTime{
	public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	String hours = "";
	String mins = "";
	System.out.println("Please give the current hour as an integer from 1 to 12:");
	int hour = in.nextInt();
	if (hour <= 12 && hour > 0){														
		System.out.println("Please give the current minute as an integer from 0 to 60:");
		int minute = in.nextInt();
		if (minute <= 60 && minute >= 0){										
			String time = getTimeName(hour, minute, hours, mins);
			System.out.println(time);	
		}
		else																			
			System.out.println("Minute out of range. Enter an integer between 0 and 60");
	}
	else																				
		System.out.println("Hour out of range. Enter an integer between 1 and 12.");
	}
	
	public static String getTimeName(int hour, int minute, String hours, String mins){
		String time = "";
		if (minute == 0)															
		time = "The time is "+hourToWord(hours, hour)+" o'clock.";
		if (minute == 15)															
		time = "The time is "+minToWord(mins, minute)+" "+hourToWord(hours, hour)+".";
		if (minute == 30)															
		time = "The time is "+minToWord(mins, minute)+" "+hourToWord(hours, hour)+".";
		if (minute < 30 && minute > 9 && minute != 0 && minute!= 15) 				
		time = "The time is "+minToWord(mins, minute)+" minutes past "+hourToWord(hours, hour)+".";
		if (minute <= 9 && minute > 0)															
		time = "The time is"+minToWord(mins, minute)+" minutes past "+hourToWord(hours, hour)+".";
		if (minute > 30 && minute != 45)											
		time = "The time is "+minToWord(mins, Math.abs(minute-60))+" minutes to "+hourToWord(hours, hour+1)+".";
		if (minute == 45)															
		time = "The time is "+minToWord(mins, minute)+" "+hourToWord(hours, hour+1)+".";
		return time;
	}
	
	public static String minToWord(String mins, int minute){
	if (minute == 0)
	mins = "";
	else if (minute == 15)
	mins = "quarter past";
	else if (minute == 30)
	mins = "half past";
	else if (minute == 45)
	mins = "quarter to";
	else if (minute == 10)
	mins = "ten";
	else if (minute == 11)
	mins = "eleven";
	else if (minute == 12)
	mins = "twelve";
	else if (minute == 13)
	mins = "thirteen";
	else if (minute == 14)
	mins = "fourteen";
	else if (minute == 15)
	mins = "fifteen";
	else if (minute == 16)
	mins = "sixteen";
	else if (minute == 17)
	mins = "seventeen";
	else if (minute == 18)
	mins = "eighteen";
	else if (minute == 19)
	mins = "nineteen";
	else	
	mins = minToDigit(minute, mins);
	return mins;
	}
	
	
	public static String hourToWord(String hours, int hour){
	if (hour == 1 || hour == 13)
	hours = "one";
	if (hour == 2)
	hours = "two";
	if (hour == 3)
	hours = "three";
	if (hour == 4)
	hours = "four";
	if (hour == 5)
	hours = "five";
	if (hour == 6)
	hours = "six";
	if (hour == 7)
	hours = "seven";
	if (hour == 8)
	hours = "eight";
	if (hour == 9)
	hours = "nine";
	if (hour == 10)
	hours = "ten";
	if (hour == 11)
	hours = "eleven";
	if (hour == 12)
	hours = "twelve";
	return hours;
	}
	
	
	public static String minToDigit(int minute, String mins){
	int digit1 = minute / 10;	
	int digit2 = minute % 10;	
		if (digit2 == 0)		
		mins = digit1ToWord(digit1);
		else
		mins = digit1ToWord(digit1) + digit2ToWord(digit2);
	return mins;
	}
	
	
	public static String digit1ToWord(int digit1){
	String tens = "";
	if (digit1 == 2)
	tens = "twenty";
	if (digit1 == 3)
	tens = "thirty";
	if (digit1 == 4)
	tens = "forty";
	if (digit1 == 5)
	tens = "fifty";
	return tens;
	}
	
	
	public static String digit2ToWord(int digit2){
	String units = "";
	if (digit2 == 1)
	units = " one";	
	if (digit2 == 2)
	units = " two";
	if (digit2 == 3)
	units = " three";
	if (digit2 == 4)
	units = " four";
	if (digit2 == 5)
	units = " five";
	if (digit2 == 6)
	units = " six";
	if (digit2 == 7)
	units = " seven";
	if (digit2 == 8)
	units = " eight";
	if (digit2 == 9)
	units = " nine";
	return units;
	}
}