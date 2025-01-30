package week10;

import java.util.*;

public class Table<E extends Comparable<E>> {
	
	ArrayList<ArrayList<E>> list = new ArrayList<ArrayList<E>>();
	
	/**
	 * ������
	 */
	public Table() {
		
	}
	
	
	/**
	 * ������
	 * @param input ������ �����͸� ���� �� �ִ� ��ĳ��
	 */
	public Table(Scanner input) {
		list = makeList(input);
	}
	
	
	/**
	 * ������ �����͸� ���� �� �ִ� ��ĳ�ʸ� ���� 2�������� �����͸� �����Ѵ�.
	 * @param input ������ �����͸� ���� �� �ִ� ��ĳ��
	 * @return ������ �����͸� 2�������� ��� �ִ� ArrayList
	 */
	private ArrayList<ArrayList<E>> makeList(Scanner input) {
		ArrayList<ArrayList<E>> list = new ArrayList<ArrayList<E>>();
		ArrayList<E> littleList;
		String str;
		String[] strArr;
		
		try {
			for(int i = 0; i < 100; i++) {
				str = input.nextLine();
				strArr = str.split("\t");
				littleList = new ArrayList<E>();
				for(String s : strArr) {
					littleList.add((E) s);
				}
				list.add(littleList);
			}
		} catch (NoSuchElementException e) {
		}
		return list;
	}
	
	
	/**
	 * 2���� ����Ʈ�� ������ ���̺��� ����ϴ� �޼ҵ�
	 */
	public void printTable() {
		printList();
	}
	
	public void printTable(int index) {
		for(int i = 0; i < index; i++) {
			System.out.print("\t");
		}
		System.out.println("[v]");
		printList();
	}
	
	
	/**
	 * 2���� ����Ʈ�� ����ϴ� �޼ҵ�
	 */
	private void printList() {
		int rowSize = list.size();
		int colSize = list.get(0).size();
		
		for(int i = 0; i < rowSize; i++) {
			for(int j = 0; j < colSize; j++) {
				System.out.print(list.get(i).get(j) + "\t");
			}
			System.out.println("");
		}
	}
	
	
	/**
	 * 2���� ����Ʈ���� index ���� �����͸� �̰� ��Ƽ� ArrayList�� ��ȯ�Ѵ�.
	 * @param index �����͸� ���� ���� �ּ�
	 * @return ���� �����͸� ��� �ִ� ArrayList
	 */
	private ArrayList<E> makeList(int index) {
		int size = list.size();
		ArrayList<E> arrList = new ArrayList<E>();
		
		for(int i = 0; i < size; i++) {
			arrList.add(list.get(i).get(index));
		}
		return arrList;
	}
	
	
	/**
	 * �����͸� �̾� ������ ����Ʈ�� �ʵ忡 �ִ� ����Ʈ�� �����ϴ� �޼ҵ�
	 * @param index ������ ����Ʈ �� �ּ�
	 * @param arrList ������ �����Ͱ� ��� ����Ʈ
	 */
	private void applyList(int index, ArrayList<E> arrList) {
		int size = list.size();
		for(int i = 0; i < size; i++) {
			list.get(i).set(index, arrList.get(i));
		}
	}
	
	
	/**
	 * ����Ʈ�� ���������ϴ� �޼ҵ�
	 * @param index ������ ����Ʈ�� �� �ּ�
	 */
	public void selectionSort(int index) {
		
		int size = list.size();
		int smallIndex = 0;
		int comp = 0;
		E posMin = null;
		E target1 = null;
		E target2 = null;
		
		ArrayList<E> arrList = makeList(index);
		
		for(int i = 0; i < size; i++) {
					
			target1 = arrList.get(i);
			posMin = target1;
			
			for(int j = i + 1; j < size; j++) {
				target2 = arrList.get(j);
				comp = posMin.compareTo(target2);
				if (comp > 0) {
					
					posMin = target2;
					smallIndex = j;
				}
			}
			if (posMin.equals(target1)) {
			} else {
				arrList.set(i, posMin);
				arrList.set(smallIndex, target1);
			}
		}
		
		applyList(index, arrList);
	}
	
	
	/**
	 * ����Ʈ�� ���������ϴ� �޼ҵ�
	 * @param index ������ ����Ʈ�� �� �ּ�
	 */
	public void bubbleSort(int index) {
		
		int size = list.size();
		
		int count = 0;
		E target1 = null;
		E target2 = null;
		int comp = 0;
		
		ArrayList<E> arrList = makeList(index);
		
		do {
			count = 0;
			for(int i = 0; i < size - 1; i++) {
				target1 = arrList.get(i);
				target2 = arrList.get(i + 1);
				
				comp = target1.compareTo(target2);
				
				if (comp > 0) {
					arrList.set(i, target2);
					arrList.set(i + 1, target1);
					count++;
				}
			}
		} while (count != 0);
		
		applyList(index, arrList);
	}
	
}
