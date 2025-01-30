package week11;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("./src/11ÁÖÂ÷_input_sample.txt");
		
		cRecord record = new cRecord(file);
		System.out.println("===== Original =====");
		System.out.println("GRADE\tPENALTY\tNAME");
		record.printArray();
		System.out.println();
		record.sort();
		
	}

}
