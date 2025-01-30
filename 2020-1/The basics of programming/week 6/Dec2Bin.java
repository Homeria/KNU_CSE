package week6;

import java.util.Scanner;

/**
 * 10진수를 2진수로 변환한다.
 * 10진수는 1 이상 자연수이어야 한다.
 */
public class Dec2Bin { 
    public static void main(String[] args) { 

    	System.out.print("자연수 하나를 십진수로 입력하시오: ");
    	Scanner input = new Scanner(System.in);
    	int n = input.nextInt();

    	// power <-- 2의 거듭제곱수.
    	// n보다 작거나 같은 2의 거듭제곱수들 중 가장 큰 수를 구하여 power에 저장한다.
    	// n이 10이면 power는 2^3=8 (2^3은 2의 세제곱이라는 의미)
    	// n이 8이면 power는 2^3=8
    	// n이 22이면 power는 2^4=16
    	// n이 1이면 power는 2^0=1
        int power = 1;
        while (power <= n/2) {
            power *= 2;
        }
  
        // 2의 거듭제곱수들이 n에 들어 있는지 검사한다.
        // 가장 큰 거듭제곱수부터 시작하여 점점 작은 거듭제곱수를 차례로 검사한다.
        while (power > 0) {

            // power가 n에 들어 있지 않으면 0을 출력한다. 
            if (n < power) 
                System.out.print(0);

            // power가 n에 들어 있으면 1을 출력하고 n에서 power를 뺀다.
            else {
                System.out.print(1);
                n -= power;
            }

            // 다음으로 작은 2의 거듭제곱수
            power /= 2;
        }

        System.out.println();
        input.close();
    }

}
