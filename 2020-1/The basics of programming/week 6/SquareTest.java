package week6;

/**
 * 정수의 제곱을 계산하는 프로그램
 * @author 차경호
 *
 */

public class SquareTest {

	public static void main(String[] args) {
		
		System.out.println("1부터 3까지의 정수의 제곱을 계산하는 프로그램입니다.");
		
		for (int i = 1; i <= 3; i++) {
			System.out.println(i + " * " + i + " = " + square(i));
		}
		System.out.println("끝.");
		
	}
	
	/**
	 * 주어진 수의 제곱을 구한다.
	 * @param n 주어진 수.
	 * @return n의 제곱.
	 */
	public static int square(int n) {
		int n2= n * n;
		return n2;
	}

}
