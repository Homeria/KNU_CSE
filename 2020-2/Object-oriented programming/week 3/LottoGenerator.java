package week3;

import java.util.Random;

/**
 * 로또에 적을 난수 여섯 개를 만들어 주는 클래스
 * @author 차경호
 */
public class LottoGenerator {
	
	private Random random;
	
	
	public LottoGenerator() {
		random = new Random();
	}
	
	
	/**
	 * 로또 복권에 적을 수 여섯 개를 만들어 준다.
	 * @return 여섯 개의 정수가 들어 있는 정수 배열
	 */
	public int[] generateNumbers() {
		int[] array;
		
		array = new int[6];
		
		for(int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(50);
		}
		
		return array;
	}
	

}
