package w7;

import w7.arraylist1.ArrayIntList;

public class UseList1 {

	public static void main(String[] args) {
		
		ArrayIntList arrayIntList = new ArrayIntList();
		
		System.out.println("add(index, value)를 이용하여 배열을 꽉 채운다.");
		for(int i = 1; i <= 10; i++) {
			arrayIntList.add(i - 1, i);
		}
		System.out.println(arrayIntList);
		
		System.out.println("add(value)를 이용하여 원소 하나를 추가한다.");
		arrayIntList.add(20);
		System.out.println(arrayIntList);
		
		System.out.println("set(index, value)를 이용하여 9분 방에 11을 set 한다.");
		arrayIntList.set(9,  11);
		System.out.println(arrayIntList);
		
		System.out.println("size() 테스트");
		System.out.println("원소 수 = " + arrayIntList.size());
		
		System.out.println("remove(index)를 이용하여 원소를 모두 삭제한다.");
		int size = arrayIntList.size();
		for(int i = 0; i < size; i++) {
			arrayIntList.remove(0);
		}
		System.out.println(arrayIntList);
		
		System.out.println("isEmpty() 테스트");
		System.out.println("모두 삭제되었나? " + arrayIntList.isEmpty());
		
		
		
		
	}

}
