#include <stdio.h>

int main(void) {

	char inputAlphabet;
	printf("���ڸ� �Է��Ͻÿ� : ");
	scanf_s("%c", &inputAlphabet, 1);

	if  (inputAlphabet >= 'A' && inputAlphabet <= 'Z') {
		printf("�Է��� ����(%c)�� �빮���Դϴ�.\n", inputAlphabet);
		printf("�Է��� ������ �ҹ��ڴ� %c �Դϴ�.", inputAlphabet + 32);
	}
	else if (inputAlphabet >= 'a' && inputAlphabet <= 'z') {
		printf("�Է��� ����(%c)�� �ҹ����Դϴ�.\n", inputAlphabet);
		printf("�Է��� ������ �빮�ڴ� %c �Դϴ�.", inputAlphabet - 32);
	}
	else {
		printf("��� �Է����ּ���.");
	}
	return 0;

}