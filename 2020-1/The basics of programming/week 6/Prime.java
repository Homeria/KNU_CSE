package week6;

/**
 * 소수를 구하는 두 가지 방법
 * 한 가지는 2부터 주어진 수 미만까지 모두 나머지가 0인가를 물어보고 결과를 도출
 * 또다른 한 가지는 2부터 주어진 수의 제곱근까지 나머지가 0인가를 물어보고 결과를 도출
 * @author 차경호
 *
 */
public class Prime {

	public static void main(String[] args) {
		
		long n = 20;
		boolean isPrime1, isPrime2;
		
		for(int i = 2; i <= n; i++) {
			isPrime1 = isPrime1(i);
			isPrime2 = isPrime2(i);
			System.out.println("첫 번째 방법 : " + i + "은(는) 소수이다 : " + isPrime1);
			System.out.println("두 번째 방법 : " + i + "은(는) 소수이다 : " + isPrime2);
		}
		
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
