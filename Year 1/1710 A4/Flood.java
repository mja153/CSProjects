import java.util.Scanner;
public class Flood {
	public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	double[][] heights = new double[10][10];
	System.out.println("Please enter 100 terrain heights:");
	heights = getHeights(in, heights);	
	double maximumHeight = findMax(heights);
	double minimumHeight = findMin(heights);
	double stepSize = 0;
	int i = 0;
	for (i = 0; i <= 10; i++){	//loop calculates the "step size" for each increment in water level
		stepSize = ((maximumHeight - minimumHeight) / 10);
		System.out.printf("%nWhen the height of water is %.1f units high, this is the flood map.%n", (stepSize*i + minimumHeight));
		stepSize = stepSize*(i+1);
		floodMap(heights, stepSize);
	}
	}
	
	public static double[][] getHeights(Scanner in, double[][] heights) {	//method requests input of 100 heights
	for (int h = 0; h < heights.length; h++){
		for (int w = 0; w < heights[0].length; w++){
			heights[h][w] = in.nextInt();
		}
	}
	return heights;
	}
	
	public static double findMax(double[][] heights) {	//max of all 100 values
	double maxH = 0;
	double temp = heights[0][0];
	for (int h = 0; h < heights.length; h++){
		for (int w = 0; w < heights[0].length-1; w++){
			maxH = Math.max(temp, heights[h][w+1]);
		}
		temp = maxH;
	}
	return maxH;
	}
	
	public static double findMin(double[][] heights) {	//min of all 100 values
	double minH = 0;
	double temp = heights[0][0];
	for (int h = 0; h < heights.length; h++){
		for (int w = 0; w < heights[0].length-1; w++){
			minH = Math.min(temp, heights[h][w+1]);
		}
		temp = minH;
	}
	return minH;
	}
	
	public static void floodMap(double[][] heights, double waterLevel) { //prints the flood maps
	for (int h = 0; h < heights.length; h++){
		for (int w = 0; w < heights[0].length; w++){
			if (heights[h][w] <= waterLevel)
				System.out.print("*");
			if (heights[h][w] > waterLevel)
				System.out.print(" ");
			if (w == heights[0].length-1)	//checks to see if ready to go to next line
				System.out.println();
		}
	}
	}
}