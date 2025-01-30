package week3;

/**
 * 문자열의 괄호 열림, 닫힘 짝이 맞는지 여부를 검사하는 도구
 * "(1+(2+3))"은 괄호 짝이 맞는 문자열,
 * "(1+(2+3)"은 괄호 짝이 맞지 않는 문자열
 * @author 차경호
 */
public class BalanceTester {

	String str;
	Counter counter;
	
	/**
	 * 구성자
	 * @param s 검사할 문자열
	 */
	public BalanceTester(String s) {
		this.str = s;
		counter = new Counter();
	}
	
	
	public boolean balanced() {
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '(') {
				counter.countUp();
			} else if (str.charAt(i) == ')') {
				counter.countDown();
			}
			
			if(counter.getValue() < 0) {
				return false;
			}
			
		}
		
		int count = counter.getValue();
		counter.reset();
		
		if(count == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
}
