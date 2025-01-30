package week9;

import java.util.Scanner;


/**
 * 키보드로부터 정수들을 차례로 입력받아 배열에 저장한 후 역순으로 출력하는 프로그램
 * 'q' 혹은 'Q'를 입력시, 입력은 종료되며, 배열을 역순으로 출력하고 입력한 정수들의 평균값을 알려줌.
 * 정수를 최대 100개까지 입력할 수 있으며, 초과시 오류가 발생함.
 * @author 차경호
 */
public class ReverseQ {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		boolean done = false;
		int value[] = new int[100];
		String stringValue;
		int sum = 0;
		int num = 0;
		
		System.out.println("입력을 마치려면 \'q\', 혹은 \'Q\'를 입력하시오 : ");
		
		while(!done) {
			stringValue = input.next();
			
			if ((stringValue.equals("q")) || (stringValue.equals("Q"))) {
				done = true;
			} else {
				value[num] = Integer.parseInt(stringValue);
				sum += Integer.parseInt(stringValue);
				num++;
			}
		}
		
		System.out.println("배열을 역순으로 출력 : ");
		for(int i = num-1; i >= 0; i--) {
			System.out.print(value[i] + "\t");
		}
		System.out.println("\n평균값 : " + ((double)sum / (double)num));
		
		input.close();
	}

}
