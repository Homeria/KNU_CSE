package week4;

import java.util.Scanner;

/**
 * 본 프로그램은 입력받은 정수만큼 2의 거듭제곱을 구하는 프로그램입니다.
 * 만약 10을 입력한다면 2의 0제곱부터 2의 10제곱까지 출력합니다.
 * 사용자는 항상 0 이상의 정수만 입력해야 합니다.
 * 2의 31제곱부터는 올바르지 않은 값이 출력됩니다.
 * @author 차경호
 */

public class Powers {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("2의 몇 제곱까지 구할까요? ");
		int num = input.nextInt();
		int count = 0;
		input.close();
		
		for(int i = 0; count <= num; i *= 2) {
			if (i == 0) {
				i = 1;
			}
			System.out.println("2의 " + count + "제곱 : " + i);
			count += 1;
		}
		
	}

}
