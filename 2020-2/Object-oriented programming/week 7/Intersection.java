package w7;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Intersection {

	/**
	 * 두 리스트의 교집합을 구한다.
	 * @param list1 첫 리스트
	 * @param list2 두 번째 리스트
	 * @return 교집합이 들어 있는 새 List.
	 */
	public static List<Integer> intersection(List<Integer> list1, List<Integer> list2) {
		ListIterator<Integer> iter1 = list1.listIterator();
		ListIterator<Integer> iter2;;
		List<Integer> intersection = new ArrayList<>();
		Integer l1, l2;
		
		while(iter1.hasNext()) {
			l1 = iter1.next();
			iter2 = list2.listIterator();
			while(iter2.hasNext()) {
				l2 = iter2.next();
				if (l1.equals(l2)) {
					intersection.add(l1);
				}
			}
		}
		return intersection;
	}
	
	
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		
		for (int i = 0; i < 10; i++) {
			list1.add(2 * i);
		}
		
		for (int i = 0; i < 15; i++) {
			list2.add(3 * i);
		}
		
		System.out.println(list1);
		System.out.println(list2);
		
		List<Integer> intersection = intersection(list1, list2);
		System.out.println(intersection);
		

	}
	
	
	
	
}
