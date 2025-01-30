package week4;

import java.util.Scanner;

/**
 * 본 프로그램은 현금 입출금 ATM 기계 프로그램입니다.
 * 거래만 무제한 허용됩니다.
 * 잔액 확인, 입금, 출금이 가능합니다.
 * 4번을 입력하면 프로그램이 바로 종료됩니다.
 * @author 차경호
 */

public class ATMMachine2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double money = 5000;
		int num;
		double withdrawalMoney;
		double deposit;
		boolean done = false;
		
		while (done == false) {
			
			System.out.println("ATM 프로그램입니다. 번호를 입력하세요 .");
			System.out.println("잔액 확인 : 1");
			System.out.println("현금인출 : 2");
			System.out.println("입금 : 3");
			System.out.println("종료 : 4");
			System.out.print("번호 선택 : ");
			num = input.nextInt();
			
			switch(num) {
			case 1:
				System.out.printf("잔액은 %.1f원 입니다.", money);
				break;
				
			case 2:
				System.out.print("금액은? : ");
				withdrawalMoney = input.nextInt();
				if(withdrawalMoney > money) {
					System.out.println("돈이 모자랍니다");
				} else {
					money -= withdrawalMoney;
				}
				System.out.printf("잔액은 %.1f입니다.", money);
				break;
				
			case 3:
				System.out.print("금액은? : ");
				deposit = input.nextDouble();
				money += deposit;
				System.out.printf("잔액이 %.1f원이 되었습니다.", money);
				break;
				
			case 4:
				System.out.println("감사합니다.");
				done = true;
				break;
				
			default:
				System.out.println("올바르지 않은 번호입니다.");
				
			}
			System.out.println("\n");
		}
		
		input.close();
		
		
		
	}

}
