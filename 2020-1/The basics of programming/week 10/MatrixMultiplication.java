package week10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * matrix1.txt와 matrix2.txt에서 각각 데이터를 이차원 배열 형태로 입력받고, 두 행렬의 곱을 구하는 프로그램 
 * @author 차경호
 */
public class MatrixMultiplication {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input1 = new Scanner(new File("matrix1.txt"));
		Scanner input2 = new Scanner(new File("matrix2.txt"));
		
		int[][] array1 = new int[3][5];
		int[][] array2 = new int[5][3];
		int[][] array3 = new int[3][3];
		
		
		System.out.println("A 행렬");
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 5; j++) {
				array1[i][j] = input1.nextInt();
				System.out.print(array1[i][j] + "\t");
			}
			System.out.println("");
		}
		System.out.println("");
		
		
		System.out.println("B 행렬");
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 3; j++) {
				array2[i][j] = input2.nextInt();
				System.out.print(array2[i][j] + "\t");
			}
			System.out.println("");
		}
		System.out.println("");
		
		
		System.out.println("C = AB 행렬");
		array3 = multiply(array1, array1.length, array1[0].length, array2, array2[0].length);
		ArrayUtil.printMatrix(array3, 3, 3);
		
		
	}
	
	
	/**
	 * 주어진 두 정수 행렬의 곱행렬을 구한다W
	 * 전제조건 : 첫 행렬의 열 갯수와 두 번째 행렬의 행 갯수는 같아야 한다.
	 * @param a 첫 행렬
	 * @param m a 행렬의 행 갯수
	 * @param n a 행렬의 열 갯수
	 * @param b 두 번재 행렬
	 * @param p b 행렬의 행 갯수
	 * @param q b 행렬의 열 갯수
	 * @return 주어진 두 행렬의 곱을 나타내는 행렬(배열)
	 */
	public static int[][] multiply(int[][] a, int m, int n, int[][] b, int q) {
		//m = 3, n = 5, q = 3
		int[][] array = new int[m][q];
		
		for(int i = 0; i < m; i++) {
			Arrays.fill(array[i], 0);
		}
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < q; j++) {
				for(int c = 0; c < n; c++) {
						array[i][j] += a[i][c] * b[c][j];
				}
			}
		}
		return array;
	}

}
