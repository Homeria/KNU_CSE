package week5;

/**
 * 섭씨 온도를 화씨 온도로 바꾸어 출력해주는 프로그램입니다.
 * 섭씨 -40도부터 100도까지 화씨로 바꾸어 출력합니다.
 * @author 차경호
 */
public class CelciusToFarenheit2 {
	
	public static void main(String[] args) {
		
		double c = -40;
		double farenheit;
		for(double i = c; i <= 100; i++) {
			farenheit = convert(i);
			System.out.printf("C = %f --> %f\n", i, farenheit);
		}

	}
	

/**
 * 섭씨 온도를 화씨 온도로 변환하고 결과 출력
 * @param c 섭씨온도
 * @return f 화씨온도
 */
	public static double convert(double c) {
		double f;
		f = c * 9.0 / 5.0 + 32.0;
		return f;
	}

}
