#include <stdio.h>
int main(void) {

	int num;
	int count = 65;
	int done = 0;

	while (done == 0) {
		// �Է�
		printf("Input the number of letters in the pyramid (input 1 to 26, 0 to exit) : ");
		scanf_s("%d", &num);
		if (num > 0 && num <= 26) {
			for (int i = 0; i < num; i++) {
				count = 65;

				// ��ĭ ���
				for (int j = num - 1; j > i; j--) {
					printf(" ");
				}
				// ���ĺ� ���
				for (int j = 0; j < 2 * i + 1; j++) {
					printf("%c", count);
					if (j < i) {
						count++;
					}
					else if (j >= i) {
						count--;
					}
				}
				// �ٹٲ�
				printf("\n");
			}
		}
		else if (num == 0) {
			done = 1;
			printf("Goodbye!");
		}
		else {
			printf("User inputs non-valid number, try again!");
		}
	}
	return 0;
}