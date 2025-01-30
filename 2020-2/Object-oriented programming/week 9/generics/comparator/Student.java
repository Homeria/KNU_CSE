package w9.generics.comparator;

public class Student extends Human {

	protected int num;
	
	public Student(String name, int age, int num) {
		super(name, age);
		this.num = num;
	}
	

	public String toString() {
		return (name + ":" + age + ":" + num);
	}

	public static void main(String[] args) {
		System.out.println(new Student("홍길동", 18, 20180003));
	}

}
