package w8.dog2;

public class Jindo extends Dog {
	
	private String color; // 검정, 하양, 갈색
	private static int averageWeight = 45;
	
	public Jindo(String name, String color) {
		super(name);
		this.color = color;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jindo other = (Jindo) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		return true;
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