import java.util.Scanner;
public class ConcreteAndSod{
	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	System.out.println("Please enter the length of the field:");
	int fLength = in.nextInt();
	System.out.println("Please enter the width of the field:");
	int fWidth = in.nextInt();
	System.out.println("Please enter the width of the concrete walkway:");
	int wWidth = in.nextInt();
	System.out.println("Please enter length of the two radii of the oval pond:");
	double radius1 = in.nextDouble();
	double radius2 = in.nextDouble();
	int fieldArea = findFieldArea(fLength, fWidth);
	double pondArea = findPondArea(radius1, radius2);
	double areaSod = printArea(fLength, fWidth, wWidth, radius1, radius2, fieldArea, pondArea);
}
public static int findFieldArea(int length, int width){
	int fieldArea = (length)*(width);
	return fieldArea;
}
public static double findPondArea(double r1, double r2){
	double pondArea = (Math.PI)*(r1*r2);
	return pondArea;
}
public static double printArea(int fLength, int fWidth, int wWidth, double radius1, double radius2, int fieldArea, double pondArea){
	int walkwayArea = (fieldArea-((fLength)-(wWidth))*((fWidth)-(wWidth)));
	double areaSod = ((fLength)-(wWidth))*((fWidth)-(wWidth)-(pondArea));
	System.out.println("The area of the concrete walkway is: "+walkwayArea);
	System.out.print("The area with sod is: ");
	System.out.printf("%.2f", areaSod);
	return areaSod;
}
}