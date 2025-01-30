package week6;

import java.util.Scanner;

/**
 * 본 프로그램은 하나의 십진수 데이터를 2진수로 변환하는 프로그램입니다.
 * 입력한 10진수의 데이터보다 작거나 같은 2의 거듭제곱 수를 구한 후
 * 입력한 10진수의 수와 구한 2의 거듭제곱 수의 크기를 비교하여 2진수로 변환하는 과정을 거칩니다.
 * @author 차경호
 *
 */

public class Dec2Bin2 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("자연수 하나를 십진수로 입력하시오 : ");
		int num = input.nextInt();
		input.close();
		
		System.out.println(toBinary(num));
		
		
	}
	
	
	/**
	 * 주어진 수보다 작거나 같은 2의 거듭제곱수들 중 가장 큰 수를 구한다.
	 * 주어진 수는 1 이상 정수이어야 한다.
	 * 주어진 수가 10이라면 2^3 = 8
	 * 주어진 수가 6이라면 2^2 = 4
	 * @param n 주어진 수.
	 * @return n보다 작거나 같은 2의 거듭제곱수들 중 가장 큰 수.
	 */
	public static int maxPower(int n) {
		int power = 0;
		for(int i = 0; i <= n; i *= 2) {
			if (i == 0) {
				i = 1;
			}
			power = i;
		}
		return power;
	}
	
	
	/**
	 * 십진수를 이진수로 변환하여 이진수 문자열(String)을 만든다.
	 * 십진수는 1 이상 정수이어야 한다.
	 * 십진수 10이 주어지면 문자열 '1010'이 반환된다
	 * @param n 주어진 십진수.
	 * @return 이진수 문자열.
	 */
	public static String toBinary(int n) {
		
		int maxPower;
		String s = "";
		boolean done = false;
		maxPower = maxPower(n);
		while(done == false) {
			if (n >= maxPower) {
				s = s + "1";
				n -= maxPower;
			} else {
				s = s + "0";
			}
			
			if(maxPower == 1) {
				done = true;
			}
			maxPower /= 2;
		}
		return s;
	}
		

}
