package week13;

import java.util.Scanner;

/**
 * 단어를 입력 받아 중복을 제거하고 나머지 단어들을 한 줄에 한 단어씩 출력하는 프로그램
 * @author 차경호
 *
 */
public class Unique {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("입력 : ");
		String[] array = input.nextLine().split(" ");
		String[] distinctArray = new String[array.length];
		
		int num = 0;
		for(int i = 0; i < array.length; i++) {
			if (linearSearch(distinctArray, (num + 1), array[i]) == -1) {
				distinctArray[num] = array[i];
				num++;
			}
		}
		
		System.out.println("출력 : ");
		for(int i = 0; i < distinctArray.length; i++) {
			if(distinctArray[i] != null) {
				System.out.print(distinctArray[i] + "\n");
			}
		}
		input.close();
	}
	
	
	/**
	 * 문자열 배열 내에 자신이 찾고자 하는 단어가 있는지를 검사하는 메소드
	 * 이 메소드는 선형탐색 방식임.
	 * @param 배열
	 * @param 어디까지 검사를 할 것인지에 대한 기준
	 * @param key 찾고자 하는 단어
	 * @return key와 동일한 단어가 있다면 0 반환,
	 * 			key와 동일한 단어가 없다면 -1 반환
	 */
	public static int linearSearch(String[] s, int n, String key) {
		for(int i = 0; i < n; i++) {
			if(s[i] != null) {
				if (s[i].equalsIgnoreCase(key)) {
					return 0;
				}
			}
		}
		return -1;
	}
	
}
