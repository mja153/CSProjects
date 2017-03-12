import java.util.Scanner;
public class AdjacentDuplicates{
	public static void main(String[] args) {
		System.out.println("Please enter a string of numbers separated by space terminated by 0: ");
		Scanner in = new Scanner(System.in);
		int n2 = -1;
		int numcount = 0;
		int previousNum = in.nextInt();

		do{
			n2 = in.nextInt();
			if(n2 == previousNum){
				numcount++;
			} else if(numcount>0) {
				System.out.print(previousNum+" ");
				numcount = 0;
			}
			
			if(n2 == 0 && numcount>0)
				System.out.print(previousNum+" ");
				
			previousNum = n2;
		}while(n2 != 0);
		in.close();		
	}
}
