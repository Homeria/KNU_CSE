#include <stdio.h>
int main(void) {

	int price, inputMoney, change;
	int c50000, c10000, c5000, c1000, c500, c100, c50, c10;
	int done = 0;

	printf("���� ���� �Է��Ͻÿ� : ");
	scanf_s("%d", &price);
	printf("����ڰ� �� �� : ");
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

	(inputMoney - price) >= 0 ? printf("�������� : \t %d��\n������ : \t %d��\n��õ���� : \t %d��\nõ���� : \t %d��\n����� ���� : \t %d��\n��� ���� : \t %d��\n���ʿ� ���� : \t %d��\n�ʿ� ���� : \t %d��\n���� �ܵ� : \t %d��", c50000, c10000, c5000, c1000, c500, c100, c50, c10, change) : printf("���� �����մϴ�.");

	return 0;
}