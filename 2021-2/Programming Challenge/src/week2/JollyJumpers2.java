package week2;

import java.util.Scanner;

public class JollyJumpers2 {
	
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
		int[] present = new int[size - 1];
		int index;
		int previous;
		int now = 0;
		
		for(int i = 0; i < size - 1; i++) {
			
			if (i == 0) {
				previous = input.nextInt();
				now = input.nextInt();
			} else {
				previous = now;
				now = input.nextInt();
			}
			
			index = Math.abs(now - previous) - 1;
			
			if ((index >= size - 1) || (present[index] != 0)) {
				return false;
			} else {
				present[index]++;
			}
		}
		
		for(int i : present) {
			if (i == 0) {
				return false;
			}
		}
		
		return true;
	}
	

}
