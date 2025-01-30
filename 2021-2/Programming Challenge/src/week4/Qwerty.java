package week4;

import java.util.Scanner;

public class Qwerty {
	
	private static final String[] S = {"`1234567890-=", "QWERTYUIOP[]\\", "ASDFGHJKL;", "ZXCVBNM,./"};
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);

		while(input.hasNext()) {
			String s = input.nextLine();
			
			for(int i = 0; i < s.length(); i++) {
				
				char c = s.charAt(i);
				if (c == ' ') {
					System.out.print(" ");
				} else  {
					char newC = find(c);
					System.out.print(newC);
				}
			}
		}
		input.close();
	}
	
	private static char find(char c) {
		
		char newC = 0;
		
		for(int i = 0; i < S.length; i++) {
			
			for(int j = 0; j < S[i].length(); j++) {
				
				if (c == S[i].charAt(j)) {
					if ((c != '`') && (c != 'Q') && (c != 'A') && (c != 'Z')) {
						return (S[i].charAt(j - 1));
					} else {
						return (S[i].charAt(j));
					}
					
				}
			}
		}
		return newC;
	}
	
	
}
