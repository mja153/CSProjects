class Student {
	private String name;
	private double totalScore;
	private int quizCount;
	private double avg;
	
	public Student (String name, double totalScore, int quizCount) {
	this.name = name;
	this.totalScore = totalScore;
	this.quizCount = quizCount;
	this.avg = avg;
	}
	
	public String getName() { 					// call student name
	return name;
	}
	
	public double addQuiz(int score) { 			//adding an addition score to the student's total.
	totalScore = (totalScore+score);
	return totalScore;
	}
	
	public double getTotalScore() {
	return totalScore;
	}
	
	public double getAverageScore(){
	avg = (totalScore/quizCount);
	return avg;
	}
	
	public static void main(String[] args){
	}
}

	public class StudentTester {
	public static void main(String[] args){
	Student Test = new Student("Michael Anderson", 980, 10);
	Test.addQuiz(20);
	System.out.println("Expected: Michael Anderson 100.0");
	System.out.println("Actual: " + Test.getName() + " " + Test.getAverageScore());
	}
}