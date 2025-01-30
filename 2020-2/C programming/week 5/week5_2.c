#include <stdio.h>
int main(void) {
	int firstNum, secondNum, biggerNum;

	printf("Input first number : ");
	scanf_s("%d", &firstNum);
	printf("Input second number : ");
	scanf_s("%d", &secondNum);
	//                                            firstNum == secondNumÀÌ True     (                      False                                       firstNum > seocndNumÀÌ True                   False                                               )
	biggerNum = firstNum == secondNum ? printf("Equal number") : (biggerNum = firstNum > secondNum ? printf("Bigger Number : %d", firstNum) : printf("Bigger Number : %d", secondNum));
	
	return 0;
}