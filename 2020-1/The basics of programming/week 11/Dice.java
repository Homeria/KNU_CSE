package week11;


/**
 * 주사위를 한 개 혹은 여러 개 던져 나온 수의 합의 분포를 출력하는 프로그램
 * 주사위 개수(NUM_DICE)나 시행 횟수(TRIALS)에 따라 값이 달라지게 됨.
 * @author 차경호
 */
public class Dice {

	public static void main(String[] args) {
		
		final int NUM_DICE = 2;
		final int TRIALS = 10000;
		
		int[] occurence = new int[(NUM_DICE * 6) + 1];
		
		for(int i = NUM_DICE; i < TRIALS; i++) {
			occurence[castDice(NUM_DICE)] += 1;
		}
		
		for(int i = NUM_DICE; i < occurence.length; i++) {
			System.out.println(i + "이(가) 나온 횟수 : " + occurence[i]);
		}
	}
	
	
	/**
	 * 주사위의 개수만큼 주사위를 굴리고, 주사위에서 나온 수들을 합한 값을 반환함
	 * @param numDice 주사위 개수
	 * @return 주사위에서 나온 수들의 총 합
	 */
	public static int castDice(int numDice) {
		int sum = 0;
		for(int i = 0; i < numDice; i++) {
			sum += (int)(Math.random() * 6) + 1;
		}
		return sum;
	}

}
