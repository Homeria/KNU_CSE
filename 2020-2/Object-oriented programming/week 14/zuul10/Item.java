package w14.zuul10;

public class Item {

	private String name;
	private String description;
	private int weight;
	
	public Item(String name, String description, int weight) {
		this.name = name;
		this.description = description;
		this.weight = weight;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public String getLongDescription() {
		StringBuilder sb = new StringBuilder();
		sb.append(name + " (무게 " + weight + ", " + description + ")");
		return sb.toString();
		
	}
	
}
