#include <stdio.h>

int zeller(int year, int month, int date);
void print_Day(day);

int main(void) {

	int year, month, date = 1, day, count, num;
	int monthDay[12] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	printf("달력을 출력할 년도와 월을 입력받습니다.\n");
	printf("년도를 입력해주세요 : ");
	scanf_s("%d", &year);
	printf("월을 입력해주세요 : ");
	scanf_s("%d", &month);
	
	printf("\n일\t월\t화\t수\t목\t금\t토\n");

	// 첫 번째 줄 출력
	day = zeller(year, month, date);
	for (int i = 0; i < day; i++) {
		printf(" \t");
	}
	printf("%d\t", date);

	// 윤년 계산
	count = day;
	if ((leapYear(year) == 1) && (month == 2)) {
		num = 29;
	}
	else {
		num = monthDay[month - 1];
	}

	// 나머지 줄 출력
	for (date = 2; date <= num; date++) {
		count++;
		if ((count % 7) == 0) {
			printf("\n");
		}
		printf("%d\t", date);
	}
	printf("\n\n");
}


// 제라 공식 함수
int zeller(int year, int month, int date) {

	if (month <= 2) {
		month += 12;
		year--;
	}
	return (year + year / 4 - year / 100 + year / 400 + (13 * month + 8) / 5 + date) % 7;

}

// 윤년 구분 함수
int leapYear(int year) {
	if ((year % 4 == 0) && (year % 100 != 0) || (year % 400) == 0) {
		return 1;
	}
	else {
		return 0;
	}
}

