import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class swimmers{
	
	public static void main(String[] args) {
	try{
	File swimmers = new File("swimmers.txt");
	Scanner in = new Scanner(swimmers);
	Scanner decide = new Scanner(System.in);
	String decision = "";
	String [] swimArray = new String [20];
	int x = 0;
	while(in.hasNextLine()){
		swimArray[x] = in.nextLine();
		x++;
	}
	System.out.println("Sort alphabetically or by best time? A/B");
	decision = decide.next();
	if(decision.compareTo("A")==0){
		InsertionSorter(swimArray);
	}
	else{
	SelectionSorter(swimArray);
	}
	for(int i=0; i<x; i++){
		System.out.println(swimArray[i]);
	}
    }
	catch (FileNotFoundException e) {
	System.out.printf("Error, no such file name in directory.");
	}
	}
  public static void InsertionSorter(String [] a)    
   {
      for (int i = 1; i < a.length; i++)
      {
         String next = a[i];
         int j = i-1;
		 while(j>=0){
         if (next.compareTo(a[j])>0)
         {
			 break;
		 }
            a[j+1] = a[j];
            j--;
         }
         a[j+1] = next;
      }
   }

   
   public static void SelectionSorter(String [] a)
   {
	      for (int i = 0; i < a.length - 1; i++)
      {  
         int minPos = minimumPosition(i, a);
         swap(minPos, i, a);
      }
   }
   private static int minimumPosition(int from, String[] a)
   {  
      int minPos = from;
      for (int i = from + 1; i < a.length; i++)
         if (a[i].compareTo(a[minPos])>0) minPos = i;
      return minPos;
   }
   private static void swap(int i, int j, String [] a)
   {
      String temp = a[i];
      a[i] = a[j];
      a[j] = temp;

   }
}

