package week3;

import java.util.Random;

/**
 * 로또 복권 번호 추천 프로그램. 자바 표준라이브러리 Random을 사용함.
 * @author 차경호
 */
public class LottoNumber {
	
	public static void main(String[] args) {
		
		int[] firstArray = new int[6];
		int[] secondArray = new int[6];
		
		// 첫 구성자(Random())를 사용 시에는 매 반복할 때 마다 값이 달라진다.
		// 예를 들어 {7, 9, 11, 13, 15, 17}의 난수가 만들어지고
		// 다시 반복하면 {8, 10, 12, 14, 16, 18}의 난수가 만들어진다.
		Random firstConstructorRandom = new Random();
		
		// 두 번째 구성자(Random(seed))를 사용 시에는 반복해도 같은 난수가 만들어진다.
		// 예를 들어 {7, 9, 11, 13, 15, 17}의 난수가 만들어졌다면
		// 다시 반복해도 {7, 9, 11, 13, 15, 17}의 난수가 만들어진다.
		Random secondConstructorRandom = new Random(12345678);
		
		for(int i = 0; i < firstArray.length; i++) {
			firstArray[i] = firstConstructorRandom.nextInt(45);
		}
		for(int i = 0; i < firstArray.length; i++) {
			System.out.print(firstArray[i] + " ");
		}
		
		System.out.println("");
		
		for(int i = 0; i < secondArray.length; i++) {
			secondArray[i] = secondConstructorRandom.nextInt(45);
		}
		for(int i = 0; i < secondArray.length; i++) {
			System.out.print(secondArray[i] + " ");
		}
		
		
		
		
	}
	

}
