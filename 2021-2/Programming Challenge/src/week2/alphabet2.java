package week2;

import java.util.*;

public class alphabet2 {

	public static void main(String[] args) throws Exception{
		
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextLine()) {
			String s = input.nextLine();
			System.out.println(calculate(s));
		}
		
		
		
	}
	
	private static int calculate(String s) {
		
		StringBuilder sb = new StringBuilder();
		
		boolean error = false;
		boolean first = true;
		boolean operator = false;
		
		int n = 0;
		
		for(int i = 0; i < s.length(); i++) {
			
			char ch = s.charAt(i);
			System.out.println((ch));
			if (error) {
				break;
			}
			if (ch == 'P') {
				sb.append("+");
			} else if (ch == 'S') {
				sb.append("-");
			} else if (ch == 'T') {
				sb.append("*");
			} else if (ch == 'V') {
				sb.append("/");
			} else if ((((int)ch) < 65) || (((int)ch) > 74)) {
				System.out.println("Error");
				error = true;
			} else {
				sb.append(Integer.toString((int)ch - 65));
			}
		}
		
		String s2 = sb.toString();
		System.out.println("s2 = " + s2);
		List<String> list = parsing(s2);
		System.out.println("list = " + list);
		
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()) {
			String next = iter.next();
			if (first) {
				n += Integer.parseInt((String) next);
				first = false;
			} else {
				if (next.equals("+")) {
					n += Integer.parseInt(iter.next());
				} else if (next.equals("-")) {
					n -= Integer.parseInt(iter.next());
				} else if (next.equals("*")) {
					n *= Integer.parseInt(iter.next());
				} else if (next.equals("/")) {
					n /= Integer.parseInt(iter.next());
				}
			}
		}
		
		
		System.out.println(list);
		System.out.println(n);
		
		return n;
	}
	
	private static List<String> parsing(String s) {
		
		List<String> list = new ArrayList<String>();
		
		boolean first = true;
		int start = 0;
		int end = 0;
		
		for(int i = 0; i < s.length(); i++) {
			
			if((s.charAt(i) == '+') || (s.charAt(i) == '-') || (s.charAt(i) == '/') || (s.charAt(i) == '*')) {
				
				end = i;
				if (first) {
					list.add(s.substring(0, end));
					start = end;
					end++;
					first = false;
				} else {
					list.add(s.substring(start, end));
					start = end;
					end++;
				}
				list.add(s.substring(start, end));
				start = end;
			}
			
			if(i == s.length() - 1) {
				list.add(s.substring(start, i + 1));
			}
		}
		
		
		
		return list;
	}

}
