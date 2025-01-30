package w8.dog;

import java.util.ArrayList;
import java.util.List;

// 문제로 제시되는 초기 코드

public class DogTest {
	public static void main(String[] args) {
		
		Dog dog = new Jindo("순둥이", "검정");
		System.out.println(dog);
		System.out.println(dog.getName() + " " + dog.speak());
		System.out.println("진돗개의 평균 무게 : " + dog.getAverageWeight());
		
		dog = new Yorki("귀요미");
		System.out.println(dog);
		System.out.println(dog.getName() + " " + dog.speak());
		System.out.println("요크셔테리어의 평균 무게 : " + dog.getAverageWeight());
		
		List<Dog> dogs = new ArrayList<>();
		dogs.add(new Jindo("순둥이", "검정"));
		dogs.add(new Jindo("막둥이", "하양"));
		dogs.add(new Yorki("귀요미"));
		dogs.add(new Yorki("딸랑이"));
		
		for (Dog d : dogs) {
			System.out.println(d.toString() + " " + d.speak());
		}
		
	}
}