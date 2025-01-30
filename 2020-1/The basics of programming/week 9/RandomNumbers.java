package week9;

/**
 * 크기가 20인 int 타입 배열을 0이상 10미만 정수 난수로 모두 채운 후 각 원소를 차례로 출력하는 프로그램.
 * @author 차경호
 *
 */
public class RandomNumbers {

	public static void main(String[] args) {
		
		final int SIZE = 20;
		int[] a = new int[SIZE];
		
		for(int i = 0; i < a.length; i++) {
			a[i] = (int)(Math.random() * 10);
		}
		
		System.out.println("10보다 작은 정수 난수");
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i] + " ");
		}

	}

}