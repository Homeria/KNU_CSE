package w4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BoxTester {

	public static void main(String[] args) {
		
		new BoxTester().test();
		
	}
	
	private void test() {
		
		Random random = new Random();
		
		List<Box> boxList = new ArrayList<>();
		
		Box b;
		
		for(int i = 0; i < 5; i++) {
			b = new Box((random.nextDouble() * 10), (random.nextDouble() * 10), (random.nextDouble() * 10));
			boxList.add(b);
		}
		
		System.out.println("Natural ordering 정렬");
		Collections.sort(boxList);
		System.out.println(boxList);
		
		System.out.println("");
		System.out.println("겉넓이 기준 정렬");
		OuterAreaComparator comparator = new OuterAreaComparator();
		Collections.sort(boxList, comparator);
		System.out.println(boxList);

	}

}
