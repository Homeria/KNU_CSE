package week4;

import java.util.*;

public class World4 {
	
	
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
			
			
			
			
			//find_match(newS);
			
		}
		
		input.close();
	}
	
	
	private static String[][] splitArray(String[] arr, int row, int col) {
		String[][] s = new String[col][row];
		
		for(int i = 0; i < arr.length; i++) {
			s[i] = arr[i].split("");
		}
		return s;
		
	}
	
	private static boolean find_match(String[] arr, int row, int col) {
		
		String[][] matrix = splitArray(arr, row, col);
		printMatrix(matrix);
		
		find_match_horizental(arr);
		find_match_vertical(matrix);
		find_match_diagonal(matrix);
		
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
		
		boolean done = false;
		
		for (int i = 0; i < arr.length; i++) {
			String s2 = arr[i];
			for (int j = 0; (j + 5) <= s2.length(); j++) {
				String target = s2.substring(i, i + 5);
				System.out.print(target + " ");
				if (judgeTeemo(target)) {
					
				}
			}
			System.out.println();
		}
		return false;
	}
	
	
	
	private static boolean find_match_vertical(String[][] arr) {
		
		StringBuilder sb;
		boolean done = false;
		
		for(int i = 0; i < arr[0].length; i++) {
			sb = new StringBuilder();
			for(int j = 0; (j + 5) <= arr.length; j++) {
				for(int k = j; k < j + 4; k++) {
					sb.append(arr[j][i]);
				}
			}
			String target = sb.toString();
			System.out.println("target = " + target);
			if (judgeTeemo(target)) {
				for(int j = 0; j < arr.length; j++) {
					arr[j][i] = "#";
				}
				done = true;
			}
		}
		
		return done;
	}
	
	private static boolean find_match_diagonal(String[][] arr) {
		
		StringBuilder sb;
		
		int index = 0;
		
		
		
		for(int i = 0; (i + 4) <= arr.length; i++) {
			
			sb = new StringBuilder();
			
			for(int j = 0; (j + 4) <= arr[i].length; j++) {
				sb.append(arr[i][i]);
			}
			String target = sb.toString();
			if (judgeTeemo(target)) {
				for(int j = 0; j < 5; j++) {
					
				}
			}
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
	
	private static void printMatrix(String[][] s) {
		System.out.println("==================");
		for(int i = 0; i < s.length; i++) {
			for(int j = 0; j < s[0].length; j++) {
				System.out.print(s[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("==================");
	}

}
