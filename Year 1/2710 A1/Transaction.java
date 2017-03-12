public class Transaction{
	private String time;
	private static int numTransaction;
		
		public Transaction(String initTime){
			time = initTime;
			numTransaction = 0;
		
		}
		
		public String getTime(){
			return time;
		}
		public void setTime(String newTime){
			time = newTime;
		}
		
		public String listItems(Item[] items){
		String list = "";
			for (int i=0; i<items.length; i++){
				list+=(items[i].getName() + ", ");
				}
			return list;
			}
		
		public double calcHST(Item[] items){
		double HST = 0;
		for (int i = 0; i<items.length; i++){				
			if (items[i].getHST().compareTo("T") == 0)	
				HST += items[i].subtotal()*0.15;		
			if (items[i].getHST().compareTo("F") == 0)
				HST += 0;									
		}
		return HST;
		}
		
		public void printReceipt(double HST, Item[] items){		//prints receipt.
			double total = 0;
			System.out.println("RECEIPT:");
			System.out.println("Date: " + time);
			System.out.printf("%-10s%-20s %10s %10s %s%n", "Code", "Product Name", "Unit Cost", "Quantity", "Taxability");
				for (int i = 0; i < items.length; i++){
					System.out.printf("%-10s%-20s %10.2f %10.2f %s%n",items[i].getCode(),items[i].getName(),items[i].getQuantity(),items[i].getPrice(),items[i].getHST());
					total += items[i].subtotal();
				}
			System.out.printf("Total HST: $%.2f%n", HST);
			System.out.printf("Grand Total: $%.2f%n%n", total+HST);
			numTransaction++;
			}
			
	public static void main(String[] args) {
	}
	}