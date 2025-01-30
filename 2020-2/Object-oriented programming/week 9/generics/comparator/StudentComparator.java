package w9.generics.comparator;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		
		if(o1.name.compareTo(o2.name) > 0) {
			return 1;
		} else if (o1.name.compareTo(o2.name) == 0)  {
			if (o1.age > o2.age) {
				return 1;
			} else if (o1.age == o2.age) {
				if (o1.num > o2.num) {
					return 1;
				} else if (o1.num == o2.num) {
					return 0;
				} else {
					return -1;
				}
			} else {
				return -1;
			}
		} else {
			return -1;
		}
	}
}
