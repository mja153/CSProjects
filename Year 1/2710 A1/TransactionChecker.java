	public class TransactionChecker{
	public static void main(String[] args) {
	double HST = 0;
	
	Item Banana = new Item("01011361", "Banana", 0.99, 3.2, "F");
	Item Apple = new Item("01011456", "Apple", 1.69, 5, "F");
	Item Pizza = new Item("02033685", "Pizza", 6.99, 2, "T");
	Item BananaCake = new Item("03055676", "Banana Cake", 5.49, 2, "T");
	Item Sugar = new Item("04005667", "Sugar", 3.99, 1, "T");
	Item[] items = {Banana, Apple, Pizza, BananaCake, Sugar};
	Transaction t1 = new Transaction("21/12/2014");
	t1.printReceipt(t1.calcHST(items), items);
	
	
	Banana = new Item("01011361", "Banana", 0.99, 10, "F");
	Apple = new Item("01011456", "Apple", 1.69, 2, "F");
	Pizza = new Item("02033685", "Pizza", 6.99, 6, "T");
	BananaCake = new Item("03055676", "Banana Cake", 5.49, 4, "T");
	Sugar = new Item("04005667", "Sugar", 3.99, 3, "T");
	items = new Item [] {Banana, Apple, Pizza, BananaCake, Sugar};
	Transaction t2 = new Transaction("1/1/2011");
	t2.printReceipt(t2.calcHST(items), items);
	
	
	Banana = new Item("01011361", "Banana", 0.99, 1, "F");
	Apple = new Item("01011456", "Apple", 1.69, 1, "F");
	Pizza = new Item("02033685", "Pizza", 6.99, 1, "T");
	BananaCake = new Item("03055676", "Banana Cake", 5.49, 1, "T");
	Sugar = new Item("04005667", "Sugar", 3.99, 1, "T");
	items = new Item [] {Banana, Apple, Pizza, BananaCake, Sugar};
	Transaction t3 = new Transaction("12/12/2012");
	t3.printReceipt(t3.calcHST(items), items);
	}
	}
		