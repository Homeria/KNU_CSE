package tool;

import java.util.*;

public class sort {

	public static void main(String[] args) {
		
		int[] arr1 = {6,3,9,1,2,7};
		selection_sort(arr1, arr1.length);
		printArray(arr1);
		
		int[] arr2 = {6,3,9,1,2,7};
		insertion_sort(arr2, arr2.length);
		printArray(arr2);
		
		System.out.println("====== quick sort ======");
		//int[] arr3 = {15, 22, 13, 27, 12, 10, 20, 25};
		int[] arr3 = {6,3,9,1,2,7};
		quick_sort(arr3, 0, arr3.length - 1);
		printArray(arr3);
		
		int[] arr4 = {6,3,9,1,2,7};
		bubble_sort(arr4, arr4.length);
		printArray(arr4);
		
	}
	
	
	

	public static void selection_sort(int[] s, int n) {
		System.out.println("====== selection sort ======");
		int i, j;
		int min;
		for(i = 0; i < n; i++) {
			min = i;
			for (j = i + 1; j < n; j++) {
				System.out.println("s[j] = " + s[j] + ", s[min] = " + s[min]);
				if (s[j] < s[min]) {
					min = j;
				}
			}
			swap(s, i, min);
		}
	}
	
	
	public static void insertion_sort(int[] s, int n) {
		System.out.println("====== insertion sort ======");
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
	
	
	public static void bubble_sort(int[] s, int n) {
		System.out.println("====== bubble sort ======");
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n - 1; j++) {
				if (s[j] > s[j + 1]) {
					System.out.println("s[j] = " + s[j] + ", s[j + 1] = " + s[j + 1]);
					swap(s, j, j + 1);
				}
			}
			
		}
	}
	
	
	
	public static void quick_sort(int[] arr, int low, int high) {
		
		int pivotpoint;
		
		if(high >= low) {
			pivotpoint = partition(arr, low, high);
			quick_sort(arr, low, pivotpoint - 1);
			quick_sort(arr, pivotpoint + 1, high);
		}
	}
	
	
	public static int partition(int[] arr, int low, int high) {
		
		int pivotitem = arr[low];
		int i = low + 1;
		int j = high;
		
		while(i < j) {
			while(i < j && arr[i] < pivotitem) {
				i++;
			}
			while(i < j && arr[j] > pivotitem) {
				j--;
			}
			if(i < j) {
				System.out.println("arr[i] = " + arr[i] + ", arr[j] = " + arr[j]);
				swap(arr, i, j);
				i++;
				j--;
			}
		}
		
		int pivotpoint = i - 1;
		System.out.println("arr[low] = " + arr[low] + ", arr[pivotpoint] = " + arr[pivotpoint]);
		swap(arr, low, pivotpoint);
		return pivotpoint;
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

}
