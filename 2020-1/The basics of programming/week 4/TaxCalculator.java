package week4;

import java.util.Scanner;

/**
 * 본 프로그램은 입력한 소득에 따라 다른 세율을 적용하여 소득세를 알려주는 프로그램입니다.
 * 소득이 4600만원 이하는 15%, 8800만원 이하는 24%, 8800만원 초과는 35%의 세금이 발생합니다.
 * 만약 소득이 9000만원이라면 4600만원의 15%
 * 8800만원에서 4600만원을 뺀 4200만원에서 24%
 * 9000만원에서 8800만원을 뺀 200만원에서 35%의 세금이 발생합니다.
 * @author 차경호
 *
 */

public class TaxCalculator {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		final double TAX_RATE_LOW = 15.0/100.0;
		final double TAX_RATE_MID = 24.0/100.0;
		final double TAX_RATE_HIGH = 35.0/100.0;
		double tax = 0;
		
		System.out.print("소득은? 만원단위로 입력하시오 : ");
		int income = input.nextInt();
		input.close();
		
		if (income > 8800) {
			tax = 4600 * TAX_RATE_LOW + (8800 - 4600) * TAX_RATE_MID + (income - 8800) * TAX_RATE_HIGH;
		} else if ((income > 4600) && (income <= 8800)) {
			tax = 4600 * TAX_RATE_LOW + (income - 4600) * TAX_RATE_MID;
		} else {
			tax = income * TAX_RATE_LOW;
		}
		
		System.out.printf("소득세 : " + tax + "만원");
		
		
	}

}
