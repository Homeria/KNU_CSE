package week7;

import java.util.*;

public class ShoeRepairman {

	public static void main(String args[]) {
		
		Scanner input = new Scanner(System.in);
		
		//int caseN = Integer.parseInt(input.nextLine());
		int caseN = 1;
		
		for(int i = 0; i < caseN; i++) {
			
			input.nextLine();
			
			//int workN = Integer.parseInt(input.nextLine());
			int workN = 4;
			
			int[] time = new int[workN];
			int[] penalty = new int[workN];
			
			for(int j = 0; j < workN; j++) {
				String[] s = input.nextLine().split(" ");
				time[j] = Integer.parseInt(s[0]);
				penalty[j] = Integer.parseInt(s[1]);
			}
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
	}
	
}
