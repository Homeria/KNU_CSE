package week9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * integers.txt 파일에서 데이터를 배열로 입력받고, 입력받은 순서의 역순으로 출력하는 프로그램
 * @author 차경호
 */
public class FileInput {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner input = new Scanner(new File("integers.txt"));
		int[] numbers = new int[10];
		
		for(int i = 0; i < 10; i++) {
			numbers[i] = input.nextInt();
		}
		
		System.out.println("배열을 역순으로 출력 : ");
		for(int i = 9; i >= 0; i--) {
			System.out.print(numbers[i] + " ");
		}
		
		input.close();
		
	}

}
