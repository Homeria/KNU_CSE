#include <stdio.h>
#include <string.h>

void separatePrint(char string[]);

#define LENGTH 1000

int main(void) {

	char string[LENGTH];

	while (1) {
		printf("Separate the individual characters from a string : \n");
		printf("---------------------------------------------------------\n");
		printf("Input the string : ");
		gets(string);
		printf("The characters of the string are : \n");
		separatePrint(string);

		printf("\n\n");
	}
	
}


void separatePrint(char string[]) {
	int i = 0;
	while (string[i] != '\0') {
		printf("%c", string[i]);
		printf(" ");
		i++;
	}

}