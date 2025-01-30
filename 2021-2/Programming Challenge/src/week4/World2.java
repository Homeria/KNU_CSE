package week4;

import java.util.*;

public class World2 {
	
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int x = -1;
		int y = -1;

		
		System.out.print("input case count : ");
		int caseN = Integer.parseInt(input.nextLine());
		
		for(int i = 0; i < caseN; i++) {
			input.nextLine();
			
			System.out.print("input row and col : ");
			String[] tmp = input.nextLine().split(" ");
			
			int col = Integer.parseInt(tmp[0]);
			int row = Integer.parseInt(tmp[1]);
			
			String[] sArr = new String[col];
			
//			for(int j = 0; j < col; j++) {
//				System.out.print("input " + (j + 1) + "th word : ");
//				sArr[j] = input.next();
//			}
			
			String[] testSArr = {"abcDEFGhigg", "hEbkWalDork", "FteAmaldORm", "FtsimrLgsrc", "bmoArbedeyv", "Klebqwikomk", "strEEGadhrb", "yUiqtxcnBjf"};
			
			
			printArray(testSArr);
			
			System.out.println("Get UpperCase");
			String[] newS = arrayToUpperCase(testSArr);
			printArray(newS);
			
			
			System.out.print("input word count to find in array : ");
			int wordN = input.nextInt();
			
			for(int j = 0; j < wordN; j++) {
				System.out.print("input word to find in array : ");
				String s = input.next();
				boolean detected = find_match(newS, s.toUpperCase());
				if (detected) {
					System.out.println("detected!");
				}
				
			}
		}
		
		input.close();
	}
	
	private static boolean find_match(String[] arr, String s) {
		System.out.println("===================");
		System.out.println("s = " + s);
		
		int count = 0;
		boolean done = false;
		
		for(int i = 0; i < arr.length; i++) {
			String tmp = arr[i];
			for(int j = 0; j < tmp.length(); j++) {
				if (s.charAt(0) == tmp.charAt(j)) {
					
					if (find_match_horizental(arr, s, i, j)) {
						return true;
					}
					
				}
			}
		}
		System.out.println("Not Detected Word!");
		return false;
	}
	
	private static boolean find_match_horizental(String[] arr, String s, int x, int y) {
		
		StringBuilder sb = new StringBuilder();
		
		String left = null;
		String right = null;
		
		if (((x + s.length() - 1) > arr[0].length()) && ((x - s.length() + 1) < 0)) {
			return false;
		} else {
			if ((x + s.length() - 1) > arr[0].length()) {
				left = arr[y].substring(x - s.length() + 1, x + 1);
				System.out.println("left = " + left);
			} else if ((x - s.length() + 1) > arr[0].length()) {
				right = arr[y].substring(x , x + s.length());
				System.out.println("right = " + right);
			} else {
				left = arr[y].substring(x - s.length() + 1, x + 1);
				right = arr[y].substring(x , x + s.length());
				System.out.println("left = " + left);
				System.out.println("right = " + right);
			}
		}
		
		if ((left.equals(s)) || right.equals(s)) {
			return true;
		} else {
			return false;
		}
	}
	
	private static boolean find_match_vertical() {
		
		return false;
	}
	
	private static boolean find_match_diagonal(String[] arr, String s, char c, int x, int y, int cnt) {
		
		StringBuilder sb = new StringBuilder();
		
		if (true) {
			
		}
		
		
		return false;
	}
	
	
	private static String[] arrayToUpperCase(String[] s) {
		String[] newS = new String[s.length];
		for(int i = 0; i < s.length; i++) {
			newS[i] = s[i].toUpperCase();
		}
		return newS;
	}
	
	private static void printArray(String[] s) {
		System.out.println("==================");
		for(int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
		System.out.println("==================");
	}

}
