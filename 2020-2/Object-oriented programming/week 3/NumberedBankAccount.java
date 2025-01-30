package week3;

/**
 * BankAccount를 수정하여 스태틱 필드를 이용하는 은행 계좌 관리 프로그램
 * 인출, 입금, 계좌이체, 잔액확인이 가능하다.
 * @author 차경호
 */
public class NumberedBankAccount {

	private int accountNumber;
	private double balance;
	private static int nextAccountNumber = 100;
	
	/**
	 * 잔액이 0.0인 계좌를 구성한다.
	 */
	public NumberedBankAccount() {
		balance = 0.0;
		accountNumber = ++nextAccountNumber;
	}
	
	
	/**
	 * 주어진 금액을 초기 잔액으로 갖는 계좌를 구성한다.
	 * @param initialBalance 초기 잔액
	 */
	public NumberedBankAccount(double initialBalance) {
		this.balance = initialBalance;
		accountNumber += nextAccountNumber;
	}
	
	
	/**
	 * 계좌번호를 읽는다.
	 * @return 계좌번호
	 */
	public int getAccountNumber() {
		return accountNumber;
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
	
	
	/**
	 * 다른 계좌로 amount만큼 계좌이체한다(송금한다.)
	 * @param amount 송금할 금액
	 * @param other 돈을 받을 계좌
	 */
	public void transfer(double amount, NumberedBankAccount other) {
		balance = balance - amount;
		other.balance = other.balance + amount;
	}
	
	
	@Override
	public String toString() {
		return "NumberedBankAccount [accountNumber=" + accountNumber + ", balance=" + balance + "]";
	}
	
	
}
