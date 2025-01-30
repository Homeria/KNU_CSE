#include <stdio.h>

void encrypt(char string[], int shift);

int main(void) {

	char string[100];
	int shift = 3;
	printf("문자열을 입력하시오 : ");
	gets(string, 100);

	encrypt(string, shift);
	printf("암호화된 문자열 : %s", string);

}

void encrypt(char string[], int shift) {
	int i = 0;
	while (string[i] != '\0') {
		string[i] += shift;
		if (string[i] > 'z') {
			string[i] -= 57;
		}
		i++;
	}
}