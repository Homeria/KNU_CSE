package week1;

import java.util.*;

public class week1 {
	
	public static void main(String[] args) {
		
		// �Է��� ������ �����ϴ� ����Ʈ ����
		List<Integer> list = new ArrayList<Integer>();
		
		// ����ڷκ��� ������ �Է¹ޱ� ���� Scanner ����
		Scanner input = new Scanner(System.in);
		
		// ����ڷκ��� �Է¹��� ������ �ӽ÷� �����ϱ� ���� ���� ����
		int num = 0;
		
		// ����ڰ� ������ ��� �Է����� ���(1000�� �Էµ��� ���)�� �����ϴ� �Ҹ��� Ÿ�� ���� ����
		boolean done = false;
		
		// ����ڰ� ���� 1000 �� �Է��ϱ� ������ ���� �Է¹޾� ����Ʈ�� ���ҷ� �߰���
		while(!done) {
			
			// ����ڷκ��� ������ �Է¹���
			System.out.print("���� �Է� : ");
			num = input.nextInt();
			
			// ���� �Է¹��� ������ 1000 �� �ƴϿ��� ��� ����Ʈ�� �Է¹��� ������ ���ҷ� �߰���
			if (num != 1000) {
				list.add(num);
				
			// ���� �Է¹��� ������ 1000 �̾��� ��� done�� true�� ����� while���� ��������
			} else {
				done = true;
			}
		}
		
		// ����Ʈ�� ����ִ� ������ ���ʷ� �����
		for(int n : list) {
			System.out.println(n);
		}
		
		// Scanner�� ������
		input.close();
	}
}
