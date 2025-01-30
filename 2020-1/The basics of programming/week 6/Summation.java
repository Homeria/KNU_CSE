package week6;

public class Summation {

	public static void main(String[] args) {

		int sum = 0;
		
		int from = 1, to = 3;
		sum = add(from, to);
		System.out.println(sum);

		from = 1; to = 4;
		sum = add(from, to);
		System.out.println(sum);
		
	}
	
	static int add(int from, int to) {
		int sum = 0;
		for (int i = from; i <= to; i++)
			sum += i;
		return sum;
	}
}