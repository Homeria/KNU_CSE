package week3;

/**
 * Dice를 테스트하기 위해 만들어진 프로그램
 * Dice의 roll 메소드를 호출하여 결과를 1000번 호출하여 나온 값의 빈도를 출력함
 * @author 차경호
 */
public class DiceCasting2 {

	public static void main(String[] args) {
		
		Dice dice = new Dice();
		
		int[] array = new int[12];
		
		for(int i = 1; i <= 1000; i++) {
			array[dice.roll() - 1]++;
		}
		
		for(int i = 0; i < array.length; i++) {
			System.out.println((i + 1) + " : " + array[i]);
		}
		
	}

}
