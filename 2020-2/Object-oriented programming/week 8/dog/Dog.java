package w8.dog;

abstract public class Dog {

	protected String name;

	// 이 클래스는 이미 구성자를 갖고 있으므로
	// (파라미터 없는) 기본구성자가 컴파일러에 의해 자동으로 삽입되지 않는다.
	
	public Dog(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String speak() {
		return "멍멍~";
	}
	
	abstract public int getAverageWeight();
	
	public String toString() {
		return ("Dog [name=" + name + "]");
	}

}