package week13;

import java.util.Scanner;

/**
 * 입력받은 문자들을 스택 구조로 쌓아 출력하는 프로그램
 * "*"가 있는 경우 전에 쌓은 것("*"이 나올 때 스택에 맨 위에 있는 것)을 제거하고 "*"의 다음 단어를 스택 구조에 쌓음.
 * 최대 1000개의 문자를 입력할 수 있음.
 * @author 차경호
 *
 */
public class MyStack {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("입력 : ");
		String s = input.nextLine();
		input.close();
		String[] array = s.split(" ");
		String[] myStack = new String[1000];
		int top = -1;

		for(int i = 0; i < array.length; i++) {
			
			if(array[i].equals("*")) {
				if(i != 0) {
					top--;
				}
			} else {
				myStack[++top] = array[i];
			}
		}
		
		System.out.print("출력 : ");
		while(top >= 0) {
			System.out.print(myStack[top--] + " ");
		}
		
	}

}
