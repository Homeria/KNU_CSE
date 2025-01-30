package week4;

import java.util.Scanner;

/**
 * 본 프로그램은 입력한 양수들의 평균을 구하는 프로그램입니다.
 * 입력은 무한개 입력할 수 있으며, 입력을 마치려면 0 이하의 수를 입력하셔야 합니다.
 * 입력이 종료되면 입력하신 값들을 합하고, 값들의 개수를 통해 평균을 구합니다.
 * @author 차경호
 */

public class Average {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("양수들의 평균을 구하는 프로그램입니다.");
		System.out.println("입력을 마치려면 0 이하의 수를 입력하시오");
		System.out.println("");
		
		int count = 0;
		double num = 1;
		double sum = 0;
		boolean condition = true;
		
		while(condition == true) {
			System.out.print("숫자를 입력하시오 : ");
			num = input.nextDouble();
			if (num <= 0) {
				condition = false;
			} else {
				sum += num;
				count += 1;
			}	
		}
		input.close();
		
		if (sum > 0) {
			double average = sum / count;
			System.out.printf("평균 = %.2f", average);
		} else {
			System.out.println("양수가 하나도 입력되지 않았습니다.");
		}
		
		
		
		
	}

}
