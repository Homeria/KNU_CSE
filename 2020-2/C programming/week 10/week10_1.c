#include <stdio.h>

int move(int n, int i, int j, int k);

int main(void) {

	int disk;
	printf("Number of disks : ");
	scanf_s("%d", &disk);

	move(disk, 1, 3, 2);

}


int move(int n, int i, int j, int k) {

	if (n > 0) {

		move(n - 1, i, k, j);

		printf("Move disk %d from rod %c to rod %c\n", n, i + 64, j + 64);

		move(n - 1, k, j, i);

	}


}