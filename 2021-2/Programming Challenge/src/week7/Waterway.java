package week7;

import java.util.*;

public class Waterway {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		//String[] line = input.nextLine().split(" ");
		
		//int n = Integer.parseInt(line[0]);
		int n = 5;
		
		
		//int m = Integer.parseInt(line[1]);
		int m = 2;
		
		
//		int[][] coordinate = new int[n][3];
//		int[] xArr = new int[n];
//		int[] yArr = new int[n];
//	
//		for(int i = 0; i < n; i++) {
//			line = input.nextLine().split(" ");
//			coordinate[i][0] = Integer.parseInt(line[0]);
//			coordinate[i][1] = Integer.parseInt(line[1]);
//			xArr[i] = coordinate[i][0];
//			yArr[i] = coordinate[i][1];
//			coordinate[i][2] = i;
//		}
		
//		int[][] coordinate = { {0, 0, 0}, {1, 1, 1}, {0, 2, 2}, {3, 0, 3}, {3, 2, 4} };
//		int[] xArr = {0, 1, 0, 3, 3};
//		int[] yArr = {0, 1, 2, 0, 2};
		
//		int[][] coordinate = {{0, 0, 0}, {1, 1, 1}, {8, 8, 2}};
//		int[] xArr = {0, 1, 8};
//		int[] yArr = {0, 1, 8};
		
//		int[][] coordinate = {{0, 1, 0}, {1, 2, 1}, {2, 5, 2}, {3, 4, 3}, {4, 3, 4}};
//		int[] xArr = {0, 1, 2, 3, 4};
//		int[] yArr = {1, 2, 5, 4, 3};
		
		int[][] coordinate = {{0, 0, 0}, {1, 1, 1}, {2, 2, 2}, {3, 3, 3}, {9, 9, 4}};
		int[] xArr = {0, 1, 2, 3, 9};
		int[] yArr = {0, 1, 2, 3, 9};
		
		
		
		int[] distance = new int[n];
		int dSum = 0;
		
		System.out.println("정렬 전");
		printArray(xArr);
		printArray(yArr);
		System.out.println();
		
		
		
		int i, j;
		
		System.out.println("x 정렬");
		for(i = 1; i < n; i++) {
			j = i;
			while((j > 0) && (xArr[j] < xArr[j - 1])) {
				swap(xArr, j, j - 1);
				j--;
			}
		}
		printArray(xArr);
		printArray(yArr);
		System.out.println();
		
		
		System.out.println("y 정렬");
		for(i = 1; i < n; i++) {
			j = i;
			while((j > 0) && (yArr[j] < yArr[j - 1])) {
				swap(yArr, j, j - 1);
				j--;
			}
		}
		printArray(xArr);
		printArray(yArr);
		System.out.println();
		
		int mid;
		
		System.out.println("mid값 찾기");
		double midTmp = (double)xArr.length / 2;
		int midTmp2 = xArr.length / 2;
		
		System.out.println("midTmp = " + midTmp + ", midTmp2 = " + midTmp2 + ", midTmp - midTmp2 = " + (midTmp - midTmp2));
		
		if (midTmp - midTmp2 >= 0.5) {
			mid = midTmp2;
		} else {
			mid = midTmp2 - 1;
		}
		
		System.out.println("mid = " + mid);
		System.out.println();
		System.out.println("x와 y값 찾기");
		int x = xArr[mid];
		int y = yArr[mid];
		
		System.out.println("x = " + x + ", y = " + y);
		System.out.println();
		
		
		System.out.println("거리 값 채우기");
		for(int p = 0; p < coordinate.length; p++) {
			distance[p] = Math.abs(x - coordinate[p][0]) + Math.abs(y - coordinate[p][1]);
			dSum += distance[p];
		}
		
		System.out.print("distance : ");
		printArray(distance);
		printMatrix(coordinate, "coordinate");
		System.out.println();
		
		System.out.println("거리 값 비교하여 정렬");
		for(i = 1; i < n; i++) {
			j = i;
			while((j > 0) && (distance[j] < distance[j - 1])) {
				swap(distance, j, j - 1);
				
				int[] cTmp = coordinate[j];
				coordinate[j] = coordinate[j - 1];
				coordinate[j - 1] = cTmp;
				j--;
			}
		}
		
		System.out.print("distance : ");
		printArray(distance);
		printMatrix(coordinate, "coordinate");
		
		
		

		System.out.println("입력받은 순서로 비교하여 정렬");
		for(i = 1; i < n; i++) {
			j = i;
			while((j > 0)
					&& (distance[j] == distance[j - 1])
					&& (coordinate[j][2] > coordinate[j - 1][2])) {
				swap(distance, j, j - 1);
				
				int[] cTmp = coordinate[j];
				coordinate[j] = coordinate[j - 1];
				coordinate[j - 1] = cTmp;
				j--;
			}
		}
		
		System.out.println();
		
		System.out.println("최종");
		System.out.println(dSum);
		
		for(int p = 0; p < distance.length; p++) {
			if(distance[p] > m) {
				System.out.println(coordinate[p][0] + " " + coordinate[p][1]);
			}
		}
		
		
		
	}
	
	private static void swap(int[] arr, int firstIndex, int secondIndex) {
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
