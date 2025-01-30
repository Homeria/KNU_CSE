package week4;

import java.util.Scanner;

public class encrypt3 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String[] arr = new String[6];
		
//		String lineName = input.next();
		String lineName = "ADFGVX";
		
//		String statement = input.next();
		String statement = "qw0ert1yu23iop4as56dfg7hjk81zxc9vbnm";
		
		separation(arr, statement);
		
		printArray(arr);
		
		while(input.hasNextLine()) {
			String s = input.nextLine();
			
			String encrypted = decrypt(arr, lineName, s);
			if (encrypted == null) {
				System.out.println("-ERROR-");
			} else {
				System.out.println(encrypted);
			}
			
			
		}
		
		input.close();
		
		
	}
	
	private static void separation(String[] arr, String s) {
		
		int index = 0;
		
		for(int i = 0; i < arr.length; i++) {
			
			arr[i] = s.substring(index, index + 6).toLowerCase();
			index += 6;
		}
	}
	
	private static String decrypt(String[] arr, String lineName, String s) {
		
		StringBuilder sb = new StringBuilder();
		
		int index = 0;
		int x = -1;
		int y = -1;;
		
		for(int i = 0; i < (s.length() / 2); i++) {
			
			System.out.println("===========");
			x = -1;
			y = -1;
			char c1 = s.charAt(index);
			char c2 = s.charAt(index + 1);
			
			for(int j = 0; j < lineName.length(); j++) {
				System.out.println("c1 = " + c1);
				System.out.println("c2 = " + c2);
				System.out.println("lineName.charAt(" + j + ") : " + lineName.charAt(j));
				if (c1 == lineName.charAt(j)) {
					x = j;
				}
				if (c2 == lineName.charAt(j)) {
					y = j;
				}
			}
			
			System.out.println("x = " + x + ", y = " + y);
			
			if ((x == -1) || (y == -1)) {
				System.out.println("-ERROR-");
				return null;
			} else {
				sb.append(arr[x].charAt(y));
				
			}
			index += 2;
		}
		
		return sb.toString();
		
		
	}
	
	private static int[] findIndex(String[] arr, char c) {
		
		int[] index = new int[2];
		
		for(int i = 0; i < arr.length; i++) {
			String s = arr[i];
			for(int j = 0; j < s.length(); j++) {
				if (c == s.charAt(j)) {
					index[0] = i;
					index[1] = j;
					return index;
				}
			}
		}
		
		return null;
	}
	
	private static void printArray(String[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
