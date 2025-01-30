package week3;

import java.util.*;

public class CryptKicker {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Input String Array Size : ");
		int size = input.nextInt();
		
		String[] arr = new String[size];
		
		for(int i = 0; i < size; i++) {
			System.out.print("[" + (i + 1) + "] : ");
			arr[i] = input.next();
		}
		
		printArray(arr);
		
		input.close();
		
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
	
	
	private static void printList(List<Object> list) {
		System.out.println("[");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			if (i != list.size() - 1) {
				System.out.println(", ");
			}
		}
		System.out.println("]");
	}
	
}
