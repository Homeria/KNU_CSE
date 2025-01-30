package week6;

import java.util.Scanner;

/**
 * 주어진 정수가 몇자리 수인지 알아내는 프로그램
 * int 타입 수이어야 하고 0이 아니어야 함.
 * @author 차경호
 *
 */

public class NumberOfDigitsTest {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("정수의 자리 수를 알려줍니다.");
		System.out.println("정수를 입력하시오.");
		System.out.println("int 타입 수이어야 하고 0이 아니어야 합니다.");
		int num = input.nextInt();
		input.close();
		int numberOfDigits = numberOfDigits(num);
		System.out.println(numberOfDigits + "자리 수입니다.");
	}
	
	/**
	 * 10의 거듭제곱 수를 만들어준다.
	 * 10의 0거듭제곱은 1이다.
	 * @param n 몇 거듭제곱을 할 것인지 지정한다. n은 0이상 정수이어야 한다.
	 * @return 10의 n거듭제곱수
	 */
	public static int powersOfTen(int n) {
		int num = 1;
		for(int i = 1; i <= n; i++) {
			num *= 10;
		}
		return num;
	}
	
	
	/**
	 * 주어진 정수가 몇자리 수인지 알아낸다.
	 * @param n 주어진 정수, 0이 아니어야 한다.
	 * @return n이 몇 자리 수인지.
	 */
	public static int numberOfDigits(int n) {
		
		int i;
		for (i = 9; (n / powersOfTen(i)) == 0; i--);
		return i + 1;
	}

}
