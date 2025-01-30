package week3;

public class Tokenizer {

	String[] stringArr;
	String[] newArr;
	String s;
	int n;
	
	public Tokenizer(String s) {
		this.s = s;
		n = 0;
	}
	
	public String[] split() {
		
		int size = s.length();
		stringArr = new String[size];
		
		boolean first = true;
		boolean operand = false;
		
		char cNext, cPrevious;
		char c = ' ';
		
		for(int i = 0; i < size; i++) {
			stringArr[i] = "";
		}
		
		
		for(int i = 0; i < size; i++) {
			c = s.charAt(i);
			if (first) {
				if(c == '-') {
					onlyConcatString(n, Character.toString(c));
				} else {
					cNext = s.charAt(i + 1);
					if (cNext == '.') {
						onlyConcatString(n, Character.toString(c));
					} else {
						concatString(n, Character.toString(c));
					}
				}
				first = false;
			} else {
				if ((c == '+') || (c == '*') || (c == '*') || (c == '/') || (c == '(') || (c == ')')) {
					if(operand) {
						n++;
						operand = false;
					}
					concatString(n, Character.toString(c));
				} else if (c == '-') {
					if(operand) {
						n++;
						operand = false;
					}
					cPrevious = s.charAt(i - 1);
					if ((cPrevious == '+') || (cPrevious == '*') || (cPrevious == '/') || (cPrevious == '(') || (cPrevious == ')')) {
						if(cPrevious == ')') {
							concatString(n, Character.toString(c));
						} else {
							onlyConcatString(n, Character.toString(c));
						}
						//operand = true;
						
					} else {
						concatString(n, Character.toString(c));
					}
				} else if (c == ' ') {
				} else {
					operand = true;
					if(operand) {
						onlyConcatString(n, Character.toString(c));
					}
					
			    }
			} 
		}
		
		int count = 0;
		for(int i = 0; i < stringArr.length; i++) {
			if ((stringArr[i] != null) && (stringArr[i] != "")) {
				count++;
			}
		}
		newArr = new String[count];
		for(int i = 0; i < newArr.length; i++) {
			newArr[i] = stringArr[i];
		}
		
		return newArr;
	}
	
	private void onlyConcatString(int index, String s) {
		stringArr[n] = stringArr[n].concat(s);
	}
	
	private void concatString(int index, String s) {
		onlyConcatString(index, s);
		n++;
	}
}
