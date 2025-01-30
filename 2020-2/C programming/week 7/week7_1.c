#include <stdio.h>
int main(void) {

	int i = 1;
	int j, k;
	while (i <= 6) {
		j = i;
		while (j <= 6) {
			k = j;
			while (k <= 6) {
				if ((i + j + k) == 10) {
					printf("{%d, %d, %d}\n", i, j, k);
				}
				k++;
			}
			j++;
		}
		i++;
	}
	return 0;
}