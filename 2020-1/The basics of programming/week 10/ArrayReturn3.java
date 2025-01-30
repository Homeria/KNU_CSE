package week10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * data1.txt와 data2.txt에서 데이터를 각각 입력받고, 배열의 원소값을 더하는 프로그램.
 * @author 차경호
 */
public class ArrayReturn3 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input1 = new Scanner(new File("data1.txt"));
		Scanner input2 = new Scanner(new File("data2.txt"));
		
		final int SIZE = 10;
		int[] a1 = new int[SIZE];
		int[] a2 = new int[SIZE];
		int[] a3 = new int[SIZE];
		
		//data1를 통해 a1 배열을 채우고 출력
		System.out.print("배열 1 : \t");
		for(int i = 0; i < a1.length; i++) {
			a1[i] = input1.nextInt();
			System.out.print("\t" + a1[i]);
		}
		System.out.println("");
		
		
		//data2를 통해 a2 배열을 채우고 출력
		System.out.print("배열 2 : \t");
		for(int i = 0; i < a2.length; i++) {
			a2[i] = input2.nextInt();
			System.out.print("\t" + a2[i]);
		}
		System.out.println("");
		
		
		//a3 배열을 구하고 출력
		System.out.print("배열 합 : \t");
		a3 = addArrays(a1, a2);
		for(int i = 0; i < a3.length; i++) {
			System.out.print("\t" + a3[i]);
		}
		
	}
	
	/**
	 * 배열 a1과 a2를 더한다.
	 * 전제조건 : a1과 a2의 크기는 같다
	 * a1, a2와 크기가 같은 새 배열을 구성하고
	 * 이 배열에 a1과 a2를 더한 결과를 저장한 후
	 * 새 배열을 가리키는 참보를 반환한다.
	 * @param a1 배열
	 * @param a2 배열
	 * @return a1 + a2 결과를 저장한 새 배열(정확히는, 새 배열을 가리키는 참조)
	 */
	public static int[] addArrays(int[] a1, int[] a2) {
		int[] a3 = new int[a1.length];
		
		for(int i = 0; i < a3.length; i++) {
			a3[i] = a1[i] + a2[i];
		}
		return a3;
	}

}
