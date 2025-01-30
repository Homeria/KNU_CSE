package week9;

/**
 * 크기가 10인 int 타입 배열을 세개 만들고, 두 배열에 0 이상 10 미만 정수 난수로 채운 후
 * 나머지 한 배열에는 두 배열을 합한 값을 넣고 출력하는 프로그램.
 * @author 차경호
 */
public class ArrayAdd {

	public static void main(String[] args) {
		
		final int SIZE = 10;
		int[] a = new int[SIZE];
		int[] b = new int[SIZE];
		int[] c = new int[SIZE];
		
		for(int i = 0; i < a.length; i++) {
			a[i] = (int)(Math.random() * 10);
		}
		
		
		for(int i = 0; i < a.length; i++) {
			b[i] = (int)(Math.random() * 10);
		}
		
		for(int i = 0; i < a.length; i++) {
			c[i] = a[i] + b[i];
		}
		
		printArray(a);
		printArray(b);
		printArray(c);
		
	}
	
	/**
	 * 주어진 배열을 차례로 출력함.
	 * @param array 출력할 배열을 가리키는 참조변수.
	 */
	public static void printArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}

}
