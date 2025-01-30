package week4;

import java.util.Scanner;

public class encrypt2 {

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
			
			String encrypted = encrypt(arr, lineName, s);
			System.out.println(encrypted);
			
			
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
	
	private static String encrypt(String[] arr, String lineName, String s) {
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			int[] index = findIndex(arr, c);
			
			if (index != null) {
				sb.append(lineName.charAt(index[0]));
				sb.append(lineName.charAt(index[1]));
			} else {
				System.out.println("-ERROR-");
			}
			
			
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
