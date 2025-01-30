package week2;

public class NameCatTest {

	public static void main(String[] args) {

		NameCat c1, c2;	// ��������

		c1 = new NameCat();
		c2 = new NameCat();

		c1.setName("왕눈이");
		c2.setName("방울이");

		System.out.println(c1.getName());
		System.out.println(c2.getName()); 

	}
}

