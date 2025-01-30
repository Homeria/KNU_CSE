package week1;

import java.util.Scanner;

public class first {

	public static void main(String[] args) throws Exception {
		
		Scanner input = new Scanner(System.in);
		
		int words, letters;
		
		while(input.hasNextLine()) {
			words = 1;
			letters = 0;
			String s = input.nextLine();
			for(int i = 0; i < s.length(); i++) {
				if ((s.charAt(i) == ' ') && (i != s.length() - 1)) {
					words++;
				} else {
					letters++;
				}
			}
			System.out.println(words + " " + letters);
		}
		
		
		
		
		input.close();
		
	}

}
