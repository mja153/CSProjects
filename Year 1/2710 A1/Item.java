	public class Item{
		private String code;
		private String name;
		private double price;
		private double quantity;
		private String hst;
		
		public Item(String initCode, String initName, double initPrice, double initQuantity, String initHST){
			code = initCode;
			name = initName;
			price = initPrice;
			quantity = initQuantity;
			hst = initHST;
		}
		public String getCode(){
			return code;
		}
		public String getName(){
			return name;
		}
		public double getPrice(){
			return price;
		}
		public double getQuantity(){
			return quantity;
		}
		public String getHST(){
			return hst;
		}
		public void setCode(String newCode){
			code = newCode;
		}
		public void setName(String newName){
			name = newName;
		}
		public void setPrice(int newPrice){
			price = newPrice;
		}
		public void setQuantity(int newQuantity){
			quantity = newQuantity;
		}
		public void setHST(){
			if(hst=="F"){
				hst="T";
			}
			if(hst=="T"){
				hst="F";
			}
		}
		public double subtotal(){
			return price*quantity;
			}
		public String toString(){
			return (code + "   " + name + "   " + price + "   " + quantity + "   " + hst);
			}
	}
	
