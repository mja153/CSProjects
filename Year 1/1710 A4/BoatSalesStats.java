 import java.util.Scanner;
public class BoatSalesStats{
 public static void main( String[] args ){
 Scanner in = new Scanner(System.in);
 int [][] boatSales = {
			{1132, 48, 55, 45, 45, 35, 20, 40},
			{1135, 40, 57, 40, 25, 34, 44, 30},
			{1187, 67, 80, 35, 41, 30, 32, 47},
			{1156, 50, 60, 41, 32, 44, 51, 20},
			{1157, 58, 34, 26, 45, 43, 25, 19}
					  };
String [] names = {"Ben Zen", "Nat Mat", "Jen Ven", "Kim Sim", "Mark Park", "Earl Merl", "Walt Malt"};
 
 int x = 0;
 int y = 0;
 int sum = 0;
 int totalModel = totalBoats (boatSales);
 System.out.println();
 int totalPerson = totalSalesRep (boatSales, names);

}
public static int totalBoats (int [][] boatSales){
	int model=0;
	int x =0;
	int y =0;
	int sum =0;
	System.out.println("Model No.	Total Boats Sold");
	for(y=0;y<5;y++){
		for(x=1;x<8;x++){
		sum = (sum+(boatSales[y][x]));
		}
		System.out.println((boatSales[model][0])+"		"+(sum));
		sum=0;
		model++;
	}
	return (x);
	}
	
public static int totalSalesRep (int [][] boatSales,String[] names){
int namecount =0;
int x = 0;
int y = 0;
int sum = 0;
int q=0;
System.out.println("Name		Total Boats Sold");
	for(x=1;x<8;x++){
		for(y=0;y<5;y++){
		sum = (sum+(boatSales[y][x]));
		}
	System.out.println(names[q]+"		"+(sum));
	sum=0;
	q++;
	}
	return(q);
}
}

