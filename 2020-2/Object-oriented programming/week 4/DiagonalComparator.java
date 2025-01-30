package w4;

import java.util.Comparator;

public class DiagonalComparator implements Comparator<Rectangle> {
	
	public int compare(Rectangle r1, Rectangle r2) {
		double a1 = Math.sqrt((r1.getWidth() * r1.getWidth()) + (r1.getHeight() * r1.getHeight()));
		double a2 = Math.sqrt((r2.getWidth() * r2.getWidth()) + (r2.getHeight() * r2.getHeight()));
		
		if (a1 == a2) {
			return 0;
		} else if (a1 > a2) {
			return 1;
		} else {
			return -1;
		}
	}
	
}
