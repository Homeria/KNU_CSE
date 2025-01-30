package week9;

/**
 * 크기가 10인 int 타입 배열에 0 이상 100 미만 정수 난수를 채워 넣고
 * 각 원소를 출력하고 원소의 최댓값과 최솟값, 평균을 구해 출력하는 프로그램.
 * @author 차경호
 */
public class RandomNumbers2 {

	public static void main(String[] args) {
		
		final int SIZE = 10;
		int[] a = new int[SIZE];
		
		for(int i = 0; i < a.length; i++) {
			a[i] = (int)(Math.random() * 100);
		}
		
		System.out.println("100보다 작은 정수 난수");
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i] + " ");
		}
		
		int max = 0;
		int min = 100;
		int sum = 0;
		for(int i = 0; i < SIZE; i++) {
			if(a[i] > max) {
				max = a[i];
			}
			if(a[i] < min) {
				min = a[i];
			}
			sum += a[i];
		}
		
		System.out.println("원소들 중 최소값 : " + min);
		System.out.println("원소들 중 최댓값 : " + max);
		System.out.println("원소들의 평균값 : " + ((double)sum / (double)SIZE));
		
		
	}

}