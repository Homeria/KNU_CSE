#include <stdio.h>
int main(void) {
	// int x, y, z, sum;   ->    sum�� �ʱ� ���� ���������� �ʾ� ����� �� ���ǰ� �̷������ ����.
	// ���������� �۵��ϱ� ���ؼ��� sum = 0�� ���� �ʱ� ���� �������־�� ��.
	int x, y, z;
	int sum = 0;
	printf("3���� ������ �Է��ϼ��� (x, y, z) : ");
	scanf_s("%d %d %d", &x, &y, &z);
	sum += x;
	sum += y;
	sum += z;
	printf("������ �� : %d\n", sum);
	return 0;
}