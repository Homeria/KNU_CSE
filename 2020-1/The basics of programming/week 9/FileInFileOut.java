package week9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

/**
 * integers.txt 파일에서 데이터를 배열형태로 입력받고, 입력받은 순서의 역순의 출력을 reversedIntegers.txt 파일에 저장하는 프로그램.
 * 실행 후 reversedIntegers.txt 파일이 보이지 않는다면 프로젝트 클릭 후 F5번이나 프로젝트를 오른쪽 클릭하여 Refresh를 클릭.
 * @author 차경호
 */
public class FileInFileOut {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner input = new Scanner(new File("integers.txt"));
		PrintWriter output = new PrintWriter("reversedIntegrs.txt");
		int[] numbers = new int[10];
		
		for(int i = 0; i < 10; i++) {
			numbers[i] = input.nextInt();
		}
		
		for(int i = 9; i >= 0; i--) {
			output.print(numbers[i] + " ");
		}
		
		input.close();
		output.close();
		
		
	}

}
