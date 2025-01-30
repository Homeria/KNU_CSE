package w4;

import java.util.Random;

public class DataSetTester {
	
	static Random random = new Random();

	public static void main(String[] args) {
		new DataSetTester().test();

	}
	
	
	private void test() {
		
		DataSet dataSet = new DataSet();
		Rectangle rectangle;
		
		for(int i = 0; i < 100; i++) {
			rectangle = new Rectangle(random.nextDouble() * 100, random.nextDouble() * 100);
			dataSet.add(rectangle);
		}
		
		System.out.println("면적이 가장 큰 Rectangle : " + dataSet.getMaximum());
		System.out.println(String.format("면적이 가장 큰 Rectangle의 면적 : %.1f", dataSet.getMaximum().getMeasure()));
		System.out.println(String.format("면적의 평균 : %.1f", dataSet.getAverage()));
		
		
		System.out.println("");
		
		
		DataSet dataSet2 = new DataSet();
		BankAccount bankAccount;
		
		for(int i = 0; i < 100; i++) {
			bankAccount = new BankAccount(random.nextDouble() * 10000);
			dataSet2.add(bankAccount);
		}
		
		System.out.println("가장 잔액이 많은 계좌 : " + dataSet2.getMaximum());
		System.out.println("가장 잔액이 적은 계좌 : " + dataSet2.getMinimum());
		System.out.println(String.format("잔액의 평균 : %.1f", dataSet2.getAverage()));
		
		
		
		
		
		
	}
	

}
