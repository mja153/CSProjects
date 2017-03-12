import java.util.ArrayList;
public class Fruit {

	private String name;
	private String place;
	private String date;
	
	public Fruit() {									//FRUIT CLASS
		name = "";
		place = "";
		date = "";
		}
	
	public Fruit(String n, String p, String d){			// Fruit Constructor
		name = n;
		place = p;
		date = d;
		}
		
	public String getName(){							// Fruit accessor & mutators
		return name;
		}
	public String getPlace(){
		return place;
		}
	public String getDate(){
		return date;
		}
	public String setName(String newName){
		name = newName;
		return name;
		}
	public String setPlace(String newPlace){
	place = newPlace;
			return place;
		}
	public String setDate(String newDate){
		date = newDate;
		return date;
		}
	public String toString(){							// Fruit toString method
		return "Name of Fruit: "+getName()+ ", Place of Product: "+getPlace()+", Date of Product: "+getDate()+", ";
		}
}
			
	class FreshFruit extends Fruit{						//FRESHFRUIT CLASS
		
		private String unitType;
		private double weight;
		
	public FreshFruit(){
		unitType = "";
		weight = 0;
		}
		
	public FreshFruit(String n, String p, String d, String t, double w){ 		// FreshFruit constructor
		super(n, p, d);
		unitType = t;
		weight = w;
		}
	public String getType(){								//FreshFruit mutators & accessors
		return unitType;
		}
	public double getWeight(){
		return weight;
		}
	public String setType(String newType){
		unitType = newType;
		return unitType;
		}
	public double setWeight(double newWeight){
		weight = newWeight;
		return weight;
		}
	public String toString(){								//FreshFruit toString method
		return  "Name of Fruit: "+getName()+ ", Place of Product: "+getPlace()+", Date of Product: "+getDate()+", Unit Type: "+getType() +", Weight: "+getWeight()+", ";
		}
	}
		
	class Apple extends FreshFruit{			//APPLE CLASS
			
		private String typeApple;
		private double code;
		private double quality;
		private double price;
			
		public Apple(){
			typeApple = "";
			}
			
		public Apple (String n, String p, String d, String t, double w, String ta, double c, double q, double pr){			//Apple constructor
			super(n, p, d, t, w);
			typeApple = ta;
			code = c;
			quality = q;
			price = pr;
			}
		public String getTypeApple(){						//Apple Accessors/mutators
			return typeApple;
			}
		public double getCode(){
			return code;
			}
		public double getQuality(){
			return quality;
			}
		public double getPrice(){
			return price;
			}
		public String setTypeApple(String aType){
			typeApple = aType;
			return typeApple;
			}
		public double setCode(double newCode){
			code = newCode;
			return code;
			}
		public double setQuality(double newQual){
			quality = newQual;
			return quality;
			}
		public double setPrice(double newPrice){
			price = newPrice;
			return price;
			}
		public String toString(){							//Apple toString method
			return  "Name of Fruit: "+getName()+ ", Place of Product: "+getPlace()+", Date of Product: "+getDate()+", Unit Type: "+getType() +", Weight: "+getWeight()+", Type of Apple: "+getTypeApple()+", Product Code: "+getCode()+", Quality Degree: "+getQuality()+", Price Per Unit: "+getPrice();
			}
		}
				
		class DryFruit extends Fruit{						//DRYFRUIT CLASS
			private String mixed;
			private String bestBefore;
			private String packageWeight;
			
		public DryFruit(){
			mixed = "";
			}
		public DryFruit(String n, String p, String d, String m, String bbf, String packw){			//DryFruit constructor
			super(n, p, d);
			mixed =  m;
			bestBefore = bbf;
			packageWeight = packw;
			}
		public String getMixed(){											//DryFruit accessors/mutators
			return mixed;
			}
		public String getBestBefore(){
			return bestBefore;
			}
		public String getPackageWeight(){
			return packageWeight;
			}
		public String setMixed(String newMix){
			mixed = newMix;
			return mixed;
			}
		public String setBestBefore(String newBBF){
			bestBefore = newBBF;
			return bestBefore;
			}
		public String setPackageWeight(String newPW){
			packageWeight = newPW;
			return packageWeight;
			}
		public String toString(){										//DryFruit toString method
			return "Name of Fruit: "+getName() +", Place of Product: "+getPlace()+", Date of Product: "+getDate()+", Mixed with: "+getMixed()+", Best Before: "+getBestBefore()+", Package Weight: "+getPackageWeight();
			}
		}
		class Berry extends DryFruit{								//BERRY CLASS
			private String typeBerry;
			private String barcode;
			private double packagePrice;
				
		public Berry(){
			typeBerry = "";
			barcode = "";
			}
		public Berry(String n, String p, String d, String m, String bbf, String packw, String tb, String bc, double pp){			//Berry Constructor
			super(n, p, d, m, bbf, packw);
			typeBerry = tb;
			barcode = bc;
			packagePrice = pp;
			}
		public String getBerry(){												//Berry accessors/mutators
			return typeBerry;
			}
		public String getBarcode(){
			return barcode;
			}
		public double getPackagePrice(){
			return packagePrice;
			}
		public String setBerry (String newBerryType){
			typeBerry = newBerryType;
			return typeBerry;
			}
		public String setBarcode(String newBarcode){
			barcode = newBarcode;
			return barcode;
			}
		public double setPackPrice(double newPackPrice){
			packagePrice = newPackPrice;
			return packagePrice;
			}
		public String toString(){										//Berry toString
			return "Name of Fruit: "+getName() +", Place of Product: "+getPlace()+", Date of Product: "+getDate()+", Mixed with: "+getMixed()+", Best Before: "+getBestBefore()+", Package Weight: "+getPackageWeight()+ ", Type of Berry: "+getBerry()+", Barcode: "+getBarcode()+", Price Per Package: "+getPackagePrice()+".";
			}
		}
			
			
			//Tester Class.
