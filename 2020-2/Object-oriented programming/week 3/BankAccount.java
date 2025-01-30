package week3;

/**
 * 은행 계좌 잔액을 관리하는 프로그램.
 * 인출, 입금, 잔액확인이 가능하다.
 * @author 차경호
 *
 */
public class BankAccount {

	private double balance;
	
	/**
	 * 잔액이 0.0인 계좌를 구성한다.
	 */
	public BankAccount() {
		balance = 0.0;
	}
	
	
	/**
	 * 주어진 금액을 초기 잔액으로 갖는 계좌를 구성한다.
	 * @param initialBalance 초기 잔액
	 */
	public BankAccount(double initialBalance) {
		this.balance = initialBalance;
	}
	
	
	/**
	 * 계좌에 입금한다.
	 * @param amount 입금할 금액
	 */
	public void deposit(double amount) {
		balance = balance + amount;
	}
	
	
	/**
	 * 계좌에서 출금한다.
	 * @param amount 출금할 금액
	 */
	public void withdraw(double amount) {
		balance = balance - amount;
	}
	
	
	/**
	 * 잔액이 얼마인지 알아본다.
	 * @return 잔액
	 */
	public double getBalance() {
		return balance;
	}
	
	
	
	
	
	
	
}
