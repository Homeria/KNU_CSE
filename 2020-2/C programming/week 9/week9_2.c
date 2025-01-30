#include <stdio.h>

int zeller(int year, int month, int date);
void print_Day(day);

int main(void) {

	int year, month, date = 1, day, count, num;
	int monthDay[12] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	printf("�޷��� ����� �⵵�� ���� �Է¹޽��ϴ�.\n");
	printf("�⵵�� �Է����ּ��� : ");
	scanf_s("%d", &year);
	printf("���� �Է����ּ��� : ");
	scanf_s("%d", &month);
	
	printf("\n��\t��\tȭ\t��\t��\t��\t��\n");

	// ù ��° �� ���
	day = zeller(year, month, date);
	for (int i = 0; i < day; i++) {
		printf(" \t");
	}
	printf("%d\t", date);

	// ���� ���
	count = day;
	if ((leapYear(year) == 1) && (month == 2)) {
		num = 29;
	}
	else {
		num = monthDay[month - 1];
	}

	// ������ �� ���
	for (date = 2; date <= num; date++) {
		count++;
		if ((count % 7) == 0) {
			printf("\n");
		}
		printf("%d\t", date);
	}
	printf("\n\n");
}


// ���� ���� �Լ�
int zeller(int year, int month, int date) {

	if (month <= 2) {
		month += 12;
		year--;
	}
	return (year + year / 4 - year / 100 + year / 400 + (13 * month + 8) / 5 + date) % 7;

}

// ���� ���� �Լ�
int leapYear(int year) {
	if ((year % 4 == 0) && (year % 100 != 0) || (year % 400) == 0) {
		return 1;
	}
	else {
		return 0;
	}
}

