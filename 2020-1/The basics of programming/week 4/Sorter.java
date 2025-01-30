package week4;

import java.util.Scanner;

/**
 * 본 프로그램은 세 개의 정수를 입력받아 오름차순으로 정렬하여 출력하는 프로그램입니다.
 * 세 개의 정수를 3번 비교하여 오름차순으로 정렬한다는 특징이 있습니다.
 * @author 차경호
 */

public class Sorter {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("세 개의 정수를 입력하세요 : ");
		int i = input.nextInt();
		int j = input.nextInt();
		int k = input.nextInt();
		int temp;
		input.close();
		
		if (i > j) {
			temp = i;
			i = j;
			j = temp;
		}
		
		if(i > k) {
			temp = i;
			i = k;
			k = temp;
		}
		
		if(j > k) {
			temp = j;
			j = k;
			k = temp;
		}
		
		System.out.printf("%d %d %d", i, j, k);
		
		
		
	}

}
