package week10;

/**
 * 배열의 return과 관련된 프로그램
 * 크기가 10인 int 배열을 구성하고, ArrayUtil에 있는 printArray 메소드를 사용하여 배열을 출력함
 * @author 차경호
 */
public class ArrayReturn {

	public static void main(String[] args) {
		
		int[] array;
		
		//만든 배열을 가리키는 참조 반환
		array = makeArray();
		
		//배열 출력
		ArrayUtil.printArray(array, 10);
		
	}
	
	
	/**
	 * 크기가 10인 int 배열을 구성한 후
	 * 0번 방에는 0 * 0을
	 * 1번 방에는 1 * 1을
	 * ...
	 * 9번 방에는 9 * 9를 저장하고
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

}
