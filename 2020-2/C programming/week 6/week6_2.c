#include <stdio.h>

int main(void) {
	int score, grade, iscore;

	printf("�л��� ������ �Է��Ͻÿ�(0~100��) : ");
	scanf_s("%d", &score);

	iscore = score / 10;

	switch (iscore)
	{
	case 10:
		printf("A+ ����");
		break;
	case 9:
		printf("A ����");
		break;
	case 8:
		printf("B ����");
		break;
	case 7:
		printf("C ����");
		break;
	case 6:
	case 5:
	case 4:
	case 3:
	case 2:
	case 1:
	case 0:
		printf("F ����");
		break;
	default:
		printf("[switch Error]");
	}
	return 0;

}