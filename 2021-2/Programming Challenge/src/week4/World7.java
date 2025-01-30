package week4;

import java.util.*;

public class World7 {
	
	
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
			
			find_match(testSArr, row, col);
			
			
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
		
		//find_match_horizental(matrix);
		//find_match_vertical(matrix);
		find_match_diagonal(matrix);
		printMatrix(matrix);
		return false;
	}
	
	private static boolean judgeTeemo(String target) {
		
		String s1 = "TEEMO";
		String s2 = "OMEET";
		
		System.out.println("judgeTeemo Target : " + target);
		
		int count = 0;
		
		String targetUpper = target.toUpperCase();
		
		for(int i = 0; i < targetUpper.length(); i++) {
			if (targetUpper.charAt(i) == s1.charAt(i)) {
				count++;
			}
		}
		
		if (count >= 4) {
			System.out.println("detected!");
			return true;
		} else {
			count = 0;
			for(int i = 0; i < targetUpper.length(); i++) {
				if (targetUpper.charAt(i) == s2.charAt(i)) {
					
					count++;
				}
			}
			if (count >= 4) {
				System.out.println("detected!");
				return true;
			} else {
				System.out.println("No detected");
				return false;
				
			}
		}
	}
	
	private static boolean find_match_horizental(String[][] arr) {
		
		System.out.println("find_match_horizental start =======================");
		boolean done = false;
		StringBuilder sb;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; (j + 5) <= arr[i].length; j++) {
				sb = new StringBuilder();
				for(int k = j; k <= j + 4; k++) {
					System.out.println("arr[" + i + "][" + k + "] = " + arr[i][k]);
					sb.append(arr[i][k]);
				}
				String target = sb.toString();
				System.out.println("target = " + target);
				
				if (judgeTeemo(target)) {
					for(int k = j; k <= j + 4; k++) {
						arr[i][k] = "#";
					}
					done = true;
				}
			}
		}
		System.out.println("find_match_horizental end ======================================");
		return done;
	}
	
	
	
	private static boolean find_match_vertical(String[][] arr) {
		
		System.out.println("find_match_vertical start =======================");
		StringBuilder sb;
		boolean done = false;
		
		for(int i = 0; i < arr[0].length; i++) {
			for(int j = 0; (j + 5) <= arr.length; j++) {
				sb = new StringBuilder();
				for(int k = j; k <= j + 4; k++) {
					System.out.println("arr[" + k + "][" + i + "] = " + arr[k][i]);
					sb.append(arr[k][i]);
				}
				String target = sb.toString();
				System.out.println("target = " + target);
				if (judgeTeemo(target)) {
					for(int k = j; k <= j + 4; k++) {
						arr[k][i] = "#";
					}
					done = true;
				}
			}
		}
		System.out.println("find_match_vertical end ======================================");
		
		return done;
	}
	
	private static boolean find_match_diagonal(String[][] arr) {
		
		System.out.println("find_match_diagonal start =======================");
		
		StringBuilder sb;
		
		boolean done = false;
		
		for(int i = 0; (i + 4) <= arr.length - 1; i++) {
				
			for(int j = 0; (j + 4) <= arr[i].length - 1; j++) {
				sb = new StringBuilder();
				for(int p = 0; p < 5; p++) {
					System.out.println("i = " + i + ", j = " + j + ", p = " + p);
					sb.append(arr[i + p][j + p]);
				}
				String target = sb.toString();
				System.out.println("target = " + target);
				
				if (judgeTeemo(target)) {
					for(int p = 0; p < 5; p++) {
						arr[i + p][j + p] = "#";
					}
					done = true;
				}
				
			}
			System.out.println("----");
		}
		
		
		
		
		
		System.out.println("find_match_diagonal end ======================================");
		
		return done;
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
				System.out.print(s[i][j]);
			}
			System.out.println("");
		}
		System.out.println("==================");
	}

}
