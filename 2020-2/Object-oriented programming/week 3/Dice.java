package week3;

/**
 * Die를 이용하여 두 개의 주사위를 굴렸을 때의 수의 합을 만드는 프로그램
 * @author 차경호
 */
public class Dice {
	
	private Die die1;
	private Die die2;
	
	/**
	 * 구성자
	 */
	public Dice() {
		die1 = new Die();
		die2 = new Die();
	}
	
	
	/**
	 * 두 개의 주사위를 굴린다.
	 * @return 두 주사위를 굴려 나온 숫자의 합
	 */
	public int roll() {
		return (die1.roll() + die2.roll());
	}

}
