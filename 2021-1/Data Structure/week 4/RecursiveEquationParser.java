package week4;

import java.util.List;

public class RecursiveEquationParser {
	
	public List<String> parse(String s, List<String> list) {
		int size = s.length();
		boolean operand = false;

		char c = ' ';
		String operandStr = "";
		String remainder = "";
		
		for(int i = 0; i < size; i++) {
			c = s.charAt(i);
			if((c == '+') || (c == '-') || (c == '*') || (c == '*') || (c == '/') || (c == '(') || (c == ')')) {
				if (operand) {
					remainder = s.substring(i + 1, size);
					break;
				} else {
					if (c == '-') {
						operandStr = operandStr.concat(Character.toString(c));
					}
				}
				
			} else if (c == ' ') {
			} else {
				operandStr = operandStr.concat(Character.toString(c));
				operand = true;
			}
		}
		
		list.add(operandStr);
		
		System.out.println("====================");
		System.out.println("Recursive : [" + s + "]");
		System.out.println("operand >> [" + operandStr + "]");
		System.out.println("remain str >> [" + remainder + "]");
		System.out.println("====================");
		
		if ((remainder.length() != 1) && (remainder.length() != 0)) {
			list = parse(remainder, list);
		}
		return list;
	}
}
