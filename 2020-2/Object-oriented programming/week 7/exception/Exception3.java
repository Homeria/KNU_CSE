package w7.exception;

import java.util.Arrays;

public class Exception3 {

	static int[] a;

	public static void main(String[] args) {
		makeArrayAndTest();
		System.out.println(Arrays.toString(a));
	}

	static void makeArrayAndTest() {
		a = new int[10];
		try {
			test();
		}
		catch(IndexOutOfBoundsException e) {
			System.out.println("나이스 캐치~");
			System.out.println("인덱스가 틀려서 작업을 완료할 수 없습니다.");
			System.out.println(e.getMessage());
		}
	}

	static void test() {
		set(10, 3);
	}

	static void set(int index, int value) {
		if (index < 0 || index >= a.length)
			throw new IndexOutOfBoundsException("인덱스=" + index);
		a[index] = value;
	}
}

