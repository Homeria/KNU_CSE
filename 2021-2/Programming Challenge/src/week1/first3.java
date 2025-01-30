package week1;

public class first3 {

	public static void main(String[] args) throws Exception {
		
		String string = "Hi" + System.lineSeparator() + "Test " + System.lineSeparator() + "test3 test2 test1";
		
		String[] arr = string.split(System.lineSeparator());
		
		int words;
		int letters;
		
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

}
