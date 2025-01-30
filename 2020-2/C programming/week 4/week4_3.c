#include <stdio.h>

int main(void) {
	const float PI = 3.141592;
	float radius, height;
	printf("Input radius of cylinder : ");
	scanf_s("%f", &radius);
	printf("Input height of cylinder : ");
	scanf_s("%f", &height);
	printf("==============\n");
	float surfaceArea = (2 * PI * radius * height) + (2 * PI * radius * radius);
	float volume = PI * radius * radius * height;
	printf("Surface area of cylinder : %.2f\n", surfaceArea);
	printf("Volume of cylinder : %.2f", volume);

	return 0;
}