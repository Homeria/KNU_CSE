package week3;

import java.util.Scanner;

public class SumAverage2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("평균을 구하는 프로그램");
		System.out.println("0 이상 정수를 여러 개 입력하시오.");
		System.out.println("입력을 마치려면 음의 정수를 입력하시오.");
		
		int num = 0;
		int sum = 0;
		int count = 0;
		double average = 0;
		
		while(num >= 0) {
			num = input.nextInt();
			if(num < 0) {
				break;
			}
			count += 1;
			sum += num;
		}
		average = (double)sum / count;
		input.close();
		
		System.out.println("입력된 0 이상 정수 갯수 = " + count);
		
		if (sum > 0) {
			System.out.println("정수의 합 = " + sum);
			System.out.printf("평균 = %.2f", average);
		}
		
		
		
	}

}
