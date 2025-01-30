package week9;

/**
 * 10개의 정수를 차례로 읽어 배열에 저장한 후 입력한 순서의 역순으로 출력하는 프로그램
 * @author 차경호
 */
import java.util.Scanner;

public class Reverse {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int[] num = new int[10];
		
		System.out.println("정수 10개를 차례로 입력하시오 : ");
		
		for (int i = 0; i < 10; i++) {
			num[i] = input.nextInt();
		}
		
		System.out.println("배열을 역순으로 출력 : ");
		for (int i = 9; i >= 0; i--) {
			System.out.print(num[i] + " ");
		}
		
		input.close();
	
		
		
	}

}
