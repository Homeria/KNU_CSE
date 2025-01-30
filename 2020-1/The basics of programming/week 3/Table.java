package week3;

import java.util.Scanner;

public class Table {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("표를 인쇄합니다.");
		System.out.print("행을 몇 개 만들까요? ");
		int row = input.nextInt();
		System.out.print("열을 몇 개 만들까요? ");
		int column = input.nextInt();
		input.close();
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print("(" + i + ", " + j + ")" + "\t");
			}
			System.out.println("");
		}
		
		
		
		
	}

}
