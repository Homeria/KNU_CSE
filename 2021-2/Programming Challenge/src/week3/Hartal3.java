package week3;

import java.util.*;

public class Hartal3 {
	
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int caseCnt = input.nextInt();
		int days, parties;
		for(int i = 0; i < caseCnt; i++) {
			Set<Integer> hartal = new HashSet<Integer>();
			
			days = input.nextInt();
			parties = input.nextInt();
			
			Set<Integer> exception = getException(days);
			
			for(int j = 0; j < parties; j++) {
				int party = input.nextInt();
				getHartal(hartal, exception, party, days);
			}
			System.out.println(hartal.size());
		}
		input.close();
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
			for(int i = 6; i < days; ) {
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
