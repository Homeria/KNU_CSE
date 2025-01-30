package w9.generics;

import java.util.Arrays;

class ArrayReverser {
	public static void reverse(Number[] array) {
		Number[] temp = new Number[array.length];
		for(int i = 0; i < array.length; i++) {
			temp[i] = array[i]; 
		}
		for(int i = array.length - 1, j = 0; i >= 0; i--, j++) {
			array[j] = temp[i];
		}	
	}
}

public class ArrayReverserTest {

	public static void main(String[] args) {
		
		Number[] a = new Number[5];
		a[0] = 1;
		a[1] = 2;
		a[2] = 3;
		a[3] = -1;
		a[4] = 3;
		System.out.println(Arrays.toString(a));
		ArrayReverser.reverse(a);
		System.out.println(Arrays.toString(a));
		System.out.println();
		
		
		Integer[] integerArray = new Integer[5];
		integerArray[0] = 1;
		integerArray[1] = 2;
		integerArray[2] = 3;
		integerArray[3] = -1;
		integerArray[4] = 3;
		System.out.println(Arrays.toString(integerArray));
		ArrayReverser.reverse(integerArray);
		System.out.println(Arrays.toString(integerArray));
		System.out.println();
		
		
		Double[] doubleArray = new Double[5];
		doubleArray[0] = 1.0;
		doubleArray[1] = 2.0;
		doubleArray[2] = 3.0;
		doubleArray[3] = -1.0;
		doubleArray[4] = 3.0;
		System.out.println(Arrays.toString(doubleArray));
		ArrayReverser.reverse(doubleArray);
		System.out.println(Arrays.toString(doubleArray));
		System.out.println();
		
		
		// Integer 배열과 Double 배열이 Number 배열을 파라미터로 가지는 메소드에서
		// 정상작동 하는 것으로 보아
		// Integer 배열과 Double 배열은 Number 배열의 서브타입이라고 할 수 있다.

	}

}
