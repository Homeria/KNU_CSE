package w8.dog;

public class Jindo extends Dog {
	
	private String color; // 검정, 하양, 갈색
	private static int averageWeight = 45;
	
	public Jindo(String name, String color) {
		super(name);
		this.color = color;
	}

	public String speak() {
		return "컹컹~";
	}

	public int getAverageWeight() {
		return averageWeight;
	}
	
	public String toString() {
		return ("Dog [color=" + color + ", name=" + name + "]");
	}

}