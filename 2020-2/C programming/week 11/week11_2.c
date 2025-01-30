#include <stdio.h>
#include <stdlib.h>

int main(void) {
	int array[50];
	int size, random_number, result;

	printf("Input size of array (less than 50) : ");
	scanf_s("%d", &size);

	if (size > 50) {
		printf("size is too big.\n");
	}
	else {
		for (int i = 0; i < size; i++) {
			random_number = -1000 + ((rand() % 2000) + 1);
			array[i] = random_number;
			printf("%d\t%d\n", i, random_number);
		}

		result = getMax(array, size);
		if (result != 0) {
			printf("The maximum circular sum in the above array is : %d", result);
		}
		else {
			printf("The maximum circular sum in the above array is : %d", getMaxElement(array, size));
		}
	}
	return 0;
}

int getMax(int array[50], int size) {
	int temp = 0, max = 0, i;
	for (i = 0; i < size; i++) {
		temp += array[i];
		if (temp > max) {
			max = temp;
		}
		else if (temp < 0) {
			temp = 0;
		}
	}
	return max;
}

int getMaxElement(int array[50], int size) {
	int max = INT_MIN, i;
	for (i = 0; i < size; i++) {
		if (max < array[i]) {
			max = array[i];
		}
	}
	return max;
}