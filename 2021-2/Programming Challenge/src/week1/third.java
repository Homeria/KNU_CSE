package week1;

import java.util.*;

public class third {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextInt()) {
			int n = input.nextInt();
			int x = input.nextInt();
			
			if(cycleHas(n, x)) {
				System.out.println("Y");
			} else {
				System.out.println("N");
			}
			
		}
		input.close();
		
	}
	
	private static boolean cycleHas(int n, int x) {
		if (n == x) {
			return true;
		}
		while(n != 1) {
			if ((n % 2) == 0) {
				n /= 2;
			} else {
				n = 3 * n + 1;
			}
			if (n == x) {
				return true;
			}
		}
		return false;	
	}
}
