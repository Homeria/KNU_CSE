package w9.generics;

import java.util.LinkedList;
import java.util.List;

public class ListDemo {

	public static void main(String[] args) {
		
		List<Number> numberList = new LinkedList<Number>();
		numberList.add(Integer.valueOf(5));
		numberList.add(Float.valueOf((float) 3.14));
		System.out.println(numberList);
		
		// 정상적으로 잘 넣을 수 있음.
		
	}
	
}
