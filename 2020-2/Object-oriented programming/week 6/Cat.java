package w6;

import java.util.HashSet;
import java.util.Set;

public class Cat {

	int age;
	String name;
	
	public Cat(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Cat [age=" + age + ", name=" + name + "]";
	}
	
	public static void main (String[] args) {
		
		// 설명
		// 집합(Set)의 특성 상 중복된 원소가 존재할 수 없다.
		// 그러나 첫 번째로 추가한 Cat 객체와 세 번째로 추가한 Cat 객체는
		// 각자 new라는 것으로 개별된 객체로 만들었기 때문에 두 객체는 각각 다른 메모리에 존재하므로,
		// 두 객체가 같은 메모리에 있는지 검사하는 equals 메소드를 사용하여 둘을 비교한다면 false가 반환될 것이다.
		// 그러므로 첫 번째로 추가한 Cat, 세 번째로 추가한 Cat 각각의 객체는 중복된 원소가 아니므로, 
		// Set에 추가하였을 때, 중복처리가 되지 않고, 세 번째로 추가한 객체가 정상적으로 추가되는 것이다.
		
		Set<Cat> s = new HashSet<>();
		s.add(new Cat(1, "나비"));
		s.add(new Cat(2, "왕눈"));
		s.add(new Cat(1, "나비"));
		System.out.println(s);
	}
	
	
}
