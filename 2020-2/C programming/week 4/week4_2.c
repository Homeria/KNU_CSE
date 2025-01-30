#include <stdio.h>
#include <limits.h>
#include <float.h>

int main(void) {

	printf("int의 최소값은 %d, 최대값은 %d 입니다.\n", INT_MIN, INT_MAX);
	printf("unsigned int의 최소값은 %u, 최대값은 %u 입니다.\n", 0, UINT_MAX);
	printf("long의 최소값은 %d, 최대값은 %d 입니다.\n", LONG_MIN, LONG_MAX);
	printf("short의 최소값은 %d, 최대값은 %d 입니다.\n", SHRT_MIN, SHRT_MAX);
	printf("unsigned long의 최소값은 %u, 최대값은 %u 입니다.\n", 0, ULONG_MAX);
	printf("unsigned short의 최소값은 %u, 최대값은 %u 입니다.\n", 0, USHRT_MAX);

	printf("\n자료형 중 문자형의 최소, 최대값을 알아봅시다.\n\n");
	printf("char 최소값은 %d, 최대값은 %d 입니다.\n", CHAR_MIN, CHAR_MAX);
	printf("unsigned char 최소값은 %d, 최대값은 %d 입니다.\n", 0, UCHAR_MAX);
	printf("signed char 최소값은 %d, 최대값은 %d 입니다.\n", SCHAR_MIN, SCHAR_MAX);

	printf("\n자료형 중 실수형의 최소, 최대값을 알아봅시다.\n\n");
	printf("float 최소값은 %.3e, 최대값은 %.3e 입니다.\n", FLT_MIN, FLT_MAX);
	printf("double 최소값은 %.3e, 최대값은 %.3e 입니다.\n", DBL_MIN, DBL_MAX);
	printf("long double 최소값은 %.3e, 최대값은 %.3e 입니다.\n", LDBL_MIN, LDBL_MAX);


	return 0;
}