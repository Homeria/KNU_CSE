package week2;

import java.util.*;

public class alphabet5 {

	public static void main(String[] args) throws Exception{
		
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextLine()) {
			String s = input.nextLine();
			int result = calculate(s);
			if (result != -10000) {
				System.out.println(result);
			} else {
				System.out.println("Error");
			}
			
			
		}
		
		
		
	}
	
	private static int calculate(String s) {
		
		StringBuilder sb = new StringBuilder();
		
		boolean first = true;
		
		int n = 0;
		
		for(int i = 0; i < s.length(); i++) {
			
			char ch = s.charAt(i);
			if (ch == 'P') {
				sb.append("+");
			} else if (ch == 'S') {
				sb.append("-");
			} else if (ch == 'T') {
				sb.append("*");
			} else if (ch == 'V') {
				sb.append("/");
			} else if ((((int)ch) < 65) || (((int)ch) > 74)) {
				return -10000;
			} else {
				sb.append(Integer.toString((int)ch - 65));
			}
		}
		
		String s2 = sb.toString();
		List<String> list = parsing(s2);
		System.out.println(list);
		
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()) {
			String next = iter.next();
			if (first) {
				n += Integer.parseInt((String) next);
				first = false;
			} else {
				if (next.equals("+")) {
					String next2 = iter.next();
					if ((next2.equals("+")) || (next2.equals("-")) || (next2.equals("*")) || (next2.equals("-")) || (next2.equals(""))) {
						return -10000;
					} else {
						n += Integer.parseInt(next2);
					}
				} else if (next.equals("-")) {
					String next2 = iter.next();
					if ((next2.equals("+")) || (next2.equals("-")) || (next2.equals("*")) || (next2.equals("-")) || (next2.equals(""))) {
						return -10000;
					} else {
						n -= Integer.parseInt(next2);
					}
				} else if (next.equals("*")) {
					String next2 = iter.next();
					if ((next2.equals("+")) || (next2.equals("-")) || (next2.equals("*")) || (next2.equals("-") || (next2.equals("")))) {
						return -10000;
					} else {
						n *= Integer.parseInt(next2);
					}
				} else if (next.equals("/")) {
					String next2 = iter.next();
					if ((next2.equals("+")) || (next2.equals("-")) || (next2.equals("*")) || (next2.equals("-") || (next2.equals("")))) {
						return -10000;
					} else {
						n /= Integer.parseInt(next2);
					}
				}
			}
		}
		
		return n;
	}
	
	private static List<String> parsing(String s) {
		
		List<String> list = new ArrayList<String>();
		
		boolean first = true;
		int start = 0;
		int end = 0;
		
		for(int i = 0; i < s.length(); i++) {
			
			String substring;
			
			if((s.charAt(i) == '+') || (s.charAt(i) == '-') || (s.charAt(i) == '/') || (s.charAt(i) == '*')) {
				end = i;
				if (first) {
					substring = s.substring(0, end);
					System.out.println("[1] substring = " + substring);
					list.add(substring);
					start = end;
					end++;
					first = false;
				} else {
					substring = s.substring(start, end);
					System.out.println("[2] substring = " + substring);
					if(!(substring.equals(""))) {
						list.add(substring);
					}
					start = end;
					end++;
				}
				substring = s.substring(start, end);
				System.out.println("[3] substring = " + substring);
				if(!(substring.equals(""))) {
					list.add(substring);
				}
				start = end;
			}
			
			if(i == s.length() - 1) {
				substring = s.substring(start, i + 1);
				System.out.println("[4] substring = " + substring);
				if(!(substring.equals(""))) {
					list.add(s.substring(start, i + 1));
				}
				
			}
		}
		return list;
	}

}
