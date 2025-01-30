#include <stdio.h>
int main(void) {

	int m = 300;
	float fx = 300.60;
	char cht = 'z';

	int *pi = &m;
	float *pf = &fx;
	char *pc = &cht;

	printf("m = %d\n", m);
	printf("fx = %f\n", fx);
	printf("cht = %c\n\n", cht);

	printf("[Using & operator]\n");
	printf("--------------------------------------------\n");
	printf("adress of m = 0x%p\n", &m);
	printf("adress of fx = 0x%p\n", &fx);
	printf("adress of cht = 0x%p\n\n", &cht);

	printf("[Using & and * operator]\n");
	printf("--------------------------------------------\n");
	printf("value at adress of m = %d\n", *(&m));
	printf("value at adress of fx = %f\n", *(&fx));
	printf("value at adress of cht = %c\n\n", *(&cht));

	printf("[Using only pointer variable]\n");
	printf("--------------------------------------------\n");
	printf("address of m = 0x%p\n", pi);
	printf("address of fx = 0x%p\n", pf);
	printf("address of cht = 0x%p\n\n", pc);

	printf("[Using only pointer operator]\n");
	printf("--------------------------------------------\n");
	printf("value at adress of m = %d\n", *pi);
	printf("value at adress of fx = %f\n", *pf);
	printf("value at adress of cht = %c\n\n", *pc);

	return 0;
}