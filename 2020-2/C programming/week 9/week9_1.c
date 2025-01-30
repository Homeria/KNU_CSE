#include <stdio.h>

int get_number(void);
void print_binary(int num);

int main(void) {
	int num = get_number();
	print_binary(num);
	return 0;
}


int get_number(void) {
	int num;
	printf("정수를 입력하시오 : ");
	scanf_s("%d", &num);
	return num;
}


void print_binary(int num) {
	int a = num, binary, sum = 0, i = 1;
	while (a > 0) {
		binary = a % 2;
		sum += binary * i;
		a /= 2;
		i *= 10;
	}
	printf("%d", sum);
}


