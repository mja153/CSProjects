import java.util.Scanner;
import java.util.ArrayList;
public class AirlineSeating {

private double numPassenger;
private String seatingpref;
private String avail;
private double seatNumber;
private String cabin;

public AirlineSeating(){
	seatingpref = "";
	avail = "";
	}
public AirlineSeating(double np, String sp, String a, double sn){
	String cabin;
	numPassenger = np;
	seatingpref = sp;
	avail = a;
	seatNumber = sn;
	}
	
	public double getNumPassenger(){
		return numPassenger;
		}
	
	public String getSeatingPref(){
		return seatingpref;
		}
		
	public String getAvailability(){
		return avail;
		}
	
	public double getSeatNumber(){
		return seatNumber;
		}
	
	public double setNumPassenger(double newNum){
		numPassenger = newNum;
		return numPassenger;
		}
	
	public String setSeatingPreg(String newPref){
		seatingpref = newPref;
		return seatingpref;
		}
		
	public String setAvailability(String newAvail){
		avail = newAvail;
		return avail;
		}
	
	public double setSeatNumber(double newSeatNumber){
		seatNumber = newSeatNumber;
		return seatNumber;
		}
		
	public String addAndListPassenger(int option, String cabin, double numPassenger, String seatingpref, String avail, double seatNumber, int assigned){
		int numfcremain = 20;
		int numeconremain = 90;
		ArrayList<AirlineSeating> seats = new ArrayList<AirlineSeating>(110);
		for(int n=1; n<11; n++){
			firstClass temp = new firstClass(1, "Window", "Available", n);
			seats.add(temp);
			}
		for (int n=11; n<21; n++){
			firstClass temp = new firstClass(1, "Aisle", "Available", n);
			seats.add(temp);
			}
		for(int n=21; n<51; n++){
			economy temp = new economy(1, "Window", "Available", n);
			seats.add(temp);
			}
		for(int n=51; n<81; n++){
			economy temp = new economy(1, "Center", "Available",n);
			seats.add(temp);
			}
		for(int n=81; n<111; n++){
			economy temp = new economy(1, "Aisle", "Available", n);
			seats.add(temp);
			}
			
		for(AirlineSeating i: seats){
			if(option ==1 && i instanceof firstClass && seatingpref.compareTo(i.getSeatingPref())==0 && avail.compareTo(i.getAvailability())==0 && cabin.compareTo("FirstClass")==0 && numPassenger<=numfcremain && assigned<numPassenger){
				System.out.println("Your seat number is: "+i.getSeatNumber());
				i.setAvailability("Unavailable");
				numfcremain-=i.getNumPassenger();
				assigned++;
			}
			
			else if(option ==1 && cabin.compareTo("FirstClass")==0 && avail.compareTo(i.getAvailability()) !=0){
			if(assigned>=numPassenger){
				break;
				}
			else{
				System.out.println("Sorry, your required seat(s) is(are) not available");
				assigned++;
				}
			}
			
			else if(cabin.compareTo("FirstClass") !=0){
				}
			}
			
			
			
		for(AirlineSeating i: seats){
			if(option ==1 && i instanceof economy && seatingpref.compareTo(i.getSeatingPref())==0 && avail.compareTo(i.getAvailability())==0 && cabin.compareTo("Economy")==0 && numPassenger<=numfcremain && assigned<numPassenger){
				System.out.println("Your seat number is: "+i.getSeatNumber());
				i.setAvailability("Unavailable");
				numfcremain-=i.getNumPassenger();
				assigned++;
			}
			
			else if(option ==1 && cabin.compareTo("Economy")==0 && avail.compareTo(i.getAvailability()) !=0){
			if(assigned>=numPassenger){
				break;
				}
			else{
				System.out.println("Sorry, your required seat(s) is(are) not available");
				assigned++;
				}
			}
			
			else if(cabin.compareTo("Economy") !=0){
				}
		}
			
		if(option ==2){
			for(AirlineSeating i: seats){
			System.out.println(i.toString());
			}
		}
		return "";
	}
	}
		

			
	class firstClass extends AirlineSeating{
	
		public firstClass(double np, String sp, String a, double sn){
			super(np,sp,a,sn);
		}
		public String toString(){
			return "Class: First Class  "+"Seat Number: "+getSeatNumber()+"  Location: "+getSeatingPref()+ "  Availability: "+getAvailability();
			}
		}
	class economy extends AirlineSeating{
		public economy(double np, String sp, String a, double sn){
			super(np,sp,a,sn);
		}
		public String toString(){
			return "Class: Economy  "+"Seat Number: "+getSeatNumber()+"  Location: "+getSeatingPref()+ "  Availability: "+getAvailability();
			}
		}
		
	
	class AirlineTester{
	public static void main(String[] args){
		int option = 0;
		Scanner in = new Scanner(System.in);
		System.out.println("Please follow these instructions:");
		System.out.println("Type 1 to Add Passenger(s)    | Type 2 to Show Seating    | Type 3 to Exit");
		option = in.nextInt();
		if(option==1){
			System.out.println("Please enter the following information: (Class | Number of Passengers | Seating Preference [Window, Aisle, Center])");
			firstClass q = new firstClass(2, "yes", "Available", 0);
			q.addAndListPassenger(1, in.next(), in.nextDouble(), in.next(), "Available", 0, 0);
			}
		if(option==2){
			firstClass q = new firstClass(2, "yes", "Available", 0);
			q.addAndListPassenger(2, "option2", 0, "option2" , "option2", 0, 0);
			}
		if(option==3){
			System.exit(1);
			}
		}
		}
