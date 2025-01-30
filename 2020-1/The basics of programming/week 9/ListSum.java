package week9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * integers.txt 파일로부터 정수 10개를 읽어 배열에 채운 후 원소 갯수에 따른 합을 출력하는 프로그램.
 * @author 차경호
 */
public class ListSum {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner input = new Scanner(new File("integers.txt"));
		int[] numbers = new int[10];
		int sum = 0;
		
		for(int i = 0; i < 10; i++) {
			numbers[i] = input.nextInt();
			sum += numbers[i];
			System.out.println("배열의 첫 " + (i + 1) + "개 원소의 합 : " + sum);
		}
		input.close();
		
		
	}

}
