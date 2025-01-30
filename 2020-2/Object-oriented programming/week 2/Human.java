package week2;

public class Human {

	private String name;
	private int age;
	
	
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
	public String toString() {
		return ("Human[name=" + name + ", age=" + age + "]");
	}
	
	
	public static void main(String[] args) {
		Human human1 = new Human();
		Human human2 = new Human();
		
		human1.setName("썸녀");
		human1.setAge(19);
		
		human2.setName("썸남");
		human2.setAge(20);
		
		System.out.println(human1);
		System.out.println(human2);
		
		
	}
	
	
	
	
}
