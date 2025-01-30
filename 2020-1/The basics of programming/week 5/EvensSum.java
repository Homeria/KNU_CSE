package week5;

import java.util.Scanner;

/**
 * 주어진 두 수 사이의 짝수의 합을 구하는 프로그램입니다.
 * 주어진 수가 짝수이면 그 수도 합에 포함됩니다.
 * @author 차경호
 *
 */

public class EvensSum {

	public static void main(String[] args) {

		int sumResult;
		int temp;
		boolean done = false;
		
		Scanner input = new Scanner(System.in);
		System.out.println("정해진 구간의 짝수들의 합을 구합니다.");
		
		while(done == false) {
			System.out.print("두 개의 정수를 입력하시오 : ");
			int from = input.nextInt();
			int to = input.nextInt();
			
			if ((from == 0) && (to == 0)) {

				System.out.println("감사합니다. 프로그램을 마칩니다.");
				done = true;
			} else {
				if (from > to) {
					temp = to;
					to = from;
					from = temp;
				}
				sumResult = getEvensSum(from, to);
				System.out.printf("%d부터 %d까지의 짝수의 합 = %d\n", from, to, sumResult);
			}
		}
		input.close();
		
		
	}
	
	/**
	 * 주어진 두 수 사이의 짝수의 합을 구합니다.
	 * 주어진 수가 짝수이면 그 수도 합에 포함됩니다.
	 * 	전제조건 : from <= to
	 * 	이 메소들을 호출할 때는 이 전제조건을 지켜야 합니다.
	 * 	전제조건을 지킬 때만 이 메소드는 올바른 결과를 보장합니다.
	 * 
	 * @param from 주어진 수
	 * @param to 주어진 수
	 * @return 짝수의 합
	 */
	public static int getEvensSum(int from, int to) {
		
		int sumResult = 0;
		for(int i = from; i <= to; i++) {
			if ((i % 2) == 0) {
				sumResult += i;
			}
		}
		return sumResult;
		
	}

}
