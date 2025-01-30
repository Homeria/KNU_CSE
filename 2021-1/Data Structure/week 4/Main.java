package week4;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

public static void main(String args[]) {
		
		Scanner input = new Scanner(System.in);
		List<String> list = new ArrayList<String>();
		System.out.println("input expression >");
		String a = input.nextLine();
		
		RecursiveEquationParser rep = new RecursiveEquationParser();
		list = rep.parse(a, list);
		
		System.out.print("Final result : ");
		ListIterator<String> iter = list.listIterator();
		while(iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		
		input.close();
	}

}
