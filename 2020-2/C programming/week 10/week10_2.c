#include <stdio.h>

int path(int n, int m);

int main(void) {

	int x, y, count;
	printf("Input X of grid : ");
	scanf_s("%d", &x);
	printf("Input Y of grid : ");
	scanf_s("%d", &y);

	count = path(x, y);
	printf("count = %d\n", count);
	printf("Number of paths from CELL(1, 1) to CELL(%d, %d) : %d", x, y, count);

}


int path(int n, int m) {
	int count = 1;
	if ((n > 1) && (m > 1)) {
		count = path(n - 1, m) + path(n, m - 1);
	}
	return count;
}