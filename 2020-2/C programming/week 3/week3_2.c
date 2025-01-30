#include <stdio.h>

int main(void) {

	int radius, height;

	printf("Input radius of cylinder : ");
	scanf_s("%d", &radius);
	printf("Input height of cylinder : ");
	scanf_s("%d", &height);

	float surface = (2 * radius * height * 3.14) + (2 * radius * radius * 3.14);
	float volume = radius * radius * height * 3.14;

	printf("Surface area of cylinder : %.2f\n", surface);
	printf("Volume of cylinder : %.2f", volume);

}