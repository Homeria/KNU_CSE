package week3;

import java.util.Scanner;

public class Decrease2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("양의 정수를 하나 입력하시오 : ");
		int number = input.nextInt();
		input.close();
		int count = 0;
		
		System.out.println("첫번째 방법");
		for(int i = number; i >= 0; i--) {
			System.out.print(i + "\t");
			if ((i % 10) == ((number % 10) + 1)) {
				if (i != number) {
					System.out.println("");
				}
			}
		}
		
		System.out.println("");
		
		System.out.println("두번째 방법");
		for(int i = number; i >= 0; i--) {
			System.out.print(i + "\t");
			count += 1;
			if (count == 10) {
				System.out.println("");
				count = 0;
			}
		}
		
		
	}

}
