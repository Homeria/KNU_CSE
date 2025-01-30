#include <stdio.h>

void print_2Darr(int firstRows, int firstCols, int secondRows, int secondCols);
void multi_2Darr(int firstRows, int firstCols, int secondRows, int secondCols);

int first_Matrix_Rows, first_Matrix_Columns, second_Matrix_Rows, second_Matrix_Columns;
int first_Matrix[100][100];
int second_Matrix[100][100];
int matrix[100][100];

int main(void) {

	printf("Multiplication of two Matrices\n");
	printf("------------------------------------------\n");

	printf("Input the rows of first matrix : ");
	scanf_s("%d", &first_Matrix_Rows);
	printf("Input the columns of first matrix : ");
	scanf_s("%d", &first_Matrix_Columns);

	printf("Input the rows of second matrix : ");
	scanf_s("%d", &second_Matrix_Rows);
	printf("Input the columns of second matrix : ");
	scanf_s("%d", &second_Matrix_Columns);

	
	if (first_Matrix_Rows == second_Matrix_Columns) {
		multi_2Darr(first_Matrix_Rows, first_Matrix_Columns, second_Matrix_Rows, second_Matrix_Columns);
		print_2Darr(first_Matrix_Rows, first_Matrix_Columns, second_Matrix_Rows, second_Matrix_Columns);

	}
	else {
		printf("Multiplication of Matrix is not possible.\n");
		printf("row of first matrix and column of seocnd matrix must be same.\n");
	}

	return 0;

}


void print_2Darr(int firstRows, int firstCols, int secondRows, int secondCols) {

	printf("The First matrix is : \n");
	for (int i = 0; i < firstRows; i++) {
		for (int j = 0; j < firstCols; j++) {
			printf("%d\t", first_Matrix[i][j]);
		}
		printf("\n");
	}

	printf("\n");

	printf("The Second matrix is : \n");
	for (int i = 0; i < secondRows; i++) {
		for (int j = 0; j < secondCols; j++) {
			printf("%d\t", second_Matrix[i][j]);
		}
		printf("\n");
	}

	printf("\n");

	printf("The Multiplication of two matrices is :\n");
	for (int i = 0; i < firstRows; i++) {
		for (int j = 0; j < secondCols; j++) {
			printf("%d\t", matrix[i][j]);
		}
		printf("\n");
	}
}

void multi_2Darr(int firstRows, int firstCols, int secondRows, int secondCols) {
	int value;

	printf("Input elements in the first matrix : \n");
	for (int i = 0; i < firstRows; i++) {
		for (int j = 0; j < firstCols; j++) {
			printf("elemenet - [%d],[%d] : ", i, j);
			scanf_s("%d", &value);
			first_Matrix[i][j] = value;
		}
	}

	printf("Input elements in the second matrix : \n");
	for (int i = 0; i < secondRows; i++) {
		for (int j = 0; j < secondCols; j++) {
			printf("elemenet - [%d],[%d] : ", i, j);
			scanf_s("%d", &value);
			second_Matrix[i][j] = value;
		}
	}

	printf("\n");

	for (int i = 0; i < firstRows; i++) {
		for (int j = 0; j < secondCols; j++) {
			for (int p = 0; p < firstCols; p++) {
				matrix[i][j] += (first_Matrix[i][p] * second_Matrix[p][j]);
			}
		}
	}
}