package w9.generics;

import java.util.ArrayList;
import java.util.List;

public class UpperBoundDemo {

	public static void main(String[] args) {
		
		List<Number> ln = new ArrayList<>();
		ln.add(1);
		ln.add(5.3);
		ln.add(1.1f);
		System.out.println(ln);
		
		List<Number> ln2 = new ArrayList<>();
		ln2.add(10);
		ln2.add(100.3);
		ln.addAll(ln2);
		System.out.println(ln);
		
		List<Integer> integerList = new ArrayList<>();
		integerList.add(1);
		integerList.add(2);
		integerList.add(3);
		ln.addAll(integerList);
		System.out.println(ln);
		
		List<Double> doubleList = new ArrayList<>();
		doubleList.add(1.0);
		doubleList.add(2.0);
		doubleList.add(3.0);
		ln.addAll(doubleList);
		System.out.println(ln);
		
	}

}
