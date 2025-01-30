#include <stdio.h>
int main(void) {

	int price, inputMoney, change;
	int c50000, c10000, c5000, c1000, c500, c100, c50, c10;
	int done = 0;

	printf("물건 값을 입력하시오 : ");
	scanf_s("%d", &price);
	printf("사용자가 낸 돈 : ");
	scanf_s("%d", &inputMoney);
	
	change = inputMoney - price;

	c50000 = change / 50000;
	change = change % 50000;
	c10000 = change / 10000;
	change = change % 10000;
	c5000 = change / 5000;
	change = change % 5000;
	c1000 = change / 1000;
	change = change % 1000;
	c500 = change / 500;
	change = change % 500;
	c100 = change / 100;
	change = change % 100;
	c50 = change / 50;
	change = change % 50;
	c10 = change / 10;
	change = change % 10;

	(inputMoney - price) >= 0 ? printf("오만원권 : \t %d장\n만원권 : \t %d장\n오천원권 : \t %d장\n천원권 : \t %d장\n오백원 동전 : \t %d개\n백원 동전 : \t %d개\n오십원 동전 : \t %d개\n십원 동전 : \t %d개\n남은 잔돈 : \t %d원", c50000, c10000, c5000, c1000, c500, c100, c50, c10, change) : printf("돈이 부족합니다.");

	return 0;
}