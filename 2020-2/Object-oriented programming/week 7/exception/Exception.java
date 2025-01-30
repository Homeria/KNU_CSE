package w7.exception;

import java.util.Arrays;

public class Exception {

	static int[] a;
	
	public static void main(String[] args) {
		int error_code = makeArrayAndTest();
		if (error_code == 0)
			System.out.println(Arrays.toString(a));
		else
			System.out.println("에러! error code = " + error_code);
	}

	static int makeArrayAndTest() {
		a = new int[10];
		return(test());
	}

	static int test() {
		return set(10, 3);	// 1번 방에 3을 저장.
	}

	static int set(int index, int value) {
		if (index < 0 || index >= a.length) {
			return -1;	// 인덱스가 범위를 벗어암.
		}
		else {
			a[index] = value;
			return 0;
		}
	}
}

