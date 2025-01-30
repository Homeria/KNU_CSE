package week6;

import java.util.Scanner;

/**
 * 주어진 음이 아닌 정수보다 작거나 같은 정수의 제곱수들 중 최대값을 구하는 프로그램
 * 프로그램은 계속 반복하며, 음수가 입력되면 종료됩니다.
 * @author 차경호
 *
 */
public class MaxSquareTest {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		boolean done = false;
		
		while(done == false) {
			System.out.print("입력 : ");
			int num = input.nextInt();
			
			if (num >= 0) {
				int maxSquare = maxSquare(num);
				System.out.println(num + "보다 작거나 같은 최대 \"정수의 제곱수는\" " + maxSquare + "입니다.");
			} else {
				System.out.println("프로그램이 끝났습니다.");
				done = true;
			}
		}
		input.close();
		
	}
	
	
	/**
	 * 주어진 음이 아닌 정수보다 작거나 같은 "정수의 제곱수"들 중 최대값을 구한다
	 * @param bound 주어진 정수 (음이 아니고 정수여야 함)
	 * @return 최대 "정수의 제곱수"
	 */
	
	public static int maxSquare(int bound) {
		int num = 0;
		
		for (int i = 1; bound >= i * i; i++) {
			int num1 = i * i;
			int num2 = (i + 1) * (i + 1);
			
			if (bound < num2) {
				num = num1;
			}
		}
		return num;
	}

}
