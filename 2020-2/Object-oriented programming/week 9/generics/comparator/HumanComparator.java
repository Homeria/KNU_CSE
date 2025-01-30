package w9.generics.comparator;

import java.util.Comparator;

public class HumanComparator implements Comparator<Human> {

	
	
	@Override
	public int compare(Human o1, Human o2) {
		
		if(o1.name.compareTo(o2.name) > 0) {
			return 1;
		} else if (o1.name.compareTo(o2.name) == 0)  {
			if (o1.age > o2.age) {
				return 1;
			} else if (o1.age == o2.age) {
				return 0;
			} else {
				return -1;
			}
		} else {
			return -1;
		}
	}
	
}
