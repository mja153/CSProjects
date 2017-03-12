import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class MergeLists{
 public static void main( String[] args ){
 Scanner in = new Scanner(System.in);
 System.out.println("How many integers would you like to have in your first array?");
 int length1 = in.nextInt();
  System.out.println("Please enter your first array: ");
 ArrayList<Integer> a = new ArrayList<Integer>();
	for (int x=0;x<length1; x++){
		a.add(in.nextInt());
		}
 System.out.println("How many integers would you like to have in your second array?");
 int length2 = in.nextInt();
  System.out.println("Please enter your second array: ");
 ArrayList<Integer> b = new ArrayList<Integer>();
	for (int y=0;y<length2; y++){
		b.add(in.nextInt());
		}
 ArrayList<Integer> d = mergeSorted(a, b, length1, length2);
 
 }
 public static ArrayList<Integer> mergeSorted(ArrayList<Integer> a, ArrayList<Integer> b, int length1, int length2){

 ArrayList<Integer> c = b;
 int large = 0;
 int value =0;
 
	for(int i=0; i<length1; i++){
	c.add(a.get(i));
	}
Collections.sort(c);
 
 
 System.out.print("The merged arraylist is: "+ c.toString());
 return c;
	}	
 }
 
 
 
 
 

