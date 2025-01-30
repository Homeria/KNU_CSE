package week4;

import java.util.*;

public class World3 {
	
	
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
			
			String[][] matrix = splitArray(newS, row, col);
			
			find_match(newS);
			
		}
		
		input.close();
	}
	
	
	private static String[][] splitArray(String[] arr, int row, int col) {
		String[][] s = new String[row][col];
		
		for(int i = 0; i < arr.length; i++) {
			s[i] = arr[i].split("");
		}
		return s;
		
	}
	
	private static boolean find_match(String[] arr) {
		
		
		find_match_horizental(arr);
		
		return false;
	}
	
	private static boolean judgeTeemo(String target) {
		
		String s = "Teemo";
		
		int count = 0;
		
		for(int i = 0; i < target.length(); i++) {
			if (target.charAt(i) == s.charAt(i)) {
				System.out.println("detected!");
				count++;
			}
		}
		
		if (count >= 4) {
			return true;
		} else {
			return false;
		}
	}
	
	private static boolean find_match_horizental(String[] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			String s2 = arr[i];
			for (int j = 0; (j + 5) <= s2.length(); j++) {
				String target = s2.substring(i, i + 5);
				System.out.print(target + " ");
				if (judgeTeemo(target)) {
					for(int k = i; k <= 5; k++) {
					}
				}
			}
			System.out.println();
		}
		return false;
	}
	
	
	
	private static boolean find_match_vertical(String[] arr) {
		
		StringBuilder sb;
		
		for(int i = 0; i < arr[0].length(); i++) {
			sb = new StringBuilder();
			
			for(int j = 0; j < arr.length; j++) {
				sb.append(arr[j].charAt(i));
			}
			
		}
		
		
		return false;
	}
	
	private static boolean find_match_diagonal(String[] arr, String s, char c, int x, int y, int cnt) {
		
		StringBuilder sb = new StringBuilder();
		
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
