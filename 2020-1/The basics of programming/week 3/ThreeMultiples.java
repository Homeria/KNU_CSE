package week3;

public class ThreeMultiples {

	public static void main(String[] args) {
		System.out.println("i를 1씩 증가시키면서 i가 3의 배수일 때만 더하는 방식으로 계산");
		int sum  = 0;
		
		for(int i = 1; i <= 100; i++) {
			if ((i % 3) == 0) {
				sum += i;
			}
		}
		System.out.println("1이상 100 이하 3의 배수들의 합 = " + sum);
		
		sum = 0;
		
		System.out.println("i를 3씩 증가시키면서 i를 더하는 방식으로 계산");
		
		for(int i = 3; i <= 100; i += 3) {
			sum += i;
		}
		System.out.println("1 이상 100 이하 3의 배수들의 합 = " + sum);
		
	}

}
