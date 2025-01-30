package week3;

import java.util.*;

public class Hartal4 {
	
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int c = input.nextInt();
		int n, p;
		
		for(int i = 0; i < c; i++) {
			
			List<Set<Integer>> list = new ArrayList<Set<Integer>>();
			
			Set<Integer> hartal = new HashSet<Integer>();
			
			n = input.nextInt();
			p = input.nextInt();
			
			Set<Integer> exception = getException(n);
			
			for(int j = 0; j < p; j++) {
				int h = input.nextInt();
				list.add(get(h, n));
				getHartal(hartal, exception, h, n);
			}
			System.out.println(hartal.size());
		}
		input.close();
	}
	
	private static HashSet<Integer> get(int n, int days) {
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i = n; i < days; i += n) {
			set.add(i);
		}
		return set;
	}
	
	private static void getHartal(Set<Integer> set, Set<Integer> exception, int n, int days) {
		for(int i = n; i <= days; i += n) {
			if(!exception.contains(i)) {
				set.add(i);
			}
		}
	}
	
	private static Set<Integer> getException(int days) {
		Set<Integer> set = new HashSet<Integer>();
		boolean flag = false;
		if(days < 6) {
			return null;
		} else {
			for(int i = 7; i < days; ) {
				set.add(i);
				if (flag) {
					i += 6;
					flag = false;
				} else {
					i++;
					flag = true;
				}
			}
		}
		return set;
	}
}
