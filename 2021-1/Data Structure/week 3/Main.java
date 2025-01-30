package week3;

import java.util.Scanner;

public class Main {

	myStack<String> operator;
	String[] s;
	String input;
	String[] postfix;
	int n = 0;
	Tokenizer tokenizer;
	
	
	/**
	 * 생성자
	 * @param s Postfix 식으로 변환하고자 입력한 Infix 상태의 식
	 */
	public Main(String s) {
		tokenizer = new Tokenizer(s);
		this.s = tokenizer.split();
		//this.s = s.split("");
		input = s;
		operator = new myStack<String>();
		postfix = new String[s.length()];
	}

	
	/**
	 * Infix 식을 Postfix로 변환하는 메소드
	 */
	public void converting() {
		
		String token;
		int count = 0;
		
		while(count < s.length) {
			token = s[count];
			if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("(") || (token.equals(")"))) {
				processOperator(token);
			} else {
				postfix[n] = token;
				n++;
			}
			print(token);
			count++;
		}
		
		while (notEmpty()) {
			postfix[n] = (String) operator.pop();
			n++;
		}
		
		System.out.println("Infix : " + input);
		System.out.print("Postfix : ");
		count = 0;
		for (String s : postfix) {
			if (s != null) {
				System.out.print(s + " ");
			}
		}
		
	}
	
	
	/**
	 * 파라미터로 받은 연산자의 우선순위를 스택에 있는 연산자와 비교하여 적절한 행동을 취한다
	 * @param op 우선순위를 따지고 적절한 행동을 취하고자 하는 연산자
	 */
	public void processOperator(String op) {
		
		if (operator.empty() && (!(op.equals(")")))) {
			
			operator.push(op);
			
		} else {
			
			String topOp = (String) operator.peek();
			
			if(judgePrecedence(topOp, op) == 1) {
				operator.push(op);
				
			} else {
				if (judgePrecedence(topOp, op) == 2) {
					boolean done = false;
					while((!done) && (notEmpty())) {
						topOp = (String) operator.pop();
						if (topOp.equals("(")) {
							done = true;
						} else {
							postfix[n] = topOp;
							n++;
						}
					}
					
				} else {
					
					while(notEmpty()
							&&
						((judgePrecedence(topOp, op) == -1) || (judgePrecedence(topOp, op) == 0))) {
						
						topOp = (String) operator.pop();
						postfix[n] = topOp;
						n++;
						
						
						if (notEmpty()) {
							topOp = (String) operator.peek();
						}
					}
					if(!(op.equals(")"))) {
						operator.push(op);
					}
				}
				
				
				
			}
		}
		
	}
	
	
	/**
	 * 현재 받아들인 글자(symbol)과 스택에 어떤 것이 들었는지 출력한다
	 * @param symbol 현재 받아들인 글자
	 */
	public void print(String symbol) {
		
		System.out.println("Process symbol '" + symbol + "'");
		System.out.println("stack status :");
		if (!(operator.empty())) {
			System.out.println(operator);
		}
	}
	
	
	/**
	 * 두 operator의 우선순위를 판단한다.
	 * @param topOp 비교할 대상 1
	 * @param op 비교할 대상 2
	 * @return op가 ")"일 때 2,
	 *         op가 topOp보다 우선순위가 높다면 1,
	 *         op와 topOp의 우선순위가 같다면 0,
	 *         op가 topOp보다 우선순위가 낮다면 -1,
	 *         우선순위를 비교할 수 없다면 -2 반환
	 */
	public int judgePrecedence(String topOp, String op) {
		
		if((topOp.equals("+") || topOp.equals("-")) && (op.equals("+") || op.equals("-"))
				|| (topOp.equals("*") || topOp.equals("/")) && (op.equals("*") || op.equals("/"))
				) {
			return 0;
			
		} else if (
				(topOp.equals("*") || topOp.equals("/")) && (op.equals("+") || op.equals("-"))) {
			return -1;
		} else if (
				((topOp.equals("+") || topOp.equals("-")) && (op.equals("*") || op.equals("/")))) {
			return 1;
		} else if (op.equals(")")) {
			return 2;
		} else {
			return -2;
		}
	}
	
	
	/**
	 * 스택이 비지 않았는가에 대한 결과를 반환하는 메소드
	 * @return 스택이 비어있지 않다면 true, 비어있다면 false
	 */
	public boolean notEmpty() {
		return !(operator.empty());
	}
	
	
	/**
	 * 괄호가 pair한지 판단하는 메소드
	 * @return 올바르면 true, 올바르지 않다면 false
	 */
	public boolean parenthesesArePair() {
		int count = 0;
		for(String str : s) {
			if (str.equals("(")) {
				count++;
			} else if (str.equals(")")) {
				count--;
			}
		}
		if (count == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Input an infix expression.");
		Main main = new Main(input.nextLine());
		
		if (main.parenthesesArePair()) {
			System.out.println("Parentheses are pair.");
			main.converting();
		} else {
			System.out.println("Parentheses are not pair.");
		}
		
		input.close();
	}
	
	
	
	
	
}
