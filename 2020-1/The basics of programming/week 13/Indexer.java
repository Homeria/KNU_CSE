package week13;

import java.util.Scanner;

/**
 * 한 줄의 문장을 읽어 들여 'a', 'b', 'c'가 처음 나오는 인덱스의 합을 출력하는 프로그램.
 * @author 차경호
 *
 */
public class Indexer {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("입력 : ");
		String a = new String(input.nextLine());
		a = a.toLowerCase();
		
		int sum = 0;
		sum += returnIndex(a, 'a');
		sum += returnIndex(a, 'b');
		sum += returnIndex(a, 'c');
		
		System.out.println("출력 : " + sum);
		
		input.close();
	}
	
	
	/**
	 * 문장에 원하는 글자가 있는지 판별하고 그 글자가 나오는 첫 번째 인덱스를 반환하는 메소드
	 * @param a 문장
	 * @param b 찾기 원하는 글자
	 * @return 만약 찾기 원하는 글자가 있다면 문장에서의 인덱스값
	 * 			만약 찾기 원하는 글자가 없다면 -1
	 */
	public static int returnIndex(String a, char b) {
		char c;
		for(int i = 0; i < a.length(); i++) {
			c = a.charAt(i);
			if (c == b) {
				return i;
			}
		}
		return -1;
	}
	
	
	

}
