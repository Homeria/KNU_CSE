package w4;

public class BankAccount implements Measurable {

	
	private double balance;
	
	
	/**
	 * 주어진 balance를 가지는 계좌 개설
	 * @param balance 값
	 */
	public BankAccount(double initialBalance) {
		balance = initialBalance;
	}
	
	
	/**
	 * 계좌로 돈을 입금
	 * @param amount 입금할 만큼의 돈
	 */
	public void deposit(double amount) {
		balance += amount;
	}
	
	
	/**
	 * 계좌에서 돈을 인출
	 * @param amount 인출할 만큼의 돈
	 */
	public void withdraw(double amount) {
		balance -= amount;
	}
	
	
	/**
	 * 잔액 리턴
	 * @return 잔액
	 */
	public double getBalance() {
		return balance;
	}


	@Override
	public String toString() {
		return String.format("BankAccount[balance=%.1f]", balance);
	}


	@Override
	public double getMeasure() {
		return balance;
	}
	
}
