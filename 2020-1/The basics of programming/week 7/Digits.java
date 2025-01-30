package week7;

import java.util.Scanner;

/**
 * 입력받은 숫자를 문자열로 취급하여 문자열의 길이를 알려주고, 각 자릿수를 분리하여 출력하는 프로그램
 * 마이너스 기호도 문자열의 길이에 포함
 * length, charAt 사용
 * @author CKH
 *
 */
public class Digits {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("숫자를 입력하시오 : ");
		String num = input.next();
		String digits = "";
		input.close();
		
		System.out.println(num.length() + "개의 글자로 이루어진 문자열입니다.");
		for (int i = 0; i < num.length(); i++) {
			digits += num.charAt(i);
			digits += " ";
		}
		System.out.println(digits);
		
	}

}
