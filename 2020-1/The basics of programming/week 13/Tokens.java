package week13;

import java.util.Scanner;

/**
 * 입력된 문자열에서 "/"로 구분된 단어를 분리하여 인덱스와 함께 출력하는 프로그램
 * @author 차경호
 *
 */
public class Tokens {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String s = input.nextLine();
		String[] array = s.split("/");
		
		for(int i = 0; i < array.length; i++) {
			System.out.println("[" + i + "] " + array[i]);
		}
		
		
		input.close();
		
	}

}
