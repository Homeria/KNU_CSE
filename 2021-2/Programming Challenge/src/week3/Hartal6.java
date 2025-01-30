package week3;

import java.util.*;

public class Hartal6 {
	
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
			}
			Set<Integer> hartal = getHartal(p, cnt, exception);
			printHartal(hartal, n);
			System.out.println();
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
		
		
		for(int i = 0; i < cnt.length; i++) {
			
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
				list.add(i);
				list.add(i + 3);
				list.add(i + 4);
			}
		}
		return list;
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