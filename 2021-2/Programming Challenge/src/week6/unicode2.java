package week6;

import java.util.*;

public class unicode2 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		StringBuilder eng = new StringBuilder();
		StringBuilder han = new StringBuilder();
		
		//String line = input.nextLine();
		String line = "Eng�ѱ�lish";
		
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
		
		System.out.println("eng = " + eng + ", han = " + han);
		
		
		
	}
	
	private static boolean isHangul(char c) {
		
		System.out.println("char c casting int = " + ((int) c));
		System.out.println("char c = " + c);
		
		if ((c >= 0xAC00) && c <= 0xD7AF) {
			return true;
		} else {
			return false;
		}
	}
}
