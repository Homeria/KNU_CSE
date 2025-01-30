package week3;

import java.util.*;

public class Card2 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Stack<String> stack, stack2;
		String lines;
		int cnt = 0;
		
		while(input.hasNextLine()) {
			stack = new Stack<String>();
			stack2 = new Stack<String>();
			lines = input.nextLine();
			String[] token = lines.split("");
			
			for(int i = 0; i < token.length; i++) {
				System.out.println("target = " + token[i]);
				System.out.println("before cnt = " + cnt);
				if ((!token[i].equals("*")) && (cnt < 10)) {
					stack.add(token[i]);
					cnt++;
				} else if ((token[i].equals("*"))) {
					stack.remove(cnt - 1);
					cnt--;
				}
			}
			System.out.println("stack = " + stack);
			while(!stack.empty()) {
				stack2.add(stack.pop());
			}
			System.out.println("stack2 = " + stack2);
			while(!stack2.empty()) {
				System.out.print(stack2.pop());
			}
			
			
			
			
		}
		
		
		
		
		
	}

}
