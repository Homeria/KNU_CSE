package week11;

public class record {

	char grade;
	int penalty;
	String name;
	
	public record() {
		grade = 0;
		penalty = 0;
		name = null;
	}
	
	public record(char grade, int penalty, String name) {
		this.grade = grade;
		this.penalty = penalty;
		this.name = name;
	}
	
	public char getGrade() {
		return grade;
	}
	
	public int getPenalty() {
		return penalty;
	}
	
	public String getName() {
		return name;
	}
	
	public void setGrade(char grade) {
		this.grade = grade;
	}
	
	public void setPenalty(int penalty) {
		this.penalty = penalty;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return ("[" + grade + ", " + Integer.toString(penalty) + ", " + name + "]");
	}
	
	
	
	
	
	
	
}
