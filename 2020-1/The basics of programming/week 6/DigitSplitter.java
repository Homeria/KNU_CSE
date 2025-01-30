package week6;

import java.util.Scanner;

/**
 * 주어진 정수가 몇자리 수인지 알아내고 주어진 정수의 각 자리 숫자를 차례로 출력하는 프로그램
 * @author 차경호
 *
 */

public class DigitSplitter {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("정수를 입력하시오, int 타입 수이어야 하고 0이 아니어야 합니다 : ");
		int num = input.nextInt();
		input.close();
		
		if (num < 0) {
			num = num * (-1);
		}
		
		int numberOfDigits = NumberOfDigitsTest.numberOfDigits(num);
		System.out.println(numberOfDigits + "자리 수입니다.");
		
		int powersOfTen;
		int digits;
		for (int i = numberOfDigits; i >= 1; i--) {
			powersOfTen = 1;
			for (int j = 1; j < i; j++) {
				powersOfTen *= 10;
			}
			digits = num / powersOfTen;
			System.out.print(digits + " ");
			num -= digits * powersOfTen;
		}
		
		
	}

}
