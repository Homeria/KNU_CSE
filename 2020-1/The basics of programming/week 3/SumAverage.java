package week3;

import java.util.Scanner;

public class SumAverage {

	public static void main(String[] args) {
		
		int sum = 0;
		int value;
		double average = 0;
		
		Scanner input = new Scanner(System.in);
		System.out.print("정수를 몇 개 더하시겠습니까? ");
		int number = input.nextInt();
		
		System.out.print("3개의 정수를 차례로 입력하시오 : ");
		for(int i = 1; i <= number; i++) {
			value = input.nextInt();
			sum += value;
		}
		
		input.close();
		
		average = (double)sum / number;
		System.out.println("정수의 합 = " + sum);
		System.out.printf("평균 = %.2f", average);
	}

}
