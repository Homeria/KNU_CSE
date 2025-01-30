package w6.overriding;

import java.util.Comparator;

public class CatComparator implements Comparator<Cat>{

	public int compare(Cat c1, Cat c2) {
		if (c1.name.compareTo(c2.name) == 0) {
			if (c1.age == c2.age) {
				return 0;
			} else {
				if(c1.age > c2.age) {
					return 1;
				} else {
					return -1;
				}
			}
		} else {
			return c1.name.compareTo(c2.name);
		}
	}

}
