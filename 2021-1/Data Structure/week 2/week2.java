package week2;

import java.util.*;

public class week2 {
	
	/**
	 * �Է¹��� ���ڿ����� �����ϱ� ���� LinkedList�� ����
	 * ������ ������ �Ķ���ͷ� �޾� ����Ʈ�� ���Ҹ� �����ϴ� removeInterval �Լ���
	 * LinkedList�� ����ϴ� printList �Լ����� LinkedList�� �Ķ���ͷ� ���� ������
	 * �� �Լ����� �̿��ϱ� ���� �ʵ忡 ������
	 */
	static LinkedList<String> list = new LinkedList<>();

	
	public static void main(String[] args) {
		
		// ����ڷκ��� ���ڿ��� �Է¹ޱ� ���� Scanner ����
		Scanner input = new Scanner(System.in);
		
		// ����ڷκ��� �Է¹��� ���ڿ��� �ӽ÷� �����ϱ� ���� ���� ����
		String data = null;
		
		// ����ڰ� LinkedList���� ������ ������ ������ ���� �����͸� �ӽ� �����ϱ� ���� ���� ����
		int start, end;
		
		// ����ڷκ��� ���ڿ� "end"�� �ԷµǾ��°��� �Ǻ��ϱ� ���� boolean Ÿ�� ���� ����
		boolean done = false;
		
		// ����ڰ� ���ڿ� "end"�� �Է����� ���� ���� ����
		while(!done) {
			
			// ����ڷκ��� ���ڿ��� �Է¹޾� ���ڿ� ���� data�� �ӽ� ������
			System.out.print("���� �� �Է� : ");
			data = input.next();
			
			// ����ڷκ��� �Է¹��� ���ڿ��� "end"�� �ƴ϶��
			if (!(data.equals("end"))) {
				// LinkedList�� ����ڷκ��� �Է¹��� data�� ���ҷ� �߰�
				list.add(data);
			// ����ڷκ��� �Է¹��� ���ڿ��� "end"���
			} else {
				done = true;
			}
			// LinkedList�� ���Ҹ� ���
			printList();
		}
		
		// ����ڰ� LinkedList���� ������ ������ ������ �Է¹���
		System.out.print("start value : ");
		start = input.nextInt();
		System.out.print("end value : ");
		end = input.nextInt();
		// ����ڰ� ���ϴ� ������ ���Ҹ� ����
		removeInterval(start, end);
		
		// LinkedList�� ���Ҹ� ���
		printList();
		
		// ����ڷκ��� �Է��� �޴� Scanner�� ����
		input.close();
	}
	
	
	/**
	 * �Ķ���ͷ� ���� start�� end�� ������ŭ LinkedList�� ���Ҹ� ������
	 * @param start ����
	 * @param end ��
	 */
	public static void removeInterval(int start, int end) {
		for(int i = start; i <= end; i++) {
			list.remove(start - 1);
		}
	}
	
	/**
	 * LinkedList�� ���
	 */
	public static void printList() {
		ListIterator<String> iter = list.listIterator();
		String last = list.getLast();
		String s;
		while(iter.hasNext()) {
			s = iter.next();
			System.out.print(s);
			if (!(s.equals(last))) {
				System.out.print(" -> ");
			}
		}
		System.out.println();
	}

}
