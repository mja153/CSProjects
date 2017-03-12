import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class StudentGrades {
	private HashMap<String,String> students;
	
	public StudentGrades(){
		students = new HashMap<String,String>();
	}

	public void addStudent(String n){
		students.put(n,"");
	}
	
	public void removeStudent(String n){
		students.remove(n);
	}
	
	public void modifyGrades(String n, String g){
		students.put(n,g);
	}
	
	public String printStats(){
		String list = "";
		String[] sorted = sort();
		for (int i = 0; i < sorted.length; i+=2)
			list += sorted[i] + ": " + sorted[i+1] + "\n";
		return list;
	}
	
	public String[] sort(){
		String[] names = new String[students.size()];
		String[] grades = new String[students.size()];
		int x = 0;
		for (String name: students.keySet()){
			names[x] = name;
			grades[x] = students.get(name);
			x++;
		}
		for (int i = 1; i < names.length; i++){
			String nextName = names[i];
			String nextGrade = grades[i];
			int j = i;
			while (j > 0 && names[j-1].compareTo(nextName) > 0){
			   names[j] = names[j-1];
			  grades[j] = grades[j-1];
			   j--;
			}
			names[j] = nextName;
			grades[j] = nextGrade;
		}		
		String[] combined = new String[names.length + grades.length];
		for (int i = 0; i < (names.length + grades.length); i+=2){
				combined[i] = names[i/2];
				combined[i+1] = grades[i/2];
		}
		return combined;
	}
}

class StudentTester{
	public static void main(String[] args){
		StudentGrades test = new StudentGrades();
		Scanner in = new Scanner(System.in);
		int input;
		String argument,argumen2;
		do{
			System.out.println();
			System.out.println("1: Add Student");
			System.out.println("2: Remove Student");
			System.out.println("3: Modify Grades");
			System.out.println("4: Print all existing Grades");
			System.out.println("5: Exit");
			input = in.nextInt();
			if (input == 1){
				System.out.println("Enter student name: ");
				argument = in.next();
				test.addStudent(argument);
				
			}
			if (input == 2){
				System.out.println("Enter student name: ");
				argument = in.next();
				test.removeStudent(argument);
				
			}
			if (input == 3){
				System.out.println("Enter student name, followed by their achieved grade: ");
				argument = in.next();
				argumen2 = in.next();
				test.modifyGrades(argument,argumen2);
				
			}
			if (input == 4) {
				System.out.println(test.printStats());
			}
		}
		while (input != 5);
	}
}


