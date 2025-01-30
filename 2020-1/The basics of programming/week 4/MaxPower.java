package week4;

import java.util.Scanner;

/**
 * 본 프로그램은 입력한 수보다 작거나 같은 2의 거듭제곱수 중 가장 큰 수를 구하는 프로그램입니다.
 * 입력하는 수는 자연수여야 합니다.
 * @author 차경호
 *
 */

public class MaxPower {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("자연수 하나를 입력하시오 : ");
		int num = input.nextInt();
		input.close();
		int power = 0;
		
		for(int i = 0; i <= num; i *= 2) {
			if (i == 0) {
				i = 1;
			}
			power = i;
		}
		
		System.out.println(num + "보다 작거나 같은 2의 거듭제곱수들 중 가장 큰 수 = " + power);
		
	}

}
