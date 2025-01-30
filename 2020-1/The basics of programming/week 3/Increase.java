package week3;

import java.util.Scanner;

public class Increase {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("양의 정수 하나 입력하시오 : ");
		int number = input.nextInt();
		input.close();
		int count = 0;
		
		System.out.println("첫번째 방법");
		for(int i = 0; i <= number; i++) {
			System.out.print(i + "\t");
			if ((i % 10) == 9) {
				System.out.println("");
			}
		}
		
		System.out.println("");
		
		System.out.println("두번째 방법");
		for(int i = 0; i <= number; i++) {
			System.out.print(i + "\t");
			count += 1;
			if (count == 10) {
				System.out.println("");
				count = 0;
			}
		}
	}

}
