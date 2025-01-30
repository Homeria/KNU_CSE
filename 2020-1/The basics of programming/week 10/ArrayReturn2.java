package week10;

/**
 * 다중정의(오버로딩)의 예시를 보여주는 프로그램
 * makeArray 메소드는 오버로딩 되어 있음
 * @author 차경호
 *
 */
public class ArrayReturn2 {

	public static void main(String[] args) {
		
		int[] array;
		
		//만든 배열을 가리키는 참조 반환
		array = makeArray();
		
		//배열 출력
		ArrayUtil.printArray(array, 10);
		
		
		//주어진 수만큼 만든 배열을 만들고 출력
		for(int i = 0; i <= 10; i++) {
			array = makeArray(i);
			ArrayUtil.printArray(array, i);
		}
		
	}
	
	
	/**
	 * 크기가 10인 int 배열을 구성한 후
	 * 0번 방에는 0 * 0을
	 * 1번 방에는 1 * 1을
	 * ...
	 * 9번 방에는 9 * 9을 저장하고
	 * 배열을 반환한다.
	 * 배열을 반환한다는 것은 배열을 가리키는 참조를 반환한다는 것이다.
	 * @return 배열을 가리키는 참조
	 */
	public static int[] makeArray() {
		final int SIZE = 10;
		int[] array = new int[SIZE];
		for(int i = 0; i < SIZE; i++) {
			array[i] = i * i;
		}
		return array;
	}
	
	
	/**
	 * 크기가 10인 int 배열을 구성한 후
	 * 0번 방에는 0 * 0을
	 * 1번 방에는 1 * 1을
	 * ...
	 * n-1번방에는 (n-1)*(n-1)을 저장하고
	 * 배열을 반환한다.
	 * 배열을 반환한다는 것은 배열을 가리키는 참조를 반환한다는 것이다.
	 * @param n 만들 배열의 크기
	 * @return 배열을 가리키는 참조
	 */
	public static int[] makeArray(int n) {
		final int SIZE = n;
		int[] array = new int[SIZE];
		for(int i = 0; i < SIZE; i++) {
			array[i] = i * i;
		}
		return array;
	}

}
