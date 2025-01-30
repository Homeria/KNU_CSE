package week9;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		HashTable<String, String> hashtable = new HashTable<String, String>();
		
		boolean done = false;
		String str = null;
		
		while (!done) {
			System.out.println("==============================");
			System.out.print("Enter the key : ");
			str = input.next();
			System.out.println("Entered value is \"" + str + "\"");
			System.out.println("------------------------------");
			if (str.equals("QUIT")) {
				System.out.println("Exit.");
				done = true;
			} else {
				if (hashtable.isExist(str)) {
					System.out.println("Entered value exist in HashTable. Try again.");
				} else {
					System.out.println("Entered value not exist in HashTable. add this value in HashTable.");
					hashtable.add(str);
				}
			}
		}
		
		System.out.println("==============================");
		System.out.println("HashTable Situation");
		hashtable.printEntry();
		
		input.close();
		
	}

}
