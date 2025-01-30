package week1;

import java.util.Scanner;

public class first4 {

	public static void main(String[] args) throws Exception {
		
		Scanner input = new Scanner(System.in);
		
		int words, letters;
		
		while(input.hasNextLine()) {
			String string = input.nextLine();
			
			String[] arr = string.split(System.lineSeparator());
			
			for(String s : arr) {
				words = 1;
				letters = 0;
				for(int i = 0; i < s.length(); i++) {
					if((s.charAt(i) == ' ') && (i != s.length() - 1)) {
						words++;
					} else if ((i != s.length() - 1) || s.charAt(i) != ' '){
						letters++;
					}
				}
				System.out.println(words + " " + letters);
			}
		}
		input.close();
		
	}

}
