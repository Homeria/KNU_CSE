#include <stdio.h>
#include <limits.h>
#include <float.h>

int main(void) {

	printf("int�� �ּҰ��� %d, �ִ밪�� %d �Դϴ�.\n", INT_MIN, INT_MAX);
	printf("unsigned int�� �ּҰ��� %u, �ִ밪�� %u �Դϴ�.\n", 0, UINT_MAX);
	printf("long�� �ּҰ��� %d, �ִ밪�� %d �Դϴ�.\n", LONG_MIN, LONG_MAX);
	printf("short�� �ּҰ��� %d, �ִ밪�� %d �Դϴ�.\n", SHRT_MIN, SHRT_MAX);
	printf("unsigned long�� �ּҰ��� %u, �ִ밪�� %u �Դϴ�.\n", 0, ULONG_MAX);
	printf("unsigned short�� �ּҰ��� %u, �ִ밪�� %u �Դϴ�.\n", 0, USHRT_MAX);

	printf("\n�ڷ��� �� �������� �ּ�, �ִ밪�� �˾ƺ��ô�.\n\n");
	printf("char �ּҰ��� %d, �ִ밪�� %d �Դϴ�.\n", CHAR_MIN, CHAR_MAX);
	printf("unsigned char �ּҰ��� %d, �ִ밪�� %d �Դϴ�.\n", 0, UCHAR_MAX);
	printf("signed char �ּҰ��� %d, �ִ밪�� %d �Դϴ�.\n", SCHAR_MIN, SCHAR_MAX);

	printf("\n�ڷ��� �� �Ǽ����� �ּ�, �ִ밪�� �˾ƺ��ô�.\n\n");
	printf("float �ּҰ��� %.3e, �ִ밪�� %.3e �Դϴ�.\n", FLT_MIN, FLT_MAX);
	printf("double �ּҰ��� %.3e, �ִ밪�� %.3e �Դϴ�.\n", DBL_MIN, DBL_MAX);
	printf("long double �ּҰ��� %.3e, �ִ밪�� %.3e �Դϴ�.\n", LDBL_MIN, LDBL_MAX);


	return 0;
}