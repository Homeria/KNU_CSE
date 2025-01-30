package week2;

public class Human2 {

	private String name;
	private int age;
	
	public Human2(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	/**
	 * name을 설정함.
	 * @param 설정할 이름
	 */
	public void setName(String n) {
		name = n;
	}
	
	
	/**
	 * name 값을 가져옴.
	 * @return 설정한 이름
	 */
	public String getName() {
		return name;
	}
	
	
	/**
	 * Age를 설정함.
	 * @param i 설정할 나이
	 */
	public void setAge(int i) {
		age = i;
	}
	
	
	/**
	 * Age 값을 가져옴.
	 * @return 설정한 나이
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * Getter 메소드
	 */
	@Override
	public String toString() {
		return "Human2 [name=" + name + ", age=" + age + "]";
	}
	
	public static void main(String[] args) {
		Human2 human1 = new Human2("썸녀", 19);
		Human2 human2 = new Human2("썸남", 20);
		
		System.out.println(human1);
		System.out.println(human2);
		
		
	}
	
	
	
	
}
