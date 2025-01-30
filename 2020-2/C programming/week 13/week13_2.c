#include <stdio.h>

void factorial(int count, int* number);

int main(void) {
	int number, input;
	printf("Input a number : ");
	scanf_s("%d", &number);
	input = number;
	factorial(input, &number);
	printf("The Factorial of %d is : %d\n", input, number);
}

void factorial(int count,  int *number) {
	int fact = 1;
	for (int i = 1; i <= count; i++) {
		fact = fact * i;
	}
	*number = fact;
}