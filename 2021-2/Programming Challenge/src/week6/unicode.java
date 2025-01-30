package week6;

import java.util.*;

public class unicode {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		StringBuilder eng = new StringBuilder();
		StringBuilder han = new StringBuilder();
		
		String line = input.nextLine();
		//String line = "Eng«—±€lish";
		
		for(int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			
			if(isHangul(c)) {
				han.append(c);
			} else {
				eng.append(c);
			}
		}
		
		String engS = eng.toString();
		String hanS = han.toString();
		
		
		
		System.out.println(engS + hanS);
		System.out.println(engS.length() + " " + hanS.length() + " " + (engS.length() + hanS.length()));
		
		
		
	}
	
	private static boolean isHangul(char c) {
		
		if ((c >= 0xAC00) && c <= 0xD7AF) {
			return true;
		} else {
			return false;
		}
	}
}
