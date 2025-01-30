package week3;

import java.util.Scanner;


/**
 * Reverser를 테스트하는 프로그램
 * 글자들의 순서를 글자 단위와 단어 단위로 바꾼 새 문자열 2개를 출력한다.
 * @author 차경호
 *
 */
public class ReverserTest {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("문자열을 입력하세요 : ");
		String s = input.nextLine();
		
		Reverser reverser = new Reverser(s);
		
		String reversedString = null;
		reversedString = reverser.reverse();
		System.out.print("뒤집힌 문자열 : ");
		System.out.println(reversedString);
		
		// -----------------------------------
		
		String reversedWords = null;
		reversedWords = reverser.reverseWords();
		System.out.print("단어 단위로 뒤집힌 문자열 : ");
		System.out.println(reversedWords);
		
		
		input.close();
		
	}

}
