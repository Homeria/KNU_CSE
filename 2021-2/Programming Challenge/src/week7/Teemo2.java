package week7;

import java.util.*;

public class Teemo2 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		//int caseN = Integer.parseInt(input.nextLine());
		int caseN = 6;
		
		//String[] name = new String[caseN];
		
		//int[][] date = new int[caseN][3];
		
//		for(int i = 0; i < caseN; i++) {
//			
//					
//			String[] line = input.nextLine().split(" ");
//			
//			String[] dateLine = line[1].split("/"); 
//			
//			name[i] = line[0];
//			for(int j = 0; j < dateLine.length; j++) {
//				date[i][j] = Integer.parseInt(dateLine[j]);
//			}
//			
//		}
		
		Object[] test = {"test", 1, 2, 3};
		
		
		String[] name = {"chocochip", "mushroomsoup", "cheesecream", "chocochip", "mushroomsoup", "cheesecream"};
		int[][] date = { {29, 10, 2017}, {13,12,2017}, {28,10,2017}, {28,10,2017}, {13,5,2017}, {28,11,2017} };
		
		
		printArray(name);
		printMatrix(date, "date");
		
		
		int i, j;
		
		for(i = 1; i < caseN; i++) {
			j = i;
			while((j > 0) && (date[j][2] < date[j - 1][2])) {
				int[] tmp = date[j];
				date[j] = date[j - 1];
				date[j - 1] = tmp;
				
				String tmp2 = name[j];
				name[j] = name[j - 1];
				name[j - 1] = tmp2;
				j--;
			}
		}
		
		
		for(i = 1; i < caseN; i++) {
			j = i;
			while((j > 0) && (date[j][2] < date[j - 1][2])) {
				int[] tmp = date[j];
				date[j] = date[j - 1];
				date[j - 1] = tmp;
				
				String tmp2 = name[j];
				name[j] = name[j - 1];
				name[j - 1] = tmp2;
				j--;
			}
		}
		
		printArray(name);
		printMatrix(date, "date");
		
		for(i = 1; i < caseN; i++) {
			j = i;
			while((j > 0) && (date[j][1] < date[j - 1][1]) && (date[j][2] <= date[j - 1][2])) {
				int[] tmp = date[j];
				date[j] = date[j - 1];
				date[j - 1] = tmp;
				
				String tmp2 = name[j];
				name[j] = name[j - 1];
				name[j - 1] = tmp2;
				j--;
			}
		}
		
		printArray(name);
		printMatrix(date, "date");
		
		for(i = 1; i < caseN; i++) {
			j = i;
			while((j > 0) && (date[j][0] < date[j - 1][0]) && (date[j][1] <= date[j - 1][1])) {
				int[] tmp = date[j];
				date[j] = date[j - 1];
				date[j - 1] = tmp;
				
				String tmp2 = name[j];
				name[j] = name[j - 1];
				name[j - 1] = tmp2;
				j--;
			}
		}
		
		printArray(name);
		printMatrix(date, "date");
		
		for(int p = 0; p < name.length; p++) {
			if ((date[p][2] >= 2017)) {
				System.out.println(name[p] + " " + date[p][0] + "/" + date[p][1] + "/" + date[p][2]);
			}
			
			
		}
		
		
		
		

	}
	
	
	public static void insertion_sort(int[] s, int n) {
		
		int i, j;
		
		for(i = 1; i < n; i++) {
			j = i;
			while((j > 0) && (s[j] < s[j - 1])) {
				System.out.println("s[j] = " + s[j] + ", s[j - 1] = " + s[j - 1]);
				swap(s, j, j - 1);
				j = j - 1;
			}
		}
	}
	
	public static void swap(int[] arr, int firstIndex, int secondIndex) {
		int tmp = arr[firstIndex];
		arr[firstIndex] = arr[secondIndex];
		arr[secondIndex] = tmp;
	}
	
	
	private static void printArray(String[] arr) {
		System.out.print("[");
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i != arr.length - 1) {
				System.out.print(" ");
			}
		}
		System.out.println("]");
	}
	
	private static void printMatrix(int[][] arr, String name) {
		
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
