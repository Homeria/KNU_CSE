package week11;

/**
 * Dice 프로그램에서 나온 총 합의 분포 결과를 그래프로 보여주는 프로그램.
 * 주사위 개수(NUM_DICE)나 시행 횟수(TRIALS)에 따라 총 합이 달라지나,
 * 그래프의 개형은 대체로 비슷하며 시행 횟수가 많을 수록 더 또렷한 모습을 보여줌.
 * @author 차경호
 *
 */
public class DiceGraph {

	public static void main(String[] args) {
		
		final int NUM_DICE = 5;
		final int TRIALS = 10000;
		final int HEIGHT = 50;
		
		int[] occurence = new int[(NUM_DICE * 6) + 1];
		
		//castDice하여 수의 분포도 구하기
		for(int i = NUM_DICE; i < TRIALS; i++) {
			occurence[Dice.castDice(NUM_DICE)] += 1;
		}
		
		// 구한 분포도를 글자로 출력
		for(int i = NUM_DICE; i < occurence.length; i++) {
			System.out.println(i + "이(가) 나온 횟수 : " + occurence[i]);
		}
		
		System.out.println("");
		
		// 구한 분포도를 그래프로 나타냄.
		graph(occurence, HEIGHT, NUM_DICE);
	}
	
	
	/**
	 * 배열 occurence를 그래프로 그린다
	 * 그래프는 별 문자 '*'를 인쇄해 그린다.
	 * 별 문자 하나가 1을 의미한다.
	 * 낮은 번호의 방에는 모두 0이 들어 있으므로 이 방들의 숫자는 그리지 않는다.
	 * n으로 지정된 방 번호 이상의 방에 있는 숫자들만 그래프로 그린다.
	 * 
	 * @param occurence 배열
	 * @param n occurence의 몇번 방부터 그릴 것인가?
	 */
	public static void graph(int[] occurence, int n) {
		StringBuilder sb = new StringBuilder();
		String result;
		for(int i = n; i < occurence.length; i++) {
			for(int j = 0; j < occurence[i]; j++) {
				sb.append('*');
			}
			result = sb.toString();
			System.out.print(i + ":" + occurence[i] + "\t");
			System.out.println(result);
			sb.delete(0, sb.length());
		}
	}
	
	
	/**
	 * 배열 occurence를 그래프로 그린다
	 * 그래프는 별 문자 '*'를 인쇄해 그린다.
	 * 별 문자 하나가 단순히 1을 의미하도록 하면
	 * 배열에 들어 있는 숫자들이 큰 값을 때
	 * 별 문자를 너무 많이 그려야 하므로 (그래프가 너무 커지므로)
	 * 배열에 들어 있는 숫자가 얼마나 큰 수인지에 따라
	 * 별 문자 하나가 의미하는 크기가 조정되도록 한다.
	 * 
	 * height는 배열에 들어 있는 숫자들 중 가장 큰 수를 
	 * 별 문자 몇 개로 표현 할 것인지를 지정해준다.
	 * 배열에 들어 있는 수 중 가장 큰 수가 910이고
	 * height가 50이라면
	 * 별 문자 하나는 910/50 = 18.2를 의미하게 된다.
	 * 
	 * 낮은 번호의 방에는 모두 0이 들어 있으므로 이 방들의 숫자는 그리지 않는다.
	 * from으로 지정된 방 번호 이상의 방에 있는 숫자들만 그래프로 그린다.
	 * 
	 * @param occurence 배열
	 * @param height 그래프의 최대 높이
	 * 					가장 큰 수를 별 문자 몇 개로 그릴 것인가를 나타냄
	 * @param from occurence의 몇번 방부터 그릴 것인가?
	 */
	public static void graph(int[] occurence, int height, int from) {
		StringBuilder sb = new StringBuilder();
		String result;
		double value;
		int max = 0;
		for(int i = 0; i < occurence.length; i++) {
			if (occurence[i] > max) {
				max = occurence[i];
			}
		}
		value = (double)max / height;
		
		for(int i = from; i < occurence.length; i++) {
			for(int j = 0; j < (int)(occurence[i] / value); j++) {
				sb.append('*');
			}
			result = sb.toString();
			System.out.print(i + ":" + occurence[i] + "\t");
			System.out.println(result  + "(" + sb.length() + ")");
			sb.delete(0, sb.length());
		}
	}
	
	
}