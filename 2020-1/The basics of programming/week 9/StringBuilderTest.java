package week9;

/**
 * StringBuilder를 이용한 시간과 String을 더하는 방식의 시간을 비교하는 프로그램.
 * StringBuilder를 이용하는 것이 String을 더하는 방식보다 시간이 적게 걸린다.
 * @author 차경호
 *
 */
public class StringBuilderTest {

	public static void main(String[] args) {
		
		long startTime, endTime;
		
		StringBuilder sb = new StringBuilder();
		String string = "";
		
		
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			sb.append("여름 ");
		}
		String result = sb.toString();
		endTime = System.currentTimeMillis();
		System.out.println("stringBuilder 시간 = " + (endTime - startTime) + "ms");
		
		
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			string += "여름 ";
		}
		endTime = System.currentTimeMillis();
		System.out.println("String 더하기 시간 = " + (endTime - startTime) + "ms");
		
	}

	

}
