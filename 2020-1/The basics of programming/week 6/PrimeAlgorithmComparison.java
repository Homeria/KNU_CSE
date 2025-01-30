package week6;

/**
 * 소수를 구하는 두 가지 방법을 각각 실행했을 때의 걸리는 시간을 보여주는 프로그램
 * @author 차경호
 *
 */
public class PrimeAlgorithmComparison {

	public static void main(String[] args) {
		
		long n = 3033333343L;
		boolean isPrime1, isPrime2;
		
		long startTime, endTime;
		
		startTime = System.currentTimeMillis();
		isPrime1 = isPrime1(n);
		endTime = System.currentTimeMillis();
		System.out.println("첫 번째 방법, 계산 시간 : " + (endTime - startTime) + "ms");
		System.out.println(n + "은 소수이다 : " + isPrime1);
		
		startTime = System.currentTimeMillis();
		isPrime2 = isPrime2(n);
		endTime = System.currentTimeMillis();
		System.out.println("두 번째 방법, 계산 시간 : " + (endTime - startTime) + "ms");
		System.out.println(n + "은 소수이다 : " + isPrime2);
		
	}
	
	/**
	 * 주어진 2 이상인 자연수가 소수인가?
	 * 첫 번째 방법.
	 * @param n 주어진 자연수(2 이상인 정수이어야 한다.)
	 * @return 소수이면 true, 그렇지 않으면 false.
	 */
	public static boolean isPrime1(long n) {
		boolean isPrime = true;
		for (long i = 2; i < n; i++) {
			if (n % i == 0) {
				isPrime  = false;
				break;
			}
		}
		return isPrime;
	}
	
	
	/**
	 * 주어진 2 이상인 자연수가 소수인가?
	 * 두 번째 방법.
	 * @param n 주어진 자연수(2 이상인 정수이어야 한다.)
	 * @return 소수이면 true, 그렇지 않으면 false.
	 */
	public static boolean isPrime2(long n) {
		boolean isPrime = true;;
		for (long i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				isPrime  = false;
				break;
			}
		}
		return isPrime;
	}

}
