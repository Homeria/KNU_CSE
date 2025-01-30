package week3;

/**
 * LottoGenerator를 테스트하기 위한 프로그램.
 * @author 차경호
 *
 */
public class LottoGeneratorTest {

	public static void main(String[] args) {
		
		int[] array;
		
		LottoGenerator lotto = new LottoGenerator();
		
		for (int n = 0; n < 10; n++) {
			array = lotto.generateNumbers();
			for(int i = 0; i < 6; i++) {
				System.out.print(array[i] + " ");
			}
			System.out.println("");
		}
		
		
	}

}
