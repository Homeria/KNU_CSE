package week1;

import java.util.*;

public class week1 {
	
	public static void main(String[] args) {
		
		// 입력한 정수를 보관하는 리스트 생성
		List<Integer> list = new ArrayList<Integer>();
		
		// 사용자로부터 정수를 입력받기 위한 Scanner 생성
		Scanner input = new Scanner(System.in);
		
		// 사용자로부터 입력받은 정수를 임시로 저장하기 위한 변수 선언
		int num = 0;
		
		// 사용자가 정수를 모두 입력했을 경우(1000이 입력됐을 경우)를 구분하는 불리언 타입 변수 선언
		boolean done = false;
		
		// 사용자가 숫자 1000 을 입력하기 전까지 값을 입력받아 리스트의 원소로 추가함
		while(!done) {
			
			// 사용자로부터 정수를 입력받음
			System.out.print("숫자 입력 : ");
			num = input.nextInt();
			
			// 만약 입력받은 정수가 1000 이 아니였을 경우 리스트에 입력받은 정수를 원소로 추가함
			if (num != 1000) {
				list.add(num);
				
			// 만약 입력받은 정수가 1000 이었을 경우 done을 true로 만들어 while문을 빠져나옴
			} else {
				done = true;
			}
		}
		
		// 리스트에 들어있는 정수를 차례로 출력함
		for(int n : list) {
			System.out.println(n);
		}
		
		// Scanner를 종료함
		input.close();
	}
}
