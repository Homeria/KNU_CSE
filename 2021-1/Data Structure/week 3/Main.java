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
	 * ������
	 * @param s Postfix ������ ��ȯ�ϰ��� �Է��� Infix ������ ��
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
	 * Infix ���� Postfix�� ��ȯ�ϴ� �޼ҵ�
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
	 * �Ķ���ͷ� ���� �������� �켱������ ���ÿ� �ִ� �����ڿ� ���Ͽ� ������ �ൿ�� ���Ѵ�
	 * @param op �켱������ ������ ������ �ൿ�� ���ϰ��� �ϴ� ������
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
	 * ���� �޾Ƶ��� ����(symbol)�� ���ÿ� � ���� ������� ����Ѵ�
	 * @param symbol ���� �޾Ƶ��� ����
	 */
	public void print(String symbol) {
		
		System.out.println("Process symbol '" + symbol + "'");
		System.out.println("stack status :");
		if (!(operator.empty())) {
			System.out.println(operator);
		}
	}
	
	
	/**
	 * �� operator�� �켱������ �Ǵ��Ѵ�.
	 * @param topOp ���� ��� 1
	 * @param op ���� ��� 2
	 * @return op�� ")"�� �� 2,
	 *         op�� topOp���� �켱������ ���ٸ� 1,
	 *         op�� topOp�� �켱������ ���ٸ� 0,
	 *         op�� topOp���� �켱������ ���ٸ� -1,
	 *         �켱������ ���� �� ���ٸ� -2 ��ȯ
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
	 * ������ ���� �ʾҴ°��� ���� ����� ��ȯ�ϴ� �޼ҵ�
	 * @return ������ ������� �ʴٸ� true, ����ִٸ� false
	 */
	public boolean notEmpty() {
		return !(operator.empty());
	}
	
	
	/**
	 * ��ȣ�� pair���� �Ǵ��ϴ� �޼ҵ�
	 * @return �ùٸ��� true, �ùٸ��� �ʴٸ� false
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
