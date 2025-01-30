package week7;

/**
 * Cat 클래스에 있는 명령어들을 불러와 실행시키는 프로그램.
 * @author 차경호
 *
 */
public class Test {

	public static void main(String[] args) {
		
		Cat c1 = new Cat();
		Cat c2 = new Cat();
		
		c1.yaong();
		c1.groom();
		c2.yaong();
		c2.groom();
		
	}

}
