import java.util.Scanner;
public class PrintingSquares{
	public static void main(String[] args) {
Scanner in = new Scanner(System.in);
		System.out.print("What is the size of the box that you would like to create? ");
		int height = in.nextInt();
		int x = 0;
		for (int y = 0; y<height; y++)	
			{
			System.out.print("*");
			}
		System.out.print(" ");
		for (int y = 0; y<height; y++)	
			{
			System.out.print("*");
			}
			System.out.println();
		do {	
			for (int y = 0; y<height; y++)			
			{
			System.out.print("*");
			}
			System.out.print(" ");
			System.out.print("*");
			for (int y = 0; y<height-2; y++)
			{
			System.out.print(" ");
			}
			System.out.print("*");
			System.out.println();
			x++;
		}
		while (x<height-2);
		
		for (int y = 0; y<height; y++)			
			{
			System.out.print("*");
			}
		System.out.print(" ");
				for (int y = 0; y<height; y++)			
			{
			System.out.print("*");
			}
			System.out.println();
	}
}