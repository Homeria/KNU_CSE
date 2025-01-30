package week10;

/**
 * 크기가 10인 int 타입 배열에 0 이상 100 미만 정수 난수를 채우고, 배열의 각 원소를 차례로 출력하고,
 * 배열에서 최솟값, 최댓값, 평균을 구하여 출력하는 프로그램
 * @author 차경호
 *
 */
public class RandomStatistics {

	public static void main(String[] args) {
		final int SIZE = 10;
		final int MAX = 100;
		int[] array = new int[SIZE];
		wirteRandomNumbers(array, MAX);
		
		int min = min(array);
		int max = max(array);
		double average = average(array);
		System.out.println("원소들 중 최소값 : " + min);
		System.out.println("원소들 중 최댓값 : " + max);
		System.out.println("원소들의 평균값 : " + average);
		
	}
	
	/**
	 * 0 이상 n 미만의 정수 난수를 발생시켜 배열 a를 차례로 채운다.
	 * @param a 난수를 저장할 배열
	 * @param n 0 이상 n 미만 난수 발생
	 */
	public static void wirteRandomNumbers(int[] a, int n) {
		
		System.out.println(n + "보다 작은 정수 난수");
		for(int i = 0; i < a.length; i++) {
			a[i] = (int)(Math.random() * n);
			System.out.println(a[i]);
		}
		System.out.println("");
		
		
	}
	
	
	/**
	 * 배열 a의 원소 중 최소값을 찾아 반환한다.
	 * @param a 배열을 가리키는 참조변수
	 * @return 최소값
	 */
	public static int min(int[] a) {
		int min = 100;
		for(int i = 0; i < a.length; i++) {
			if (a[i] <= min) {
				min = a[i];
			}
		}
		return min;
	}
	
	
	/**
	 * 배열 a의 원소 중 최댓값을 찾아 반환한다.
	 * @param a 배열을 가리키는 참조변수
	 * @return 최댓값
	 */
	public static int max(int[] a) {
		int max = 0;
		for(int i = 0; i < a.length; i++) {
			if (a[i] >= max) {
				max = a[i];
			}
		}
		return max;
	}
	
	
	/**
	 * 배열 a의 원소들의 평균값을 반환한다.
	 * @param a 배열을 가리키는 참조변수
	 * @return 평균값
	 */
	public static double average(int[] a) {
		int sum = 0;
		double average;
		for(int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		average = (double)sum / (double)a.length;
		return average;
	}
	
}
