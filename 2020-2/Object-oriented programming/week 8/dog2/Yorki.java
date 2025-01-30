package w8.dog2;

public class Yorki extends Dog {

	private static int averageWeight = 4;
	
	public Yorki(String name) {
		super(name);
	}

	public String speak() {
		return "깽깽~";
	}

	@Override
	public int getAverageWeight() {
		return averageWeight;
	}

}