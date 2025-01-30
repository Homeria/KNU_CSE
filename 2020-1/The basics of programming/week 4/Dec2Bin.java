package week4;

import java.util.Scanner;

/**
 * 본 프로그램은 하나의 십진수 데이터를 2진수로 변환하는 프로그램입니다.
 * 입력한 10진수의 데이터보다 작거나 같은 2의 거듭제곱 수를 구한 후
 * 입력한 10진수의 수와 구한 2의 거듭제곱 수의 크기를 비교하여 2진수로 변환하는 과정을 거칩니다.
 * @author 차경호
 *
 */

public class Dec2Bin {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("자연수 하나를 십진수로 입력하시오 : ");
		int num = input.nextInt();
		input.close();
		int power = 0;
		boolean done = false;
		
		for(int i = 0; i <= num; i *= 2) {
			if (i == 0) {
				i = 1;
			}
			power = i;
		}
		
		while(done == false) {
			
			if (num >= power) {
				System.out.print("1");
				num -= power;
			} else {
				System.out.print("0");
			}
			if (power == 1) {
				done = true;
			}
			power /= 2;
		}
		
		
		
			
		
		
		
		
		
	}

}
