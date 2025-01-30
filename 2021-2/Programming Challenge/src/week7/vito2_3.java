package week7;

import java.util.*;


public class vito2_3 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		//String[] line = input.nextLine().split(" ");
		
		//int n = Integer.parseInt(line[0]);
		int n = 5;
		
		
		//int m = Integer.parseInt(line[1]);
		int m = 3;
		
		
		//int[][] coordinate = new int[n][2];
		
		int[][] coordinate = { {0, 0}, {1, 1}, {0, 2}, {3, 0}, {3, 2} };
		
		int[] distance = new int[n];
		int xSum = 0;
		int ySum = 0;
		int dSum = 0;
		
		for(int i = 0; i < n; i++) {
			//line = input.nextLine().split(" ");
			//coordinate[i][0] = Integer.parseInt(line[0]);
			//coordinate[i][1] = Integer.parseInt(line[1]);
		}
		
		int i, j;
		
		
		
		for(int p = 0; p < coordinate.length; p++) {
			xSum += coordinate[p][0];
			ySum += coordinate[p][1];
		}
		
		int x = xSum / n;
		int y = ySum / n;
		
		for(int p = 0; p < coordinate.length; p++) {
			distance[p] = Math.abs(x - coordinate[p][0]) + Math.abs(y - coordinate[p][1]);
			dSum += distance[p];
		}
		
		
		printArray(distance);
		
		for(i = 1; i < n; i++) {
			j = i;
			while((j > 0) && (distance[j] < distance[j - 1])) {
				int tmp = distance[j];
				distance[j] = distance[j - 1];
				distance[j - 1] = tmp;
				
				int[] cTmp = coordinate[j];
				coordinate[j] = coordinate[j - 1];
				coordinate[j - 1] = cTmp;
			}
		}
		
		printArray(distance);
		
		for(int p = 0; p < m; p++) {
			System.out.println(coordinate[p][0] + " " + coordinate[p][1]);
		}
		
		
		
		
	}
	
	public static void insertion_sort(int[] s, int n) {
		
		int i, j;
		
		for(i = 1; i < n; i++) {
			j = i;
			while((j > 0) && (s[j] < s[j - 1])) {
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
	
	private static void printArray(int[] arr) {
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
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println("Matrix : " + name);
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
