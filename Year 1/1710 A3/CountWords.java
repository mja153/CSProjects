import java.util.Scanner;
public class CountWords {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter a sentence:");
		String sentence = in.nextLine();
		String test = "";
		if (sentence.compareTo(test) == 0)																	//test for string input
			System.out.println("Sentence not initialized. Please re-run the program.");						//if nothing input, output error
		else
			System.out.println("The number of words in the given sentence are " + wordCount(sentence) + ".");	//else, call on the wordCount method
	}
	
	public static int wordCount (String sentence) {															
		String temp;																						//temp string to hold individual chars
		int wordCounter = 1;																				//if passed test, first word exists, thus =1
		for (int i = 0; i < sentence.length(); i++){														
			temp = sentence.substring(i,i+1);																//until the loop fails, put each char into temp
				if (temp.compareTo(" ") == 0)																//if the character is a space, increase wordCounter
					wordCounter++;
		}
		return wordCounter;
	}
}