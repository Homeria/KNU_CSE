package week3;

public class BankAccountTester {

	public static void main(String[] args) {
		
		BankAccount balance1 = new BankAccount();
		BankAccount balance2 = new BankAccount(1000);
		
		balance1.deposit(500);
		balance1.withdraw(100);
		System.out.println("첫 계좌 잔액 예상액 = 400.0");
		System.out.println("첫 계좌 잔액 = " + balance1.getBalance());
		
		balance2.deposit(500);
		balance2.withdraw(100);
		System.out.println("두 번재 계좌 잔액 예상액 = 1400.0");
		System.out.println("두 번째 계좌 잔액 = " + balance2.getBalance());
		
	}

}
