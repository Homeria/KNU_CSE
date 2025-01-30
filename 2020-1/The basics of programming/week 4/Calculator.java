package week4;

import java.util.Scanner;

/**
 * 본 프로그램은 두 수를 입력받고, 사칙연산 중 하나를 입력하면 그에 맞는 계산을 해주는 프로그램입니다.
 * 두 개의 수를 입력한 후, +, -, *, / 중 하나를 입력하시면 됩니다.
 * 다른 기호를 쓰시면 지원하지 않아 프로그램이 바로 종료됩니다.
 * @author 차경호
 */

public class Calculator {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("사칙 연산을 하는 프로그램입니다.");
		System.out.print("두 수를 차례로 입력하시오 : ");
		double num1 = input.nextDouble();
		double num2 = input.nextDouble();
		double result = 0;
		System.out.println("두 수에 어떤 연산을 하시겠습니까?");
		System.out.print("+ - * / 중 하나를 입력하시오 : ");
		char operator = input.next().charAt(0);
		input.close();
		
		switch(operator) {
		case '+':
			result = num1 + num2;
			break;
		case '-':
			result = num1 - num2;
			break;
		case '*':
			result = num1 * num2;
			break;
		case '/':
			result = num1 / num2;
			break;
		default:
			System.out.println("지원하지 않는 연산입니다.");
			System.exit(-1);
		}
		
		System.out.printf("%.1f %c %.1f = %f", num1, operator, num2, result);
		
		
	}

}
