#include <stdio.h>
int main(void) {
	// int x, y, z, sum;   ->    sum의 초기 값을 지정해주지 않아 제대로 된 정의가 이루어지지 않음.
	// 정상적으로 작동하기 위해서는 sum = 0과 같이 초기 값을 지정해주어야 함.
	int x, y, z;
	int sum = 0;
	printf("3개의 정수를 입력하세요 (x, y, z) : ");
	scanf_s("%d %d %d", &x, &y, &z);
	sum += x;
	sum += y;
	sum += z;
	printf("정수의 합 : %d\n", sum);
	return 0;
}