package w7.exception;

import java.util.Arrays;

public class Exception1 {

	static int[] a;
	
	public static void main(String[] args) {
		makeArrayAndTest();
		System.out.println(Arrays.toString(a));
	}

	static void makeArrayAndTest() {
		a = new int[10];
		test();
	}
	
	static void test() {
		set(10, 3);
	}
	
	static void set(int index, int value) {
		if (index < 0 || index >= a.length)
			throw new IndexOutOfBoundsException();
		a[index] = value;
	}
}

