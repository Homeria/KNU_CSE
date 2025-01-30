package w4;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class AsListTest {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, -3, 5, -7, 9, -11);
		
		System.out.println("리스트");
		System.out.println(list);
		System.out.println("");
		
		System.out.println("Natural ordering에 따라 정렬된 리스트");
		Collections.sort(list);
		System.out.println(list);
		
		
		System.out.println("");
		System.out.println("절대값을 기준으로 정렬된 리스트");
		AbsoluteValueComparator comparator = new AbsoluteValueComparator();
		Collections.sort(list, comparator);
		System.out.println(list);
		
	}

}


class AbsoluteValueComparator implements Comparator<Integer> {

	public int compare(Integer i1, Integer i2) {
		
		if (i1 < 0) {
			i1 = i1 * -1;
		}
		if (i2 < 0) {
			i2 = i2 * -1;
		}
		
		if(i1 == i2) {
			return 0;
		} else if (i1 > i2) {
			return 1;
		} else {
			return -1;
		}
		
	}
	
	
	
}