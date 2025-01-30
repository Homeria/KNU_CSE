package week3;

import java.util.*;

public class Hartal {
	
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int c = input.nextInt();
		int n, p;
		
		for(int i = 0; i < c; i++) {
			
			n = input.nextInt();
			int[] cnt = new int[n];
			List<Integer> exception = getException(n);
			
			
			
			p = input.nextInt();
			
			for(int j = 0; j < p; j++) {
				int h = input.nextInt();
				counting(cnt, h);
				System.out.println("h = " + h);
				System.out.print("cnt = ");
				printArray(cnt);
				
			}
			
			Set<Integer> hartal = getHartal(p, cnt, exception);
			System.out.print("exception = ");
			printList(exception);
			System.out.print("hartal = ");
			printSet(hartal);
			printHartal(hartal, n);
			
			
		}
		input.close();
	}
	
	private static void counting(int[] arr, int h) {
		for(int i = h - 1; i < arr.length; i += h) {
			arr[i]++;
		}
	}
	
	
	private static Set<Integer> getHartal(int p, int[] cnt, List<Integer> exception) {
		Set<Integer> set = new HashSet<Integer>();
		double result = ((double) p) / 2;
		System.out.println("result = " + result);
		
		
		for(int i = 0; i < cnt.length; i++) {
			System.out.println("cnt[" + i + "] = " + cnt[i]);
			
			if ((((double)cnt[i]) >= result) && (!exception.contains(i))) {
				set.add(i);
			}
		}
		return set;
	}
	
	
	private static List<Integer> getException(int n) {
		
		List<Integer> list = new ArrayList<Integer>();
		if(n < 6) {
			return null;
		} else {
			
			for(int i = 3; i <= n; i += 7) {
				System.out.println("add Exception : " + (i + 1));
				list.add(i);
				System.out.println("add Exception : " + (i + 4));
				list.add(i + 3);
				System.out.println("add Exception : " + (i + 5));
				list.add(i + 4);
			}
		}
		return list;
	}
	
	private static void printArray(int[] arr) {
		System.out.print("[");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i != arr.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}
	
	private static void printList(List<Integer> list) {
		System.out.print("[");
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
			if (i != list.size() - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}
	
	private static void printSet(Set<Integer> set) {
		int cnt = 0;
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
	}
	
	private static void printHartal(Set<Integer> hartal, int n) {
		String[] day = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
		
		System.out.println("Lost: " + hartal.size());
		
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			if (hartal.contains(i)) {
				System.out.println(day[cnt] + ": " + (i + 1));
			}
			if (cnt >= 6) {
				cnt = 0;
			} else {
				cnt++;
			}
		}
		
	}
	
}