package week3;

import java.util.*;

public class restaurant3 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String line;
		String[] token;
		
		while(input.hasNextLine()) {
			
			int cnt = Integer.parseInt(input.nextLine());
			int target = 0;
			
			String[] arr = new String[cnt];
			for(int i = 0; i < arr.length; i++) {
				arr[i] = "#";
			}
			
			System.out.print("setting arr = ");
			printArray(arr);
			
			line = input.nextLine();
			token = line.split(" ");
			System.out.print("token = ");
			printArray(token);
			
			for(int i = 0; i < token.length; i++) {
				System.out.print("before arr = ");
				printArray(arr);
				System.out.println("token[i] = " + token[i]);
				System.out.println("taregt = " + target);
				if (!token[i].equals("*")) {
					System.out.println("success");
					for(int j = 0; j < arr.length; j++) {
						if (arr[j].equals("#")) {
							arr[j] = token[i];
							break;
						}
					}
				} else if (token[i].equals("*")) {
					for(int j = 0; j < arr.length; j++) {
						if (!arr[j].equals("#")) {
							arr[target] = "#";
							if (target == cnt - 1) {
								target = 0;
							} else {
								target++;
							}
							break;
						}
					}
					System.out.println("Fail");
					
				} else {
					System.out.println("Error");
				}
				System.out.print("after arr = ");
				printArray(arr);
				System.out.println("==========================");
			}
			
			System.out.print("arr = ");
			printArray(arr);
		}
		
		
	}
	
	
	private static void printArray(Object[] arr) {
		System.out.print("[");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i != arr.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}

}
