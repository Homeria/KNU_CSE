package w7;

import w7.arraylist2.ArrayIntList;

public class UseList2 {

	public static void main(String[] args) {
		
		ArrayIntList list;
		
		try {
			list = new ArrayIntList(-1);
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
		
		list = new ArrayIntList();
		list.add(12);
		list.add(-9);
		list.add(33);
		list.add(1024);
		
		System.out.println(list);
		
		list.add(0, 121);
		list.add(3, 444);
		list.remove(1);
		System.out.println(list);
		
		System.out.println("33의 인덱스 = " + list.indexOf(33));
		System.out.println("33을 포함하나? " + list.contains(33));
		System.out.println("333을 포함하나? " + list.contains(333));
		
		System.out.println("");
		
		int[] array = {-1, 6, 6, 6};
		for(int a : array) {
			try {
				System.out.println(list.get(a));
				
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
		
		
		
	}

}
