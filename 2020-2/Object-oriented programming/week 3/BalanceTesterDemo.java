package week3;

/**
 * 문자열의 괄호 열림, 닫힘 짝이 맞는지 여부를 검사하는 BalanceTester를 테스트하는 프로그램
 * @author 차경호
 */
public class BalanceTesterDemo {

	public static void main(String[] args) {
		
		String string = "((hello)(goodboye)";
		
		BalanceTester tester = new BalanceTester(string);
		
		if(tester.balanced()) {
			System.out.println(string + "는 괄호짝이 맞습니다.");
		} else {
			System.out.println(string + "는 괄호짝이 맞지 않습니다.");
		}
		
		
		
	}

}
