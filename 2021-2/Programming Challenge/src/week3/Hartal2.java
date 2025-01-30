package week3;

import java.util.*;

public class Hartal2 {

	
	
	
	public static void main(String args[]) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Input the test case count : ");
		int caseCnt = input.nextInt();
		
		int days, parties;
		
		for(int i = 0; i < caseCnt; i++) {
			System.out.println("=======================");
			Set<Integer> hartal = new HashSet<Integer>();
			
			System.out.print("Input the simulation days : ");
			days = input.nextInt();
			System.out.print("Input the parties : ");
			parties = input.nextInt();
			
			Set<Integer> exception = getException(days);
			
			for(int j = 0; j < parties; j++) {
				System.out.print((j + 1) + " : ");
				int party = input.nextInt();
				getHartal(hartal, exception, party, days);
			}
			System.out.println("hartal : " + hartal);
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
