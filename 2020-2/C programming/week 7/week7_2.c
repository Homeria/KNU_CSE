#include <stdio.h>
int main(void) {

	int diagonal;
	printf("Input diagonal of a rhombus : ");
	scanf_s("%d", &diagonal);

	for (int i = 0; i < diagonal; i++) {
		for (int j = diagonal - 1; j > i ; j--) {
			printf(" ");
		}
		for (int j = 0; j < 2 * i + 1; j++) {
			printf("*");
		}
		printf("\n");
	}

	for (int i = 1; i < diagonal; i++) {
		for (int j = 0; j < i; j++) {
			printf(" ");
		}
		for (int j = 2 * diagonal - 1; j > 2 * i; j--) {
			printf("*");
		}
		printf("\n");
	}

	return 0;
}