package week5;

/**
 * 주어진 구간의 자연수의 합을 구하는 프포그램입니다.
 * 여러 개의 메소드를 통하여 계산합니다 
 * @author 차경호
 *
 */

public class Summations2 {

	public static void main(String[] args) {
		int upto = 100;
		int sumResult;
		
		for(int i = 10; i <= upto - 10; i += 10) { 
			sumResult = sum(i, i + 10);
			System.out.printf("%d부터 %d까지의 자연수의 합 : %d\n", i, i + 10, sumResult);
		}
	}

	
/**
 * 주어진 구간의 자연수의 합을 구하여 반환합니다.
 * @param from 구간의 시작 값
 * @param to 구간의 끝 값
 * @return 주어진 구간의 자연수의 합
 */
	public static int sum(int from, int to) {
		int sumResult = 0;
		for(int i = from; i <= to; i++) {
			sumResult += i;
		}
		return sumResult;
		
	}

}
