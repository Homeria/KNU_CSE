package w7;

import java.util.*;

/**
 * 리스트의 Iterator를 사용하면 
 * 리스트 원소 수가 변하더라도 Iterator가 알아서 대처해 준다.

 * Iterator에게 next()를 호출하여 원소를 하나 얻은 후
 * Iterator에게 remove()를 호출하면 그 원소를 리스트에서 제거한다.
 */

public class Mystery1Out {
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= 10; i++) {
			list.add(10 * i);   // [10, 20, 30, 40, ..., 100]
		}

		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			it.next();		// 원소를 하나 얻는다.
			it.remove();	// 그 원소를 리스트에서 제거한다.
		}
		System.out.println(list);
	}
}

