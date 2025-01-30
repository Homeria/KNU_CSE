package w6.overriding;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Cat implements Comparable<Cat>{

	
	int age;
	String name;
	
	
	public Cat(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	
	
	public int compareTo(Cat other) {
		if (age < other.age) {
			return -1;
		} else if (age > other.age) {
			return 1;
		} else {
			if (name.equals(other.name)) {
				return 0;
			} else {
				return name.compareTo(other.name);
			}
		}
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cat other = (Cat) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
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
		s.add(new Cat(5, "나비"));
		s.add(new Cat(4, "야옹"));
		s.add(new Cat(4, "실눈"));

		
		System.out.println(s);
		
		SortedSet<Cat> ss = new TreeSet<>(new CatComparator());
		ss.addAll(s);
		System.out.println(ss);
		
		ss = new TreeSet<>(s);
		System.out.println(ss);
		
	}

	
	
	
	
}
