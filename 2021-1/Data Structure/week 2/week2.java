package week2;

import java.util.*;

public class week2 {
	
	/**
	 * 입력받은 문자열들을 저장하기 위한 LinkedList를 선언
	 * 삭제할 범위를 파라미터로 받아 리스트의 원소를 삭제하는 removeInterval 함수와
	 * LinkedList를 출력하는 printList 함수에서 LinkedList를 파라미터로 받지 않지만
	 * 각 함수에서 이용하기 위해 필드에 선언함
	 */
	static LinkedList<String> list = new LinkedList<>();

	
	public static void main(String[] args) {
		
		// 사용자로부터 문자열을 입력받기 위한 Scanner 생성
		Scanner input = new Scanner(System.in);
		
		// 사용자로부터 입력받은 문자열이 임시로 저장하기 위한 변수 선언
		String data = null;
		
		// 사용자가 LinkedList에서 삭제할 원소의 범위에 관한 데이터를 임시 저장하기 위한 변수 선언
		int start, end;
		
		// 사용자로부터 문자열 "end"가 입력되었는가를 판별하기 위한 boolean 타입 변수 선언
		boolean done = false;
		
		// 사용자가 문자열 "end"를 입력하지 않은 동안 실행
		while(!done) {
			
			// 사용자로부터 문자열을 입력받아 문자열 변수 data에 임시 저장함
			System.out.print("삽입 값 입력 : ");
			data = input.next();
			
			// 사용자로부터 입력받은 문자열이 "end"가 아니라면
			if (!(data.equals("end"))) {
				// LinkedList에 사용자로부터 입력받은 data를 원소로 추가
				list.add(data);
			// 사용자로부터 입력받은 문자열이 "end"라면
			} else {
				done = true;
			}
			// LinkedList의 원소를 출력
			printList();
		}
		
		// 사용자가 LinkedList에서 삭제할 원소의 범위를 입력받음
		System.out.print("start value : ");
		start = input.nextInt();
		System.out.print("end value : ");
		end = input.nextInt();
		// 사용자가 원하는 범위의 원소를 삭제
		removeInterval(start, end);
		
		// LinkedList의 원소를 출력
		printList();
		
		// 사용자로부터 입력을 받는 Scanner를 닫음
		input.close();
	}
	
	
	/**
	 * 파라미터로 받은 start와 end의 범위만큼 LinkedList의 원소를 삭제함
	 * @param start 시작
	 * @param end 끝
	 */
	public static void removeInterval(int start, int end) {
		for(int i = start; i <= end; i++) {
			list.remove(start - 1);
		}
	}
	
	/**
	 * LinkedList를 출력
	 */
	public static void printList() {
		ListIterator<String> iter = list.listIterator();
		String last = list.getLast();
		String s;
		while(iter.hasNext()) {
			s = iter.next();
			System.out.print(s);
			if (!(s.equals(last))) {
				System.out.print(" -> ");
			}
		}
		System.out.println();
	}

}
