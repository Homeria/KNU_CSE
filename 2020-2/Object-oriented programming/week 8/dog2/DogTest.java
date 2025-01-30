package w8.dog2;

import java.util.HashSet;
import java.util.Set;

// 문제로 제시되는 초기 코드

public class DogTest {
	public static void main(String[] args) {
		
		Set<Jindo> dogs = new HashSet<>();
		dogs.add(new Jindo("순둥이", "검정"));
		dogs.add(new Jindo("순둥이", "하양"));
		dogs.add(new Jindo("막둥이", "하양"));
		dogs.add(new Jindo("막둥이", "하양"));
		System.out.println(dogs);
	}
}