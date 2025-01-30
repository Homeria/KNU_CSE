#include <stdio.h>

int main(void) {
	printf("input w(idth), h(eight), l(ength) of cuboid : ");

	int width, height, length;
	scanf_s("%d %d %d", &width, &height, &length);

	int volume = width * height * length;
	int surface = (width * length * 2) + (length * height * 2) + (width * height * 2);
	int edgeSum = (width * 4) + (length * 4) + (height * 4);

	printf("Volume of cuboid : %d\n", volume);
	printf("Surface area of cuboid : %d\n", surface);
	printf("Sumf of Edges : %d", edgeSum);

}