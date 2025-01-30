package w4;

public class Rectangle implements Measurable, Comparable<Rectangle> {

	private double width, height;
	
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	public void setDimension(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	
	public double getMeasure() {
		return (width * height);
	}
	
	
	public double getWidth() {
		return width;
	}
	
	
	public double getHeight() {
		return height;
	}
	
	
	public String toString() {
		return String.format("Rectangle[width=%.1f, height=%.1f]", width, height);
	}

	
	

	@Override
	public int compareTo(Rectangle o) {
		double thisArea = width * height;
		double otherArea = o.width * o.height;
		if (thisArea == otherArea) {
			return 0;
		} else if (thisArea > otherArea) {
			return 1;
		} else {
			return -1;
		}
		
	}
	
	
}
