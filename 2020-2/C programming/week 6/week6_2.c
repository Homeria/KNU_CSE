#include <stdio.h>

int main(void) {
	int score, grade, iscore;

	printf("학생의 점수를 입력하시오(0~100점) : ");
	scanf_s("%d", &score);

	iscore = score / 10;

	switch (iscore)
	{
	case 10:
		printf("A+ 학점");
		break;
	case 9:
		printf("A 학점");
		break;
	case 8:
		printf("B 학점");
		break;
	case 7:
		printf("C 학점");
		break;
	case 6:
	case 5:
	case 4:
	case 3:
	case 2:
	case 1:
	case 0:
		printf("F 학점");
		break;
	default:
		printf("[switch Error]");
	}
	return 0;

}