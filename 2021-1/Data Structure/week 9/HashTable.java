package week9;

import java.util.ArrayList;
import java.util.List;

public class HashTable<K, V> {

	private final int ENTRY;
	List<SingleLinkedList<String>> list;
	int[] count;
	int countSum;
	
	/**
	 * 초기 생성자
	 */
	public HashTable() {
		ENTRY = 10;
		count = new int[ENTRY];
		countSum = 0;
		list = new ArrayList<SingleLinkedList<String>>();
		setting();
	}
	
	
	/**
	 * 초기 SingleLInkedList를 담고 있는 ArrayList를 ENTRY만큼 SingleLinkedList를 넣어 자리 할당을 해주는 메소드
	 */
	private void setting() {
		for(int i = 0; i < ENTRY; i++) {
			list.add(new SingleLinkedList<String>());
		}
	}
	
	
	/**
	 * 해시테이블에 원소(문자열)를 추가하기 위한 메소드
	 * @param str 추가하고자 하는 원소(문자열)
	 */
	public void add(String str) {
		
		int index = str.hashCode() % ENTRY;
		SingleLinkedList<String> lList = list.get(index);
		
		lList.add(lList.getSize(), str);
		count[index]++;
		countSum++;
	}
	
	
	/**
	 * 해시테이블에 해당 원소(문자열)가 존재하는지 검사하는 메소드
	 * @param str 검사하고자 하는 원소(문자열)
	 * @return 해당 원소(문자열)가 존재하면 true, 아니면 false
	 */
	public boolean isExist(String str) {
		
		int index = str.hashCode() % ENTRY;
		SingleLinkedList<String> lList = list.get(index);
		Node<String> target = lList.getNode(0);
		
		for(int i = 0; i < lList.getSize(); i++) {
			if ((target.getData()).equals(str)) {
				return true;
			} else {
				target = target.getNext();
			}
		}
		return false;
	}
	
	
	/**
	 * 해당 해시테이블의 엔트리의 자리에 따른 키 개수, 총 키 개수를 출력해주는 메소드
	 */
	public void printEntry() {
		for(int i = 0; i < ENTRY; i++) {
			if (count[i] != 0) {
				System.out.println("load[" + i + "]=" + count[i] + "/" + countSum);
			}
		}
	}
	
	
	
	
	
}
