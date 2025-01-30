package week11;

import java.util.Scanner;

public class InsertionSort {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("데이터 개수는? ");
		int num = input.nextInt();
		input.close();
		int[] array = ArrayUtil.makeRandomArray(num, num);
		
		System.out.print("원 배열 : ");
		ArrayUtil.printArray(array, num);
		
		sort(array, num);
		System.out.print("정렬된 배열 : ");
		ArrayUtil.printArray(array, num);
		
	}
	
	
	/**
	 * x[0], x[1], ..., x[i-1]가 이미 오름차순으로 정렬되어 있는 상태에서
	 * x[i]를 그 앞의 올바른 위치에 삽입하여
	 * x[0], x[1], ..., [xi]가 오름차순으로 정렬되도록 한다.
	 * 전제조건 : x[0], x[1], ..., x[i-1]는 이미 오름차순으로 정렬되어 있다.
	 * 			i는 배열 x의 크기보다 작다.
	 * @param x 배열
	 * @param i 올바른 위치를 찾아줄 원소의 인덱스
	 */
	public static void insert(int[] x, int i) {
		int temp = x[i];
		int j = i - 1;
		
		while((j >= 0) && temp < x[j]) {
			x[j + 1] = x[j];
			j -= 1;
		}
		x[j + 1] = temp;
	}
	
	
	/**
	 * 배열 x를 정렬한다.
	 * x[0], x[1], ..., x[n-1]을 정렬된 상태로 만든다.
	 * @param x 배열
	 * @param n 정렬할 원소의 개수
	 */
	public static void sort(int[] x, int n) {
		for(int i = 1; i < n; i++) {
			insert(x, i);
		}
	}

}
