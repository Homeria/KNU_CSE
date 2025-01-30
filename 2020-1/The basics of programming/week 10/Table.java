package week10;

import java.util.Scanner;

/**
 * 이차원 배열에 난수를 채운 후 가로 합과 세로 합, 총합을 추가하여 출력하는 프로그램
 * TablePlusArray.java와 다르게 2차원 배열 하나에 원래의 데이터와 가로 합, 세로 합, 총합을 모두 적어 넣는 방식
 * @author 차경호
 */
public class Table {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("행의 수 : ");
		int rows = input.nextInt();
		System.out.print("열의 수 : ");
		int cols = input.nextInt();
		System.out.print("난수의 최댓값 : ");
		int max = input.nextInt();
		
		int[][] table = new int[rows + 1][cols + 1];
		
		System.out.println("");
		
		//초기 table 출력
		System.out.println("초기 배열");
		display(table, rows, cols);
		
		System.out.println("");
		
		//random 메소드 호출
		random(table, rows, cols, max);
		
		//난수가 채워진 table 출력
		System.out.println("난수가 저장된 배열");
		display(table, rows, cols);
		System.out.println("");
		
		//total 메소드 호출
		total(table);
		
		//전체 출력
		System.out.println("가로, 세로 합이 계산된 배열");
		for(int i = 0; i < rows + 1; i++) {
			for(int j = 0; j < cols + 1; j++) {
				System.out.print(table[i][j] + "\t");
			}
			System.out.println("");
		}
		input.close();
		
	}
	
	
	
	/**
	 * 이차원 배열 table의 첫 rows 행, 첫 cols 열에 있는 원소들을 표 형태로 출력
	 * 전제 조건 : row는 table의 행 개수보다 작거나 같고, cols는 table의 열 개수보다 작거나 같다.
	 * @param table 이차원 정수 배열
	 * @param rows 출력할 행 수
	 * @param cols 출력할 열 수
	 */
	public static void display(int[][] table, int rows, int cols) {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				System.out.print(table[i][j] + "\t");
			}
			System.out.println("");
		}
	}
	
	
	/**
	 * 2차원 배열 table의 전부 혹은 일부에 난수를 채운다.
	 * 난수는 0 이상, max 이하 정수이어야 한다.
	 * 전제 조건 : rows는 table의 행 개수보다 작거나 같고, cols는 table의 열 개수보다 작거나 같아야 한다.
	 * @param table 배열
	 * @param rows 난수를 채울 행 개수
	 * @param cols 난수를 채울 열 개수
	 * @param max 난수의 최대값
	 */
	public static void random(int[][] table, int rows, int cols, int max) {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				table[i][j] = (int)(Math.random() * max);
			}
		}
	}
	
	
	/**
	 * 2차원 배열 table의 마지막 ㅎ행과 마지막 열에 세로합과 가로합을 채운다.
	 * a의 마지막 행과 마지막 열을 제외한 나머지 셀들에 데이터가 들어 있다.
	 * @param table 2차원 배열
	 */
	public static void total(int[][] table) {
		
		//가로 합 계산
		for(int i = 0; i < table.length - 1; i++) {
			for(int j = 0; j < table[0].length - 1; j++) {
				table[i][table[0].length-1] += table[i][j];
			}
		}
		
		//세로 합 계산
		for(int i = 0; i < table[0].length - 1; i++) {
			for(int j = 0; j < table.length - 1; j++) {
				table[table.length-1][i] += table[j][i];
			}
		}
		
		//total 계산
		for(int i = 0; i < table.length - 1; i++) {
			table[table.length - 1][table[0].length - 1] += table[i][table[0].length - 1]; 
		}
		
	}

}
