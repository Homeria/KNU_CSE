package week10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Select Sort�� ����Ͽ�����, �̹ۿ� Bubble Sort�� Table�� �����Ǿ� ����.
 * @author ����ȣ
 *
 */
public class Main {

	public static void main(String args[]) throws FileNotFoundException {
		
		Scanner fileInput = new Scanner(new File("case1.txt"));
		Scanner input = new Scanner(System.in);
		int n = 0;
		Table<String> table = new Table<String>(fileInput);
		table.printTable();
		
		boolean done = false;
		
		while(!done) {
			System.out.println("Input command");
			System.out.println("[0] : close | [1] : sort with 1st column | [2] : sort with 2nd column | [3] : sort with 3rd column");
			n = input.nextInt();
			System.out.println();
			
			if(n == 0) {
				System.out.println("End");
				done = true;
			} else if (n == 1) {
				System.out.println("Sort by first column");
				System.out.println("-------------------------------");
				table.selectionSort(n - 1);
				table.printTable(n - 1);
				System.out.println("-------------------------------");
			} else if (n == 2) {
				System.out.println("Sort by second column");
				System.out.println("-------------------------------");
				table.selectionSort(n - 1);
				table.printTable(n - 1);
				System.out.println("-------------------------------");
			} else if (n == 3) {
				System.out.println("Sort by third column");
				System.out.println("-------------------------------");
				table.selectionSort(n - 1);
				table.printTable(n - 1);
				System.out.println("-------------------------------");
			} else {
				System.out.println("[Error] Try again.");
			}
		}
		
		input.close();
	}
	
}
