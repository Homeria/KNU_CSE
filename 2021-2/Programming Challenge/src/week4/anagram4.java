package week4;

import java.util.Scanner;

public class anagram4 {

	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String s1 = input.next();
		String s2 = input.next();
		
		String[] s1Arr = s1.split("");
		String[] s2Arr = s2.split("");
		
		for(int i = 0; i < s1Arr.length; i++) {
			for(int j = 0; j < s2Arr.length; j++) {
				if (s1Arr[i].equals(s2Arr[j])) {
					s1Arr[i] = "#";
					s2Arr[j] = "#";
					break;
				}
			}
		}
		
		int count = 0;
		
		for(int i = 0; i < s1Arr.length; i++) {
			if (!s1Arr[i].equals("#")) {
				count++;
			}
		}
		
		for(int i = 0; i < s2Arr.length; i++) {
			if (!s2Arr[i].equals("#")) {
				count++;
			}
		}
		
		System.out.println(count);
		
		
		input.close();
		
	}
	
	
	private static void printArray(String[] s) {
		for(String target : s) {
			System.out.print(target + " ");
		}
		System.out.println();
	}

}
