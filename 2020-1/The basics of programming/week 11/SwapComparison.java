package week11;


/**
 * 배열의 순서를 바꿔주는 메소드가 오버로딩 되어 있고,
 * 오버로딩된 메소드를 각각 사용했을 때의 차이를 보여주는 프로그램.
 */
public class SwapComparison {
	
	/**
	 * x, y 값을 서로 바꿔준다.
	 * @param x 메인 함수의 원소를 받은 변수
	 * @param y 메인 함수의 원소를 받은 변수
	 */
	public static void swap(int x, int y) {
		int temp;
		temp = x;
		x = y;
		y = temp;
	}

	/**
	 * 배열의 두 원소 값을 서로 바꾼다.
	 * a[i] <-- > a[j]
	 * @param a 배열.
	 * @param i 값을 바꿀 방 번호.
	 * @param j 값을 바꿀 방 번호.
	 */
	public static void swap(int[] a, int i, int j) {
		int temp;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		
		int[] anArray = {10, 20};
		
		// swap(int x, int y) 메소드를 사용함.
		// 여기에서는 주어진 배열의 원소를 파라미터로 복사하여 주었기 때문에 메인 함수의 배열의 순서는 변화 없음
		swap(anArray[0], anArray[1]);
		System.out.println("anArray[0]="+anArray[0]+",anArray[1]="+anArray[1]);
		
		// swamp(int[] a, int i, int j) 메소드를 사용함.
		// 여기에서는 주어진 배열의 원소의 위치를 가리키는 배열의 주소를 주었기 때문에 배열의 순서가 바뀌게 됨.
		swap(anArray, 0, 1);
		System.out.println("anArray[0]="+anArray[0]+",anArray[1]="+anArray[1]);
		
	}
}



