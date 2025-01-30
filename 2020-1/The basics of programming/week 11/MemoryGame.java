package week11;

import java.util.Scanner;


/**
 * 기억력놀이 프로그램
 * 정수 갯수를 입력하고, 입력한 갯수만큼 나온 정수를 기억하고 1을 입력하여 정수들을 맞혀야 함
 * @author 차경호
 *
 */
public class MemoryGame {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int[]  list;
		int listLength;
		
		
		System.out.print("몇 개의 정수들을 보시겠습니까? ");
		listLength = input.nextInt();
		list = new int[listLength];
		ArrayUtil.fillRandomDistinct(list, 100);
		
		for(int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
		
		System.out.print("1을 입력하면 숫자를 감춥니다.");
		input.nextInt();
		for(int i = 0; i < 100; i++) {
			System.out.println();
		}
		
		System.out.println("어떤 숫자들이 있었는지 맞춰보세요.");
		System.out.println("입력을 끝내려면 음수를 입력하세요.");
		
		int[] answerList = new int[listLength];
		for(int i = 0; i < listLength; i++) {
			answerList[i] = input.nextInt();
		}
		input.close();
		
		int correctNum = checkAnswers(list, answerList, listLength);
		System.out.println(correctNum + "개 맞췄습니다.");
		
		
		
	}
	
	
	/**
	 * 사용자가 입력한 정수들이 list에 몇 개나 들어 있는지 알아냄
	 * list에는 난수들이 꽉 차 있다.
	 * answer 배열에는 앞의 일부분에만 사용자가 입력한 답이 들어 있을 수 있다.
	 * @param list 서로 다른 난수가 들어 있는 배열
	 * @param answer 사용자가 입력한 정수들이 들어 있는 배열
	 * @param answerNumber answer에 들어 있는 정수 개수
	 * @return 사용자가 입력한 정수들이 list에 몇 개나 들어 있는지
	 */
	public static int checkAnswers(int[] list, int[] answer, int answerNumber) {
		int correctAnswer = 0;
		for(int i = 0; i < answerNumber; i++) {
			if (Search.linearSearch(list, list.length, answer[i]) != -1) {
				correctAnswer += 1;
			}
		}
		
		return correctAnswer;
	}

}
