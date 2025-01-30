package week4;

import java.util.Scanner;

/**
 * 본 프로그램은 아래와 같은 모양의 삼각형을 그리는 프로그램입니다.
 * 삼각형의 크기는 사용자가 입력하여 지정할 수 있습니다.
 * *
 * **
 * ***
 * ****
 * *****
 * @author 차경호
 */

public class Triangle {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("삼각형을 그리는 프로그램입니다.");
		System.out.print("삼각형의 크기를 얼마로 할까요? 1 이상의 정수를 입력하세요 : ");
		int num = input.nextInt();
		input.close();
		
		for(int i = 0; i < num; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		
	}

}
