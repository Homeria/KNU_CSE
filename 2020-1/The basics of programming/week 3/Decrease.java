package week3;

import java.util.Scanner;

public class Decrease {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("양의 정수를 하나 입력하시오 : ");
		int number = input.nextInt();
		input.close();
		
		for(int i = number; i >= 0; i--) {
			System.out.print(i + " ");
			
		}
		
		
		
	}

}
