package week10;

import java.util.*;

public class Table<E extends Comparable<E>> {
	
	ArrayList<ArrayList<E>> list = new ArrayList<ArrayList<E>>();
	
	/**
	 * 생성자
	 */
	public Table() {
		
	}
	
	
	/**
	 * 생성자
	 * @param input 파일의 데이터를 읽을 수 있는 스캐너
	 */
	public Table(Scanner input) {
		list = makeList(input);
	}
	
	
	/**
	 * 파일의 데이터를 읽을 수 있는 스캐너를 통해 2차원으로 데이터를 저장한다.
	 * @param input 파일의 데이터를 읽을 수 있는 스캐너
	 * @return 파일의 데이터를 2차원으로 담고 있는 ArrayList
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
	 * 2차원 리스트로 구성된 테이블을 출력하는 메소드
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
	 * 2차원 리스트를 출력하는 메소드
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
	 * 2차원 리스트에서 index 열의 데이터를 뽑고 모아서 ArrayList로 반환한다.
	 * @param index 데이터를 뽑을 열의 주소
	 * @return 뽑은 데이터를 담고 있는 ArrayList
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
	 * 데이터를 뽑아 정렬한 리스트를 필드에 있는 리스트에 적용하는 메소드
	 * @param index 적용할 리스트 열 주소
	 * @param arrList 적용할 데이터가 담긴 리스트
	 */
	private void applyList(int index, ArrayList<E> arrList) {
		int size = list.size();
		for(int i = 0; i < size; i++) {
			list.get(i).set(index, arrList.get(i));
		}
	}
	
	
	/**
	 * 리스트를 선택정렬하는 메소드
	 * @param index 정렬할 리스트의 열 주소
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
	 * 리스트를 버블정렬하는 메소드
	 * @param index 정렬할 리스트의 열 주소
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
