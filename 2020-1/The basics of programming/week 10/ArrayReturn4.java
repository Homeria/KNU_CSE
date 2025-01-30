package week10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * data3.txt와 data4.txt에서 데이터를 각각 입력받아 배열을 구성하고, 이 배열을 연결하는 프로그램
 * data3.txt와 data4.txt에서 데이터를 처음 입력받을 때는 배열의 크기를 입력받고, 이후에 데이터를 입력받음
 * @author 차경호
 */
public class ArrayReturn4 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input1 = new Scanner(new File("data3.txt"));
		Scanner input2 = new Scanner(new File("data4.txt"));
		
		int a1Len = input1.nextInt();
		int a2Len = input2.nextInt();
		int[] a1 = new int[a1Len];
		int[] a2 = new int[a2Len];
		int[] a3 = new int[a1Len + a2Len];
		
		
		//배열 1
		System.out.print("배열 1 : \t");
		for(int i = 0; i < a1.length; i++) {
			a1[i] = input1.nextInt();
			System.out.print("\t" + a1[i]);
		}
		System.out.println("");
		

		
		//배열 2
		System.out.print("배열 2 : \t");
		for(int i = 0; i < a2.length; i++) {
			a2[i] = input2.nextInt();
			System.out.print("\t" + a2[i]);
		}
		System.out.println("");
		
		
		//배열 3
		System.out.print("연결된 배열 : \t");
		a3 = catArrays(a1, a2);
		for(int i = 0; i < a3.length; i++) {
			System.out.print(a3[i] + "\t");
			
		}
	}
	
	
	
	/**
	 * 배열 a1과 a2를 연결한 새 배열을 반환한다.
	 * 만약 a1에 1 2 3이 들어 있고 (a1의 크기는 3)
	 * a2에 5 6이 들어 있다면 (a2의 크기는 2)
	 * 이 둘을 연결한 새 배열에는 1 2 3 4 5가 들어 있으며
	 * 새 배열의 크기는 5이다
	 * a1과 a2는 변경되지 않는다.
	 * @param a1 배열
	 * @param a2 배열
	 * @return a1과 a2를 연결한 새 배열 (정확히는, 새 배열을 가리키는 참조)
	 */
	public static int[] catArrays(int[] a1, int[] a2) {
		int[] a3 = new int[a1.length + a2.length];
		for(int i = 0; i < a1.length; i++) {
			a3[i] = a1[i];
		}
		for(int i  = 0; i < a2.length; i++) {
			a3[a1.length + i] = a2[i];
		}
		return a3;
	}
	

}
