package week13;

import java.util.Scanner;

/**
 * 두 개의 단어를 읽어 들인 후 이 둘을 비교하여 사전순서대로 출력하는 프로그램
 * 대문자가 소문자보다 앞에 옴.
 * @author 차경호
 *
 */
public class Sorter {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("입력 : ");
		String a = new String(input.next());
		String b = new String(input.next());
		
		int n = a.compareTo(b);
		System.out.print("출력 : ");
		if (n < 0) {
			System.out.println(a + " " + b);
		} else if (n > 0) {
			System.out.println(b + " " + a);
		} else {
			System.out.println(a + " " + b);
		}
		input.close();
	}	
		
}


