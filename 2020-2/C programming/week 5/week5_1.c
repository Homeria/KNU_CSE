#include <stdio.h>
int main(void) {
	unsigned int num;
	unsigned int mask = 1 << 15;
	printf("십진수 : ");
	scanf_s("%u", &num);

	int count = 1;
	printf("이진수 : ");
	for (int i = 0; i < 16; i++) {
		((num & mask) == 0) ? printf("0") : printf("1");
		mask = mask >> 1;
		if ((count % 4) == 0) {
			printf(" ");
		}
		count++;
	}
	return 0;
}