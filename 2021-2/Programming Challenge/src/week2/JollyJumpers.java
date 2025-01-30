package week2;

import java.util.Scanner;

public class JollyJumpers {
	
	public static final int MAX_N = 3000;
	

	public static void main(String[] args) {
		
		if (isJolly()) {
			System.out.println("Jolly");
		} else {
			System.out.println("Not jolly");
		}
		
	}
	
	private static boolean isJolly() {
		
		Scanner input = new Scanner(System.in);
		int size = input.nextInt();
		int[] arr = new int[size];
		int[] present = new int[size - 1];
		int index;
		
		
		for(int i = 0; i < size; i++) {
			arr[i] = input.nextInt();
		}
		
		input.close();
		printArray(arr);
		
		for(int i = 0; i < size - 1; i++) {
			index = Math.abs(arr[i] - arr[i + 1]) - 1;
			System.out.println("index = " + index);
			if (index >= size - 1) {
				return false;
			} else {
				present[index]++;
			}
		}
		printArray(present);
		
		for(int i : present) {
			if (i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	private static void printArray(int[] arr) {
		for(int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}
	

}
