#include <stdio.h>

void swap(double* a, double* b, double* c);

int main(void) {
	double a, b, c;
	printf("Input the value of 1st element : ");
	scanf_s("%lf", &a);
	printf("Input the value fo 2nd element : ");
	scanf_s("%lf", &b);
	printf("Input the value of 3rd element : ");
	scanf_s("%lf", &c);

	printf("\nThe value before swapping are :\n");
	printf("element 1 = %lf, element 2 = %lf, element 3 = %lf\n\n", a, b, c);

	swap(&a, &b, &c);

	printf("The vlaue after swapping are :\n");
	printf("element 1 = %lf, element 2 = %lf, element 3 = %lf\n\n", a, b, c);
}

void swap(double *a, double *b, double *c) {
	double tmp;
	tmp = *c;
	*c = *b;
	*b = *a;
	*a = tmp;
}