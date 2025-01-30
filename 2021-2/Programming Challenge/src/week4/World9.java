package week4;

import java.util.*;

public class World9 {

	public static void main(String[] args) {

		String[] testSArr = {
				"abcDEFheemo",
				"hEbkWalDork",
				"TteAmaldORm",
				"etoimrLgsrc",
				"emomrbedeyv",
				"mlebewikomk",
				"ytrEEeadhrb",
				"yUiqtxtnBjf"};
		
		String[] testSArr2 = {
				"abcDEFGhigg",
				"hEbkWalDork",
				"FteAmaldORm",
				"FtsimrLgsrc",
				"bmoArbedeyv",
				"Klebqwikomk",
				"strEEGadhrb",
				"yUiqtxcnBjf"};
		
		Scanner input = new Scanner(System.in);

		int caseN = Integer.parseInt(input.nextLine());

		for (int i = 0; i < caseN; i++) {
			
			input.nextLine();
			
			String[] tmp = input.nextLine().split(" ");

			int col = Integer.parseInt(tmp[0]);
			int row = Integer.parseInt(tmp[1]);

			
			
//			if ((col > 0) && (row > 0)) {
//				String[] sArr = new String[col];
//
//				for (int j = 0; j < col; j++) {
//					sArr[j] = input.nextLine();
//				}
//				find_match(sArr, row, col);
//			}
			
			find_match(testSArr, row, col);

			

		}

		input.close();
	}

	private static String[][] makeMatrix(String[] arr, int row, int col) {
		String[][] s = new String[col][row];

		for (int i = 0; i < arr.length; i++) {
			s[i] = arr[i].split("");
		}
		return s;

	}

	private static boolean find_match(String[] arr, int row, int col) {

		String[][] matrix = makeMatrix(arr, row, col);
		
		boolean a = find_match_horizental(matrix);
		boolean b = find_match_vertical(matrix);
		boolean c = find_match_diagonal(matrix);
		printMatrix(matrix);
		System.out.println("");
		return (a || b || c);
	}

	private static boolean judgeTeemo(String target) {
		
		if(target.length() < 5) {
			return false;
		}

		String s1 = "TEEMO";
		String s2 = "OMEET";

		int count = 0;

		String targetUpper = target.toUpperCase();

		for (int i = 0; i < targetUpper.length(); i++) {
			if (targetUpper.charAt(i) == s1.charAt(i)) {
				count++;
			}
		}

		if (count >= 4) {
			System.out.println("pass : " + targetUpper);
			return true;
		} else {
			count = 0;
			for (int i = 0; i < targetUpper.length(); i++) {
				if (targetUpper.charAt(i) == s2.charAt(i)) {

					count++;
				}
			}
			if (count >= 4) {
				System.out.println("pass : " + targetUpper);
				return true;
			} else {
				return false;

			}
		}
	}

	private static boolean find_match_horizental(String[][] arr) {
		boolean done = false;
		StringBuilder sb;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; (j + 5) <= arr[i].length; j++) {
				sb = new StringBuilder();
				for (int k = j; k <= j + 4; k++) {
					sb.append(arr[i][k]);
				}
				
				String target = sb.toString();
				
				if (judgeTeemo(target)) {
					for (int k = j; k <= j + 4; k++) {
						arr[i][k] = "#";
					}
					done = true;
				}
			}
		}
		return done;
	}

	private static boolean find_match_vertical(String[][] arr) {

		StringBuilder sb;
		boolean done = false;

		for (int i = 0; i < arr[0].length; i++) {
			for (int j = 0; (j + 5) <= arr.length; j++) {
				sb = new StringBuilder();
				for (int k = j; k <= j + 4; k++) {
					sb.append(arr[k][i]);
				}
				String target = sb.toString();
				if (judgeTeemo(target)) {
					for (int k = j; k <= j + 4; k++) {
						arr[k][i] = "#";
					}
					done = true;
				}
			}
		}

		return done;
	}

	private static boolean find_match_diagonal(String[][] arr) {

		StringBuilder sb;

		boolean done = false;

		for (int i = 0; (i + 4) <= arr.length - 1; i++) {

			for (int j = 0; (j + 4) <= arr[i].length - 1; j++) {
				sb = new StringBuilder();
				for (int p = 0; p < 5; p++) {
					sb.append(arr[i + p][j + p]);
				}
				String target = sb.toString();
				if (judgeTeemo(target)) {
					for (int p = 0; p < 5; p++) {
						arr[i + p][j + p] = "#";
					}
					done = true;
				}
			}
		}

		for (int i = arr.length - 1; (i - 4) >= 0; i--) {

			for (int j = 0; (j + 4) <= arr[i].length - 1; j++) {

				sb = new StringBuilder();

				for (int p = 0; p < 5; p++) {
					sb.append(arr[i - p][j + p]);
				}
				String target = sb.toString();

				if (judgeTeemo(target)) {
					for (int p = 0; p < 5; p++) {
						arr[i - p][j + p] = "#";
					}
					done = true;
				}

			}

		}

		return done;
	}

	private static void printMatrix(String[][] s) {
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s[0].length; j++) {
				System.out.print(s[i][j]);
			}
			System.out.println("");
		}
	}

}
