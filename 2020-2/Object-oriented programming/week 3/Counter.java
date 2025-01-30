package week3;

import java.util.Scanner;


/**
 * 양수와 음수의 입력 횟수에 따라 값을 증가 또는 감소시키고, 0을 입력하면 값을 반환하여 출력하는 프로그램
 * @author 차경호
 *
 */
public class Counter {

	private static int value;
	
	public Counter() {
		value = 0;
	}
	
	public Counter(int value) {
		Counter.value = value;
	}
	
	
	/**
	 * value 값을 1만큼 증가시킨다.
	 */
	public void countUp() {
		value++;
	}
	
	
	/**
	 * value 값을 1만큼 감소시킨다.
	 */
	public void countDown() {
		value--;
	}
	
	
	/**
	 * value 값을 0으로 만든다.
	 */
	public void reset() {
		value = 0;
	}
	
	
	/**
	 * 현재의 value값을 반환한다.
	 * @return value 값
	 */
	public int getValue() {
		return value;
	}
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Counter counter = new Counter();
		int num = -1;
		
		while(num != 0) {
			System.out.print("정수 입력 : ");
			num = input.nextInt();
			if(num > 0) {
				counter.countUp();
			} else if(num < 0) {
				counter.countDown();
			}
		}
		
		System.out.println("Value : " + counter.getValue());
		
		input.close();
		
	}
	
	
}
