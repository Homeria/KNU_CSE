package week3;

/**
 * 문자열의 괄호 열림, 닫힘 짝이 맞는지 여부를 검사하는 BalanceTester를 테스트하는 프로그램
 * @author 차경호
 */
public class BalanceTesterDemo2 {

	public static void main(String[] args) {
		
		String[] strings = {"((hello)(goodbye))", "((a)(b)(())", "(a))b("};
		
		for(int i = 0; i < strings.length; i++) {
			
			BalanceTester tester = new BalanceTester(strings[i]);
			
			if(tester.balanced()) {
				
				System.out.println(strings[i] + "는 괄호가 짝이 맞습니다.");
			} else {
				System.out.println(strings[i] + "는 괄호가 짝이 맞지 않습니다.");
			}
			
		}
		
		
	}

}
