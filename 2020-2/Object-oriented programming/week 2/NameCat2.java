package week2;

public class NameCat2 {

	private String name;
	private int age;
	
	
	public NameCat2() {
		
	}
	
	
	public NameCat2(String name) {
		super();
		this.name = name;
	}
	
	
	public NameCat2(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
	void eat() { 
		System.out.println("냠냠!");
	}
	
	
	public void yaong() {
		System.out.println("야옹");
	}
	
	
	public void setName(String n) { 
		this.name = n; 
	}
	
	
	public String getName() { 
		return name; 
	}
	
	
	public void setAge(int age) {
		this.age = age;
	}
	
	
	public int getAge() {
		return age;
	}


	@Override
	public String toString() {
		return "NameCat2 [name=" + name + ", age=" + age + "]";
	}
	
	
	public static void main(String[] args) {
		
		NameCat2 c1, c2, c3;
		
		c1 = new NameCat2();
		c2 = new NameCat2("갑순이");
		c3 = new NameCat2("갑돌이", 19);
		
		c1.setName("왕눈이");
		c1.setAge(20);
		
		c2.setAge(21);
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		
		
		
	}
	
	
	 
	
	
	 
	
	
	
	
	
	
	
	
}
