package w9.generics.comparator;

public class Human {
	
	protected String name;
	protected int age;
	
	public Human(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	
	public String toString() {
		return (name + ":" + age);
	}


	public static void main(String[] args) {
		System.out.println(new Human("홍길동", 18));
		
		
		
		
		
		
		
		
		
	}

}
