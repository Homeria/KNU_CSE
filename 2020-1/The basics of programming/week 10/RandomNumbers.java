package week10;

/**
 * 0 이상 10 미만 정수 난수 20개를 배열에 저장하고, 배열을 출력하는 프로그램
 * @author 차경호
 */
public class RandomNumbers {

	public static void main(String[] args) {
		
		final int SIZE = 20;
		final int MAX = 10;
		int[] array = new int[SIZE];
		array = makeRandomArray(SIZE, MAX);
		
		System.out.println("0이상 " + MAX + "미만 정수 난수");
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		
	}
	
	
	/**
	 * max 미만의 정수 난수를 n 크기만큼의 배열에 채우고, 배열을 반환함.
	 * @param n 배열의 크기
	 * @param max 정수 난수의 최대 범위
	 * @return 0 이상 max 미만의 정수 난수가 n개 담긴 배열
	 */
	public static int[] makeRandomArray(int n, int max) {
		int[] array = new int[n];
		for(int i = 0; i < array.length; i++) {
			array[i] = (int)(Math.random() * max);
		}
		return array;
	}
	

}