class FruitTester{
	
	public static void main(String[] args){
		Fruit a = new Fruit("Peach", "South America", "November 2014");
		FreshFruit b = new FreshFruit("Banana", "Brazil", "June 2015", "Box", 10);
		Apple c = new Apple("Apple", "Nova Scotia", "August 2014", "Bag", 15, "Granny Smith", 002040, 4, 20);
		DryFruit d = new DryFruit("Apricot", "Canada", "January 2011", "none", "January 2018", "10 lb");
		Berry e = new Berry("Strawberry", "China", "February 2014", "yogurt chips", "October 2020", "5 lb", "Strawberry", "0020 4004 2020", 10);
		
		//Testing Fruit class methods
		a.setName("NotPeach");
		a.setPlace("Antarctica");
		a.setDate("November 2020");
		System.out.println(a.getName()+", "+a.getPlace()+", "+a.getDate());
		
		//Testing FreshFruit class methods
		b.setType("Bag");
		b.setWeight(50);
		System.out.println(b.getType()+", "+b.getWeight());
		
		//Testing Apple class methods
		c.setTypeApple("Golden Delicious");
		c.setCode(021212);
		c.setQuality(5);
		c.setPrice(10);
		System.out.println(c.getTypeApple()+", "+c.getCode()+", "+c.getQuality()+", "+c.getPrice());
		
		//Testing DryFruit class methods
		d.setMixed("yogurt chips");
		d.setBestBefore("January 2020");
		d.setPackageWeight("5lb");
		System.out.println(d.getMixed()+", "+d.getBestBefore()+", "+d.getPackageWeight());
		
		//Testing Berry class methods
		e.setBerry("Blueberry");
		e.setBarcode("1111 2222 3333");
		e.setPackPrice(15);
		System.out.println(e.getBerry()+", "+e.getBarcode()+", "+e.getPackagePrice());
		
		ArrayList<Fruit> fruits = new ArrayList<Fruit>();
		fruits.add(a);
		fruits.add(b);
		fruits.add(c);
		fruits.add(d);
		fruits.add(e);
		
		for(Fruit i: fruits){
		System.out.println(i.toString());
		System.out.println();
		}
	}
		
		}
			
		
			