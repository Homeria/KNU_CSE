package w4;

import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RectangleTester {
	
	public static void main(String[] args) {
		new RectangleTester().test();
		
	}
	
	
	private void test() {
		
		Random random = new Random();
		
		Rectangle[] array = new Rectangle[3];
		ArrayList<Rectangle> arrayList = new ArrayList<Rectangle>();
		Rectangle a;
		for(int i = 0; i < array.length; i++) {
			a = new Rectangle(random.nextDouble() * 100, random.nextDouble() * 100);
			array[i] = a;
			arrayList.add(a);
		}
		
		System.out.println("배열출력, for-each loop 이용");
		for(Rectangle rectangle : array) {
			System.out.println(rectangle);
		}
		
		System.out.println("");
		
		System.out.println("Array list 출력, for-each loop 이용");
		for(Rectangle rectangle : arrayList) {
			System.out.println(rectangle);
		}
		
		
		System.out.println("");
		
		
		System.out.println("ArrayList의 첫 사각형 크기를 (1.0, 2.0)으로 변경");
		arrayList.get(0).setDimension(1.0, 2.0);
		
		System.out.println("");
		
		System.out.println("배열출력, for-each loop 이용");
		for(Rectangle rectangle : array) {
			System.out.println(rectangle);
		}
		
		System.out.println("");
		
		System.out.println("Array list 출력, for-each loop 이용");
		for(Rectangle rectangle : arrayList) {
			System.out.println(rectangle);
		}
		
		
		System.out.println("");
		
		
		System.out.println("ArrayList의 첫 사각형 크기가 (5.0, 5.0)인 새 사각형으로 교체한다.");
		arrayList.set(0, new Rectangle(5.0, 5.0));
		
		System.out.println("");
		
		System.out.println("배열출력, for-each loop 이용");
		for(Rectangle rectangle : array) {
			System.out.println(rectangle);
		}
		
		System.out.println("");
		
		System.out.println("Array list 출력, for-each loop 이용");
		for(Rectangle rectangle : arrayList) {
			System.out.println(rectangle);
		}
		
		
		System.out.println("");
		System.out.println("정렬 ------------");
		
		Arrays.sort(array);
		Collections.sort(arrayList);
		
		System.out.println(Arrays.toString(array));
		System.out.println(arrayList);
		System.out.println();
		
		
		System.out.println("");
		
		
		System.out.println("ArrayList의 첫 사각형을 크기가 (0.1, 200.0)인 새 사각형으로 교체한다.");
		arrayList.set(0, new Rectangle(0.1, 200.0));
		System.out.println(arrayList);
		
		
		System.out.println("");
		System.out.println("면적을 기준으로 (natural ordering) 정렬 ------");
		Collections.sort(arrayList);
		System.out.println(arrayList);

	
		System.out.println("");
		System.out.println("대각선 길이를 기준으로 정렬 ------");
		DiagonalComparator diagonalComparator = new DiagonalComparator();
		Collections.sort(arrayList, diagonalComparator);
		System.out.println(arrayList);
		
		
		
		
		
	}
}


