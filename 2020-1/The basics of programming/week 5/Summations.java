package week5;

/**
 * 1부터 주어진 자연수 이하의 자연수들을 모두 더하여 출력하는 프로그램입니다.
 * 여러 개의 메소드를 통하여 계산합니다 
 * @author 차경호
 *
 */

public class Summations {

	public static void main(String[] args) {
		int upto = 20;
		int sumResult;
		
		for(int i = 1; i <= upto; i++) { 
			sumResult = sum(i);
			System.out.printf("1부터 %d까지의 자연수의 합 : %d\n", i, sumResult);
		}
	}

	
/**
 * 주어진 자연수 이하의 자연수의 합을 구하여 반환합니다.
 * @param upto 어떤 수까지 더할 것인가?
 * @return upto 이하의 자연수의 합
 */
	public static int sum(int upto) {
		int sum = 0;
		for (int i = 1; i <= upto; i++) {
			sum += i;
		}
		return sum;
		
	}

}
