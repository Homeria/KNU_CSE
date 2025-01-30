package week9;

import java.util.ArrayList;
import java.util.List;

public class HashTable<K, V> {

	private final int ENTRY;
	List<SingleLinkedList<String>> list;
	int[] count;
	int countSum;
	
	/**
	 * �ʱ� ������
	 */
	public HashTable() {
		ENTRY = 10;
		count = new int[ENTRY];
		countSum = 0;
		list = new ArrayList<SingleLinkedList<String>>();
		setting();
	}
	
	
	/**
	 * �ʱ� SingleLInkedList�� ��� �ִ� ArrayList�� ENTRY��ŭ SingleLinkedList�� �־� �ڸ� �Ҵ��� ���ִ� �޼ҵ�
	 */
	private void setting() {
		for(int i = 0; i < ENTRY; i++) {
			list.add(new SingleLinkedList<String>());
		}
	}
	
	
	/**
	 * �ؽ����̺� ����(���ڿ�)�� �߰��ϱ� ���� �޼ҵ�
	 * @param str �߰��ϰ��� �ϴ� ����(���ڿ�)
	 */
	public void add(String str) {
		
		int index = str.hashCode() % ENTRY;
		SingleLinkedList<String> lList = list.get(index);
		
		lList.add(lList.getSize(), str);
		count[index]++;
		countSum++;
	}
	
	
	/**
	 * �ؽ����̺� �ش� ����(���ڿ�)�� �����ϴ��� �˻��ϴ� �޼ҵ�
	 * @param str �˻��ϰ��� �ϴ� ����(���ڿ�)
	 * @return �ش� ����(���ڿ�)�� �����ϸ� true, �ƴϸ� false
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
	 * �ش� �ؽ����̺��� ��Ʈ���� �ڸ��� ���� Ű ����, �� Ű ������ ������ִ� �޼ҵ�
	 */
	public void printEntry() {
		for(int i = 0; i < ENTRY; i++) {
			if (count[i] != 0) {
				System.out.println("load[" + i + "]=" + count[i] + "/" + countSum);
			}
		}
	}
	
	
	
	
	
}
