package w9.generics;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


class ListReverser {
	
	public static void reverse(List<Number> list) {
		List<Number> temp = new LinkedList<>(list);
		list.removeAll(list);		
		ListIterator<Number> iter = temp.listIterator(temp.size());
		while(iter.hasPrevious()) {
			list.add(iter.previous());
		}
	}
}


public class ListReverserTest {

	public static void main(String[] args) {
		
		List<Number> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(-1);
		list.add(3);
		System.out.println(list);
		ListReverser.reverse(list);
		System.out.println(list);
		
		
		System.out.println();
		
		
		List<Double> doubleList = new LinkedList<>();
		doubleList.add(1.0);
		doubleList.add(2.0);
		doubleList.add(3.0);
		doubleList.add(-1.0);
		doubleList.add(3.0);
		System.out.println(doubleList);
		// ListReverser.reverse(doubleList);
		/*
		 * The method reverse(List<Number>) in the type ListReverser is
		 * not applicable for the arguments (List<Double>)
		 * 인 것으로 보아 List<Double>은 List<Number>의 서브타입이 아니라고 할 수 있다.
		 */
		
		
		System.out.println("");
		List<Integer> integerList = new LinkedList<>();
		integerList.add(1);
		integerList.add(2);
		integerList.add(3);
		integerList.add(-1);
		integerList.add(3);
		System.out.println(integerList);
		//ListReverser.reverse(integerList);
		/*
		 * The method reverse(List<Number>) in the type ListReverser is
		 * not applicable for the arguments (List<Integer>)
		 * 인 것으로 보아 List<Double>과 같이
		 * List<Integer>는 List<Number>의 서브타입이 아니라고 할 수 있다.
		 */
		
		
	}

}
