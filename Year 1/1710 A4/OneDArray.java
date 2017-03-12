import java.util.Scanner;
import java.util.Arrays;
public class OneDArray {
	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	System.out.println("Please enter the size of the array:");
	int arSize = in.nextInt();
	int[] arr = new int[arSize];
	System.out.println("Please enter " + arSize + " integers.");
	for (int i = 0; i < arSize; i++)
		arr[i] = in.nextInt();
	boolean isSorted = alreadySorted(arr);
	System.out.printf("Elements shifted by 1: %n%s%n%n",Arrays.toString(shift(arr)));
	System.out.printf("Elements have been replaced with their largest neighbor: %n%s%n%n",Arrays.toString(large(arr)));
	System.out.printf("The second largest element is: %n%d%n%n",secondLarge(arr));
	System.out.printf("Are the integers already sorted? %n%b%n%n",isSorted);

	}
	
	// part b
	public static int[] shift(int[] ar) {
	int[] temp = new int[ar.length];
	for (int i = 1; i < ar.length; i++){
		if (i - 1 != -1)
			temp[i] = ar[i-1];
		if (i+1 == ar.length)
			temp[0] = ar[i];	
	}
	return temp;
	}
	
	//part d ??
	public static int[] large(int[] ar) {
	int[] temp = new int[ar.length];
	for (int i = 1; i < ar.length-1; i++){
		temp[i] = Math.max(ar[i-1],ar[i+1]);
	}
	temp[0] = ar[0];
	temp[ar.length-1] = ar[ar.length-1];
	return temp;
	}
	
	//part g
	public static int secondLarge(int[] ar) {
	int[] sorted = ar;
	int temp = 0;
	for (int i = 0; i < sorted.length; i++){
		for (int j = i+1; j < sorted.length; j++){
			if (sorted[i] > sorted[j]){
				temp = sorted[i];				//preserve larger value
				sorted[i] = sorted[j];			//replace larger value with smaller
				sorted[j] = temp;				//replace smaller value with larger
			}
		}
	}
	return sorted[sorted.length-2];
	}
	
	public static boolean alreadySorted(int[] ar) {
	boolean temp = true;
	int i = 0;
	for (int j = 1; j < ar.length && temp; j++){
		if (ar[i] < ar[j])
			temp = true;
		else
			temp = false;
	}
	return temp;
	}
}