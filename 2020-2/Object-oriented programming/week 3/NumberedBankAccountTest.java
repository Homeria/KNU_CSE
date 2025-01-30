package week3;

/**
 * NumberedBankAccount를 테스트하는 프로그램
 * @author 차경호
 */
public class NumberedBankAccountTest {

	public static void main(String[] args) {
		
		NumberedBankAccount account1 = new NumberedBankAccount(1000);
		NumberedBankAccount account2 = new NumberedBankAccount();
		
		System.out.println(account1);
		System.out.println(account2);
		
		System.out.println("300원 계좌이체 : account1 --> account2");
		account1.transfer(300, account2);
		
		System.out.println(account1);
		System.out.println(account2);
		
		
		
		
	}

}
