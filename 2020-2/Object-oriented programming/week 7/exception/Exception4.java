package w7.exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exception4 {

	public static void main(String[] args) throws FileNotFoundException {
		readFileTest();
	}

	static void readFileTest() throws FileNotFoundException {
		String fileName = "data.txt";
		readFile(fileName);
	}

	static void readFile(String fileName) throws FileNotFoundException {
		// Scanner 구성자는 FileNotFoundException을 던지는 수가 있음!
		// FileNotFoundException은 checked exception임.
		Scanner in = new Scanner(new File(fileName));
		while (in.hasNextLine())
			System.out.println(in.nextLine());
		in.close();
	}
}

