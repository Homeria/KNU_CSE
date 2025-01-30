package week13;

import java.util.Scanner;

/**
 * 주어진 문자열에 나오는 영문자 중 가장 빈도가 높은 영문자를 출력하는 프로그램
 * 대문자와 소문자는 서로 다른 글자로 간주
 * 빈도가 가장 높은 글자가 여러 개인 경우 그 중 아스키코드 번호가 가장 작은 글자 출력
 * 코드 번호 : 소문자 > 대문자
 * @author 차경호
 *
 */
public class Frequency {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("입력 : ");
		String string = input.next();
		int[] counter = new int[256];

		
		for(int i = 0; i < string.length(); i++) {
			counter[string.charAt(i)]++;
		}
		
		int index = 0;
		int max = 0;
		for(int i = 0; i < counter.length; i++) {
			if (counter[i] > max) {
				max = counter[i];
				index = i;
			}
		}
		
		System.out.print("출력 : ");
		System.out.println((char)index);
		input.close();
		
	}

}
