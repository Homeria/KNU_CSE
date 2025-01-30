package week7;

/**
 * 문자열과 관련된 메소드를 사용하는 프로그램
 * length(문자열의 길이), concat(다른 문자열과 연결), substring(일정 부분 문자열 추출)
 * indexOf(문자열의 위치), charAt(일정 위치에 문자열 추출), replace(문자열 교체)를 사용한다.
 * @author 차경호
 *
 */
public class StringTest {

	public static void main(String[] args) {
		
		String p = new String("우리 개는 물지 않아요!");
		int s1, s4;
		String s2, s3, s6;
		char s5;
		
		s1 = p.length();
		s2 = p.concat(" 순하답니다!");
		s3 = s2.substring(0, 8);
		s4 = s2.indexOf('개');
		s5 = s2.charAt(7);
		s6 = s2.replace("물지 않아", "물어");
		
		System.out.println("원래 문자열 : " + p);
		System.out.println("문자열의 길이 = " + s1);
		System.out.println("다른 문자열이 연결된 새 문자열(concat) : " + s2);
		System.out.println("0번 위치 이상, 8번 위치 미만 부분 문자열(substring) : " + s3);
		System.out.println("\"개\"는 " + s4 + "번째 위치에 있습니다.(indexOf)");
		System.out.println("7번 위치 글자 : " + s5);
		System.out.println("\"물지 않아\"를 \"물어\"로 교체한 새 문자열(replace) : " + s6);
		
		
		
		
	}

}
