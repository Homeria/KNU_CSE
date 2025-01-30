package week7;

import java.util.*;

public class Waterway2 {

public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		// String[] line = input.nextLine().split(" ");
		
		//int n = Integer.parseInt(line[0]);
		int n = 5;
		
		
		//int m = Integer.parseInt(line[1]);
		int m = 2;
		
		
		//int[][] coordinate = new int[n][3];
		int[][] coordinate = { {0, 0}, {1, 1}, {0, 2}, {3, 0}, {3, 2} };
		
		int[] distance = new int[n];
		int xSum = 0;
		int ySum = 0;
		int dSum = 0;
		
//		for(int i = 0; i < n; i++) {
//			line = input.nextLine().split(" ");
//			coordinate[i][0] = Integer.parseInt(line[0]);
//			coordinate[i][1] = Integer.parseInt(line[1]);
//			coordinate[i][2] = i;
//		}
		
		int i, j;
		
		
		
		for(int p = 0; p < coordinate.length; p++) {
			xSum += coordinate[p][0];
			ySum += coordinate[p][1];
		}
		
		double dX = (double)xSum / (double)n;
		double dY = (double)ySum / (double)n;
		
		int x = xSum / n;
		int y = ySum / n;
		
		System.out.println("dx = " + dX + ", dy = " + dY);
		System.out.println("x = " + x + ", y = " + y);
		
		if((dX - x) >= 0.5) {
			x = x + 1;
		}
		if((dY - y) >= 0.5) {
			y = y + 1;
		}
		
		System.out.println("x = " + x + ", y = " + y);
		
		
		for(int p = 0; p < coordinate.length; p++) {
			distance[p] = Math.abs(x - coordinate[p][0]) + Math.abs(y - coordinate[p][1]);
			dSum += distance[p];
		}
		
		
		for(i = 1; i < n; i++) {
			j = i;
			while((j > 0) && (distance[j] < distance[j - 1])) {
				int tmp = distance[j];
				distance[j] = distance[j - 1];
				distance[j - 1] = tmp;
				
				int[] cTmp = coordinate[j];
				coordinate[j] = coordinate[j - 1];
				coordinate[j - 1] = cTmp;
				j--;
			}
		}
		
		
		
		
		printMatrix(coordinate, "coordinate");
		printArray(distance);
		
		System.out.println(dSum);
		
		for(int p = distance.length - 1; p >= 0; p--) {
			if(distance[p] > m)
			System.out.println("x = " + coordinate[p][0] + ", y = " + coordinate[p][1] + ", d = " + distance[p]);
		}
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
