package w4;

import java.util.Comparator;

public class Box implements Comparable<Box>{

	private double width, height, depth;
	
	
	public String toString() {
		return String.format("Box[width=%.1f, height=%.1f, depth=%.1f]", width, height, depth);
	}


	public Box(double width, double height, double depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
	}


	public double getWidth() {
		return width;
	}
	
	
	public double getHeight() {
		return height;
	}
	
	
	public double getDepth() {
		return depth;
	}
	
	
	public int compareTo(Box b) {
		
		double thisVolume = width * height * depth;
		double otherVolume = b.width * b.height * b.depth;
	
		if (thisVolume == otherVolume) {
			return 0;
		} else if (thisVolume > otherVolume) {
			return 1;
		} else {
			return -1;
		}
		
	}
	
}


class OuterAreaComparator implements Comparator<Box> {

	public int compare(Box b1, Box b2) {
		double a1 = 2 * ((b1.getWidth() * b1.getHeight()) + (b1.getHeight() * b1.getDepth()) + (b1.getWidth() * b1.getDepth()));
		double a2 = 2 * ((b2.getWidth() * b2.getHeight()) + (b2.getHeight() * b2.getDepth()) + (b2.getWidth() * b2.getDepth()));
		
		if (a1 == a2) {
			return 0;
		} else if (a1 > a2) {
			return 1;
		} else {
			return -1;
		}
	}
	
}
