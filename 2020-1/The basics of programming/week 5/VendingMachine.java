package week5;

import java.util.Scanner;

/**
 * 본 프로그램은 커피, 아이스크림, 음료수 자판기 프로그램입니다.
 * 연속적인 거래가 가능합니다.
 * 메뉴를 텍스트로 보여줍니다.
 * 돈 계산은 아직 없습니다.
 * main 메소드 하나로 구현했습니다.
 * 적절하지 않은 번호를 입력했을 때에는 처음으로 돌아갑니다.
 * @author 차경호
 *
 */


public class VendingMachine {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("아이스크림, 커피, 음료를 파는 자판기입니다.");
		
		boolean done = false;
		
		while (done == false) {
			
			System.out.println("");
			System.out.println("어떤 종류를 원하십니까?");
			System.out.println("아이스크림 :\t1");
			System.out.println("커피 :\t\t2");
			System.out.println("음료 :\t\t3");
			System.out.println("종료 :\t\t4");
			System.out.print("번호 선택 : ");
			int num = input.nextInt();
			System.out.println("");
			
			if (num == 1 ) {
				
				System.out.println("무엇을 드시겠습니까?");
				System.out.println("바닐라 아이스크림(1000원) : \t1");
				System.out.println("아몬드 아이스크림(1400원) : \t2");
				System.out.println("딸기 아이스크림(1400원) : \t3");
				System.out.println("호두 아이스크림(1400원) : \t4");
				System.out.print("번호 선택 : ");
				num = input.nextInt();
				if ((num == 1) || (num == 2) || (num == 3) || (num == 4)) {
					System.out.printf("%d 선택, 감사합니다.", num);
					System.out.println("");
				} else {
					System.out.println("적절하지 않은 번호입니다. 처음으로 돌아갑니다.");
				}
				
				
			} else if (num == 2) {
				
				System.out.println("무엇을 드시겠습니까?");
				System.out.println("아메리칸(1000원) : \t\t1");
				System.out.println("카페라떼(1400원) : \t\t2");
				System.out.println("에스프레소(1400원) :\t3");
				System.out.print("번호 선택 : ");
				num = input.nextInt();
				if ((num == 1) || (num == 2) || (num == 3)) {
					System.out.printf("%d 선택, 감사합니다.", num);
					System.out.println("");
				} else {
					System.out.println("적절하지 않은 번호입니다. 처음으로 돌아갑니다.");
				}
				
				
			} else if (num == 3) {
				System.out.println("무엇을 드시겠습니까?");
				System.out.println("생수(1000원) : \t\t1");
				System.out.println("오렌지쥬스(1400원) : \t2");
				System.out.println("망고쥬스(1400원) : \t\t3");
				System.out.println("우유(1400원) : \t\t4");
				System.out.print("번호 선택 : ");
				num = input.nextInt();
				if ((num == 1) || (num == 2) || (num == 3) || (num == 4)) {
					System.out.printf("%d 선택, 감사합니다.", num);
					System.out.println("");
				} else {
					System.out.println("적절하지 않은 번호입니다. 처음으로 돌아갑니다.");
				}
				
				
			} else if (num == 4) {
				done = true;
				System.out.println("감사합니다. 거래를 종료합니다.");
				
			} else {
				System.out.println("적절한 값이 입력되지 않았습니다. 다시 입력해주세요.");
			}
		}
		
		input.close();
		
		
	}

}
