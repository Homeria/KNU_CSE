package week3;

import java.util.Random;

/**
 * 랜덤 함수를 이용하여 주사위 한 개를 굴렸을 때의 값을 만드는 프로그램
 * @author 차경호
 */
public class Die {

	public final int MAX = 6;
	Random random;
	
	/**
	 * 구성자
	 */
	public Die() {
		random = new Random();
	}
	
	
	/**
	 * 주사위를 구린다.
	 * 주사위를 굴린 결과는 1 이상 6 이하 숫자이다.
	 * @return 주사위를 굴려 나온 숫자.
	 */
	public int roll() {
		return (random.nextInt(6) + 1);
	}
	
}
