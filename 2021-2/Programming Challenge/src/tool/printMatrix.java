package tool;

public class printMatrix {

	private static void printMatrix(Object[][] arr, String name) {
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println("Matrix : " + name);
			System.out.print("[");
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i]);
				if (j != arr[i].length - 1) {
					System.out.print(" ");
				}
			}
			System.out.println("]");
		}
		System.out.println();
	}
	
	
	private static void printMatrix(String[][] arr, String name) {
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println("Matrix : " + name);
			System.out.print("[");
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i]);
				if (j != arr[i].length - 1) {
					System.out.print(" ");
				}
			}
			System.out.println("]");
		}
		System.out.println();
	}
	

	private static void printMatrix(Number[][] arr, String name) {
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println("Matrix : " + name);
			System.out.print("[");
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i]);
				if (j != arr[i].length - 1) {
					System.out.print(" ");
				}
			}
			System.out.println("]");
		}
		System.out.println();
	}
	
	
	private static void printMatrix(int[][] arr, String name) {
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println("Matrix : " + name);
			System.out.print("[");
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i]);
				if (j != arr[i].length - 1) {
					System.out.print(" ");
				}
			}
			System.out.println("]");
		}
		System.out.println();
	}


	private static void printMatrix(double[][] arr, String name) {
	
	for(int i = 0; i < arr.length; i++) {
		System.out.println("Matrix : " + name);
		System.out.print("[");
		for(int j = 0; j < arr[i].length; j++) {
			System.out.print(arr[i]);
			if (j != arr[i].length - 1) {
				System.out.print(" ");
			}
		}
		System.out.println("]");
	}
	System.out.println();
}


	private static void printMatrix(float[][] arr, String name) {
	
	for(int i = 0; i < arr.length; i++) {
		System.out.println("Matrix : " + name);
		System.out.print("[");
		for(int j = 0; j < arr[i].length; j++) {
			System.out.print(arr[i]);
			if (j != arr[i].length - 1) {
				System.out.print(" ");
			}
		}
		System.out.println("]");
	}
	System.out.println();
}
	
	
	
	
	
	
	
}
