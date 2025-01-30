package week3;


/**
 * Dice를 테스트하기 위해 만들어진 프로그램
 * Dice의 roll 메소드를 호출하여 결과를 화면에 출력하는 작업을 20회 반복함
 * @author 차경호
 */
public class DiceCasting1 {

	public static void main(String[] args) {
		
		Dice dice = new Dice();
		
		for(int i = 0; i < 20; i++) {
			System.out.println(dice.roll());
		}
		
	}

}
