package week2;

import java.util.Scanner;

public class Card2 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int[] tomArr = new int[26];
		int[] jerryArr = new int[26];
		String s, tom, jerry;
		
		while(input.hasNextLine()) {
			s = input.nextLine();
			
			tom = s.substring(0, 5);
			jerry = s.substring(6, 11);
			for(int i = 0; i < 5; i++) {
				tomArr[tom.charAt(i) - 65]++;
				jerryArr[jerry.charAt(i) - 65]++;
			}
			
			int judge = judge(tomArr, jerryArr);
			if (judge == 0) {
				System.out.println("Draw");
			} else if (judge == 1) {
				System.out.println("Tom");
			} else {
				System.out.println("Jerry");
			}
			
		}
		input.close();
	}
	
	private static int judge(int[] arr1, int[] arr2) {
		
		int arr1Max = findMax(arr1);
		int arr2Max = findMax(arr2);
		
		if (arr1Max > arr2Max) {
			return 1;
		} else if (arr1Max < arr2Max) {
			return 2;
		} else {
			int arr1MaxIndex = findMaxIndex(arr1, arr1Max);
			int arr2MaxIndex = findMaxIndex(arr2, arr2Max);
			if (arr1MaxIndex > arr2MaxIndex) {
				return 1;
			} else if (arr1MaxIndex < arr2MaxIndex) {
				return 2;
			} else {
				return 0;
			}
		}
	}
	
	private static int findMax(int[] arr) {
		int n = 0;
		for(int i = 0; i < arr.length; i++) {
			if (n < arr[i]) {
				n = arr[i];
			}
		}
		return n;
	}
	
	private static int findMaxIndex(int[] arr, int max) {
		for(int i = arr.length - 1; i > 0; i--) {
			if (arr[i] == max) {
				return i;
			}
		}
		return -1;
	}

}
