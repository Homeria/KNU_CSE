package week10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 행이 3개, 열이 5개인 2차원 배열에 integers15.txt에 있는 숫자들을 넣고 출력하고,
 * 행이 1개, 열이 10개인 배열에 0 이상 10 미만 정수 난수를 채우고 출력하며,
 * 행이 2개, 열이 3개인 2차원 배열에 0 이상 5 미만의 정수 난수를 채우고 출력하는 프로그램.
 * @author 차경호
 */
public class ArrayUtil {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("integers15.txt"));
		int rows, cols;
		
		
		// P1 - 1
		rows = 3;
		cols = 5;
		int[][] fileInputArray = new int[rows][cols];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				fileInputArray[i][j] = input.nextInt();
			}
		}
		printMatrix(fileInputArray, rows, cols);
		
		
		System.out.println("");
		
		
		//P1 - 2
		rows = 1;
		cols = 10;
		int[][] randomArray = new int[rows][cols];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				randomArray[i][j] = (int)(Math.random() * 10);
			}
		}
		printMatrix(randomArray, rows, cols);
		
		System.out.println("");
		
		
		//P2
		rows = 2;
		cols = 3;
		int[][] r = new int[rows][cols];
		fillMatrixRandom(r, rows, cols, 5);
		printMatrix(r, rows, cols);
		
	}
	
	
	/**
	 * 주어진 배열을 주어진 수만큼 출력함.
	 * 배열의 원소 모두 출력하지 않고, 원소들 중 앞 쪽 일부만을 출력할 수 있음.
	 * 전제조건 : n <= array.length
	 * @param array 출력할 배열을 가리키는 참조변수.
	 * @param n 배열의 원소를 몇 개 출력할 것인가?
	 */
	public static void printArray(int[] array, int n) {
		int i;
		for(i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
			if(i == (array.length - 1)) {
				System.out.println("");
			}
		}
	}
	
	
	/**
	 * 주어진 이차원 배열의 원소를 차례로 출력함.
	 * @param array 출력할 배열을 가리키는 참조변수
	 * @param rows 출력할 배열의 행 수
	 * @param cols 출력할 배열의 열 수
	 */
	public static void printMatrix(int[][] array, int rows, int cols) {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				System.out.print(array[i][j] + "\t");
			}
			System.out.println("");
		}
	}
	
	
	/**
	 * 이차원 배열에 0이상이고 파라미터로 주어진 정수 미만인 정수 난수를 채워줌.
	 * @param array 정수 난수를 채울 배열을 가리키는 참조변수
	 * @param rows 정수 난수를 채울 배열의 행 수
	 * @param cols 정수 난수를 채울 배열의 열 수
	 * @param num 정수의 범위를 정해주는 수
	 * @return 정수 난수를 채운 배열
	 */
	public static int[][] fillMatrixRandom(int[][] array, int rows, int cols, int num) {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				array[i][j] = (int)(Math.random() * num);
			}
		}
		return array;
	}
	

}
