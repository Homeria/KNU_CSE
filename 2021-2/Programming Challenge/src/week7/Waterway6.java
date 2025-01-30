package week7;

import java.util.*;

public class Waterway6 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		//String[] line = input.nextLine().split(" ");
		
		//int n = Integer.parseInt(line[0]);
		int n = 5;
		
		
		//int m = Integer.parseInt(line[1]);
		int m = 2;
		
		
		//int[][] coordinate = new int[n][3];
		//int[] xArr = new int[n];
		//int[] yArr = new int[n];
		
		int[][] coordinate = { {0, 0, 0}, {1, 1, 1}, {0, 2, 2}, {3, 0, 3}, {3, 2, 4} };
		int[] xArr = {0, 1, 0, 3, 3};
		int[] yArr = {0, 1, 2, 0, 2};
		
		
		//int[][] coordinate = { {0, 0, 0}, {1, 1, 1}, {0, 2, 2}, {2, 0, 3}, {2, 0, 4} };
		
		int[] distance = new int[n];
		int dSum = 0;
		
//		for(int i = 0; i < n; i++) {
//			line = input.nextLine().split(" ");
//			coordinate[i][0] = Integer.parseInt(line[0]);
//			coordinate[i][1] = Integer.parseInt(line[1]);
//			coordinate[i][2] = i;
//		}
		
		
		printArray(xArr);
		printArray(yArr);
		System.out.println();
		
		int i, j;
		
		
		for(i = 1; i < n; i++) {
			j = i;
			while((j > 0) && (xArr[j] < xArr[j - 1])) {
				int tmp = xArr[j];
				xArr[j] = xArr[j - 1];
				xArr[j - 1] = tmp;
				j--;
			}
		}
		
		for(i = 1; i < n; i++) {
			j = i;
			while((j > 0) && (yArr[j] < yArr[j - 1])) {
				int tmp = yArr[j];
				yArr[j] = yArr[j - 1];
				yArr[j - 1] = tmp;
				j--;
			}
		}
		
		printArray(xArr);
		printArray(yArr);
		
		int mid;
		
		double midTmp = (double)xArr.length / 2;
		int midTmp2 = xArr.length / 2;
		
		System.out.println("midTmp = " + midTmp + ", midTmp2 = " + midTmp2);
		
		if (midTmp - midTmp2 >= 0.5) {
			mid = midTmp2;
		} else {
			mid = midTmp2 - 1;
		}
		
		int x = xArr[mid];
		int y = yArr[mid];
		
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
		System.out.println();
		
		
		System.out.println(dSum);
		
		for(i = 1; i < n; i++) {
			j = i;
			while((j > 0)
					&& (distance[j] == distance[j - 1])
					&& (coordinate[j][2] > coordinate[j - 1][2])) {
				int tmp = distance[j];
				distance[j] = distance[j - 1];
				distance[j - 1] = tmp;
				
				int[] cTmp = coordinate[j];
				coordinate[j] = coordinate[j - 1];
				coordinate[j - 1] = cTmp;
				j--;
			}
		}
		
		
		for(int p = 0; p < distance.length; p++) {
			if(distance[p] > m) {
				System.out.println(coordinate[p][0] + " " + coordinate[p][1]);
			}
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
