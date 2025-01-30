#include <stdio.h>

int main(void) {

	char inputAlphabet;
	printf("문자를 입력하시오 : ");
	scanf_s("%c", &inputAlphabet, 1);

	if  (inputAlphabet >= 'A' && inputAlphabet <= 'Z') {
		printf("입력한 문자(%c)는 대문자입니다.\n", inputAlphabet);
		printf("입력한 문자의 소문자는 %c 입니다.", inputAlphabet + 32);
	}
	else if (inputAlphabet >= 'a' && inputAlphabet <= 'z') {
		printf("입력한 문자(%c)는 소문자입니다.\n", inputAlphabet);
		printf("입력한 문자의 대문자는 %c 입니다.", inputAlphabet - 32);
	}
	else {
		printf("영어를 입력해주세요.");
	}
	return 0;

}