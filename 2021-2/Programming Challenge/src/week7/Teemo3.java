package week7;

import java.util.*;

public class Teemo3 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		//int caseN = Integer.parseInt(input.nextLine());
		int caseN = 6;
		
		//Object[][] arr = new Object[caseN][4];
		
//		for(int i = 0; i < caseN; i++) {
//			
//					
//			String[] line = input.nextLine().split(" ");
//			
//			String[] dateLine = line[1].split("/"); 
//			
//			for(int j = 0; j < dateLine.length; j++) {
//				arr[i][0] = line[0];
//				arr[i][1] = Integer.parseInt(dateLine[0]);
//				arr[i][2] = Integer.parseInt(dateLine[1]);
//				arr[i][3] = Integer.parseInt(dateLine[2]);
//			}
//			
//		}
		
		Object[][] arr = { {"chocochip", 29, 10, 2017}, {"mushrromsoup", 13, 12, 2017}, {"cheesecream", 28, 10, 2017}, {"chocochip", 28, 10, 2017}, {"mushroomsoup", 13, 5, 2017}, {"cheesecream", 28, 11, 2017} };
		
		printMatrix(arr, "arr");
		
		int i, j;
		
		
		// 글자 정렬
		for(i = 1; i < caseN; i++) {
			j = i;
			
			while((j > 0) && (compare((String)arr[j][0], (String)arr[j - 1][0]) == -1)) {
				Object[] tmp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = tmp;
				
				j--;
			}
		}
		printMatrix(arr, "arr");
		
		
		// 년도 정렬
		for(i = 1; i < caseN; i++) {
			j = i;
			while((j > 0) && ((int)arr[j][3] < (int)arr[j - 1][3])
					&& (arr[j][0].equals(arr[j - 1][0]))) {
				Object[] tmp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = tmp;
				j--;
			}
		}
		printMatrix(arr, "arr");
		
		
		// 월 정렬
		for(i = 1; i < caseN; i++) {
			j = i;
			while((j > 0) 
					&& ((int)arr[j][2] < (int)arr[j - 1][2])
					&& (arr[j][0].equals(arr[j - 1][0]))
					&& ((int)arr[j][3] == (int)arr[j - 1][3])) {
				Object[] tmp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = tmp;
				j--;
			}
		}
		printMatrix(arr, "arr");
		
		
		// 일 정렬
		for(i = 1; i < caseN; i++) {
			j = i;
			while((j > 0) 
					&& ((int)arr[j][1] < (int)arr[j - 1][1]) 
					&& (arr[j][0].equals(arr[j - 1][0]))
					&& ((int)arr[j][3] == (int)arr[j - 1][3])
					&& ((int)arr[j][2] == (int)arr[j - 1][2])) {
				Object[] tmp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = tmp;
				j--;
			}
		}
		
		printMatrix(arr, "arr");
		
		
		for(int p = 0; p < arr.length; p++) {
			if (((int)arr[p][3] > 2017)
					|| (((int)arr[p][3] == 2017) && (int)arr[p][2] > 10)
					|| (((int)arr[p][3] == 2017) && (int)arr[p][2] == 10) && ((int)arr[p][1] >= 19)) {
				System.out.println(arr[p][0] + " " + arr[p][1] + "/" + arr[p][2] + "/" + arr[p][3]);
			}
		}
		
		
		
		
		
		
		

	}
	
	public static int compare(String s1, String s2) {
		
		if (s1.equals(s2)) {
			return 0;
		} else {
			
			for(int i = 0; i < s1.length(); i++) {
				if(s1.charAt(i) == s2.charAt(i)) {
					continue;
				} else if (s1.charAt(i) < s2.charAt(i)){
					return -1;
				} else if (s1.charAt(i) > s2.charAt(i)){
					return 1;
				} else {
					return -2;
				}
			}
		}
		return -2;
		
	}
	
	private static void printMatrix(Object[][] arr, String name) {
		
		System.out.println("Matrix : " + name);
		for(int i = 0; i < arr.length; i++) {
			
			System.out.print("[");
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]);
				if (j != arr[i].length - 1) {
					System.out.print(" ");
				}
			}
			System.out.println("]");
		}
		System.out.println();
	}

}
