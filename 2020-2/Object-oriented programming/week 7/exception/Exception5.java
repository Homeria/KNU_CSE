package w7.exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exception5 {

	public static void main(String[] args) {
		readFileTest();
		System.out.println("메인 메소드가 끝납니다.");
	}

	static void readFileTest() {
		String fileName = "data.txt";
		try {
			readFile(fileName);
		}
		catch(FileNotFoundException e) {
			System.out.println("그런 파일이 없습니다.");
		}
	}

	static void readFile(String fileName) throws FileNotFoundException {
		Scanner in = new Scanner(new File(fileName));
		while (in.hasNextLine())
			System.out.println(in.nextLine());
		in.close();
	}
}

