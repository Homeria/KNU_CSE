package week10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *integers15.txt에서 데이터를 입력받아 2차원 배열(행렬)을 구성한 다음, 구성한 행렬의 전치행렬을 구하는 프로그램.
 * @author 차경호
 */
public class MatrixTranspose  {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("integers15.txt"));
		
		
		int rows = 3;
		int cols = 5;
		int[][] array = new int[rows][cols];
		
		//원래 행렬 생성과 출력
		System.out.println("원래의 행렬");
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				array[i][j] = input.nextInt();
			}
		}
		ArrayUtil.printMatrix(array, rows, cols);
		System.out.println("");
		
		
		//전치행렬 생성과 출력
		System.out.println("전치행렬");
		int[][] transposedArray = transpose(array, rows, cols);
		ArrayUtil.printMatrix(transposedArray, cols, rows);
	}
	
	
	/**
	 * 주어진 행렬의 전치행렬을 구함
	 * @param originalArray 전치행렬을 만들 원래 행렬(배열)
	 * @param rows 행
	 * @param cols 렬
	 * @return 주어진 행렬의 전치행렬
	 */
	public static int[][] transpose(int[][] originalArray, int rows, int cols) {
		int[][] array = new int[cols][rows];
		
		for(int i = 0; i < cols; i++) {
			for(int j = 0; j < rows; j++) {
				array[i][j] = originalArray[j][i];
			}
		}
		return array;
	}
	

}
