import java.util.Scanner;
public class Appointment {

	private String description;
	private int yr;
	private int mo;
	private int da;
	
	public Appointment(){																					
		description = "";
		}
	public Appointment (String descrip, int y, int m, int d){
		description = descrip;
		yr = y;
		mo = m;
		da = d;
		}
	
	public String getDescription(){
		return description;
		}
	public int getDay(){
		return da;
		}
	public int getYear(){
		return yr;
		}
	public int getMonth(){
		return mo;
		}
	public String setDescription(String newDescription){
		description = newDescription;
		return description;
		}
	public int setDay(int newDay){
		da = newDay;
		return da;
		}
	public int setYear(int newYear){
		yr = newYear;
		return yr;
		}
	public int setMonth(int newMonth){
		mo = newMonth;
		return mo;
		}
		
public String occursOn(int year, int month, int day){
	Appointment[] appointments ={new Onetime("Plastic Surgery", 2014, 10, 5), new Daily("You're sick", 2015, 10, 10), new Daily("Check-Up", 2014, 01, 03), new Monthly("Touch-ups", 2014, 01, 10)};
	
		for(Appointment i: appointments){
			if(i instanceof Onetime && day==i.getDay() && month==i.getMonth() && year==i.getYear()){
				System.out.println("Appointment Found: "+" Description: "+i.getDescription());
				}
			if(i instanceof Daily){
				System.out.println("Appointment Found: "+" Description: "+i.getDescription());
			}
	
			if(i instanceof Monthly && day==i.getDay()){
				System.out.println("Appointment Found: "+" Description: "+i.getDescription());
			}
		}
		return "";
		}
	
	class Onetime extends Appointment{

	public Onetime (String descrip, int y, int m, int d){
		super(descrip, y, m, d);
		}
	}
	
	class Daily extends Appointment{
	
	public Daily (String descrip, int y, int m, int d){
		super(descrip, y, m, d);
		}
	}
	
	class Monthly extends Appointment{
	
	public Monthly (String descrip, int y, int m, int d){
		super(descrip, y, m, d);
		}
	}
}
	
	class AppointmentTester{
	public static void main(String[] args){
		System.out.println("Please enter a date: (YYYY MM DD) ");
		Scanner in = new Scanner(System.in);
		Appointment list = new Appointment("blank", 01, 01, 2000);
		System.out.println(list.occursOn(in.nextInt(), in.nextInt(), in.nextInt()));
		}
	}