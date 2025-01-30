package week3;

/**
 * 문자열을 구성하는 글자들의 순서를 바꾼 새 문자열을 만들어준다.
 * @author 차경호
 */
public class Reverser {

	private String s;

	public Reverser(String s) {
		this.s = s;
	}
	
	/**
	 * 문자열을 구성하는 글자들의 순서를 바꾼 새 문자열을 만들어준다.
	 * @return 순서가 바뀐 새 문자열
	 */
	public String reverse() {
		StringBuilder sb = new StringBuilder();
		
		for(int i = s.length() - 1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		
		return sb.toString();
	}
	
	
	/**
	 * 문자열을 구성하는 글자들의 순서를 단어 단위로 바꾼 새 문자열을 만들어준다.
	 * @return 단어 단위로 순서가 바뀐 새 문자열
	 */
	public String reverseWords() {
		StringBuilder sb = new StringBuilder();
		String[] array = s.split(" ");
		
		for(int i = array.length - 1; i >= 0; i--) {
			sb.append(array[i]);
			sb.append(" ");
		}
		
		return sb.toString();
	}
	
	
	
	
}
