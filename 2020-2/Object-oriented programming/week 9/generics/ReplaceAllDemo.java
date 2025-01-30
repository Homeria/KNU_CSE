package w9.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReplaceAllDemo {

	public static void main(String[] args) {
		
		List<Integer> intList = new ArrayList<>();
		intList.add(Integer.valueOf(1));
		intList.add(Integer.valueOf(2));
		intList.add(Integer.valueOf(3));
		intList.add(Integer.valueOf(-1));
		intList.add(Integer.valueOf(3));
		System.out.print("List<Integer> : ");
		System.out.println(intList);
		System.out.println("모든 3을 30으로 교체");
		Collections.replaceAll(intList, 3, 30);
		System.out.println(intList);
		
		
		System.out.println("");
		
		
		List<Float> floatList = new ArrayList<>();
		floatList.add(Float.valueOf((float) 1.0));
		floatList.add(Float.valueOf((float) 2.0));
		floatList.add(Float.valueOf((float) 3.0));
		floatList.add(Float.valueOf((float) -1.0));
		floatList.add(Float.valueOf((float) 3.0));
		System.out.print("List<Float> : ");
		System.out.println(floatList);

		System.out.println("모든 3.0을 30.0으로 교체");
		Collections.replaceAll(floatList, (float) 3.0, (float) 30.0);
		System.out.println(floatList);
		
		
		System.out.println("");
		
		
		List<String> stringList = new ArrayList<>();
		stringList.add("봄");
		stringList.add("여름");
		stringList.add("가을");
		stringList.add("겨울");
		stringList.add("봄");
		stringList.add("봄");
		System.out.println("List<String> : ");
		System.out.println(stringList);
		System.out.println("모든 \"봄\"을 \"여름\"으로 교체");
		Collections.replaceAll(stringList, "봄", "여름");
		System.out.println(stringList);
		
		
		
		
	}

}
