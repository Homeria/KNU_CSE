package week11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class cRecord {

	
	static record[] record;
	
	// �� Ŭ���������� �迭�� SIZE�� �����س�������, ���� �� Ű���� �����۵��Ѵ�.
	// �� �� SIZE�� �Է� �޴� �������� �ְ� ���뷮�̴�.
	private final int SIZE = 1000;
	
	File file;
	Scanner input;
	
	
	/**
	 * ������
	 * �Ķ���ͷ� �ƹ��͵� �־����� �ʾ��� ��, "11����_input_sample.txt" ������ �⺻���� �����Ͽ� ������ �����´�.
	 * @throws FileNotFoundException
	 */
	public cRecord() throws FileNotFoundException {
		
		file = new File("./src/11����_input_sample.txt");
		input = new Scanner(file);
		record = inputData();
	}
	
	
	/**
	 * ������
	 * �Ķ���ͷ� ���� ���� ��ü�� ������ ������ �����´�.
	 * @param file ������ ������ �� �ּҸ� ��� �ִ� ���� ��ü
	 * @throws FileNotFoundException
	 */
	public cRecord(File file) throws FileNotFoundException {
		this.file = file;
		input = new Scanner(file);
		record = inputData();
	}
	
	
	/**
	 * �����ڿ��� ������ Scanner�� ���� record ��ü�� �迭�� ��� ��ȯ�Ѵ�.
	 * @return ������ ������ �� ������ ������ record ��ü�� ���� record Ÿ�� �迭
	 */
	private record[] inputData() {
		
		record[] record = new record[SIZE];
		for(int i = 0; i < SIZE; i++) {
			record[i] = new record();
		}
		
		int count = 0;
		String str;
		String[] strArr;
		try {
			for(int i = 0; i < SIZE; i++) {
				str = input.nextLine();
				strArr = str.split("\t");
				record[i].setGrade(strArr[0].charAt(0));
				record[i].setPenalty(Integer.parseInt(strArr[1]));
				record[i].setName(strArr[2]);
				count++;
			}
		} catch (NoSuchElementException e) {
		} catch (ArrayIndexOutOfBoundsException e) {
		} catch (StringIndexOutOfBoundsException e) {
		}
		
		record[] newRecord = new record[count];
		
		for(int i = 0; i < count; i++) {
			newRecord[i] = record[i];
		}
		return newRecord;
	}
	
	
	/**
	 * ������ ������ ��� �迭�� ����Ѵ�.
	 */
	public void printArray() {
		for(record r : record) {
			System.out.println(r.getGrade() + "\t" + r.getPenalty() + "\t" + r.getName());
		}
	}
	
	
	/**
	 * �迭�� �����Ѵ�.
	 * GRADE�� �������� insertion Sorting ���� �� �迭�� ����ϰ�,
	 * ���ĵ� �迭�� ������ ���ĵ� ������ GRADE ���� Penalty�� �������� Quick Sorting ���� �� �迭�� ����Ѵ�.
	 * Quick Sorting�� ���� GRADE ������ ���ҳ����� �̷������.
	 */
	public void sort() {
		
		insertionSort();
		System.out.println("===== Insertion Sorting result =====");
		System.out.println("GRADE\tPENALTY\tNAME");
		printArray();
		System.out.println("====================================");
		System.out.println();
		
		
		System.out.println("===== Final Sorting result =====");
		System.out.println("GRADE\tPENALTY\tNAME");
		int[] index = getIndex();
		
		for(int i = 0; i < index.length - 1; i++) {
			if (index[i] != index[i + 1] - 1) {
				quickSort(index[i], index[i + 1] - 1);
			}
		}
		quickSort(index[index.length - 1], record.length - 1);
		
		printArray();
		System.out.println("================================");
		System.out.println("Done!");
	}
	
	
	/**
	 * insertion Sorting�� �Ѵ�.
	 * insertion Sorting�� �ϴ� ����(�ּ�)�� �� �޼ҵ忡�� ���Ѵ�.
	 */
	private void insertionSort() {
		for(int previousPos = record.length - 2; previousPos >= 0; previousPos--) {
			insert(previousPos);
		}
	}
	
	
	/**
	 * �Ķ���ͷ� �Է¹��� ����(�ּ�)�� ���� ���� ���������Ѵ�.
	 * @param previousPos �ּڰ�
	 */
	private void insert(int previousPos) {
		record nextVal = record[previousPos];
		while (previousPos < record.length - 1 && (nextVal.getGrade() < record[previousPos + 1].getGrade())) {
			record[previousPos] = record[previousPos + 1];
			previousPos++;
		}
		record[previousPos] = nextVal;
	}
	
	
	/**
	 * Quick Sorting�� �Ѵ�.
	 * �� Quick Sorting�� ���� �� ��ȯ�� pivot index�� ��������
	 * pivot index�� ���ʰ� �������� ��������� Quick Sorting �Ѵ�.
	 * @param first Quick Sorting�� �ϰ��� �ϴ� �迭�� ù ��° �ּ�
	 * @param last Quick Sorting�� �ϰ��� �ϴ� �迭�� ������ �ּ�
	 */
	private void quickSort(int first, int last) {
		if (first < last) {
			int pivIndex = partition(first, last);
			quickSort(first, pivIndex - 1);
			quickSort(pivIndex + 1, last);
		}
		
		
	}
	
	
	/**\
	 * Quick Sorting�� �ϱ� ���� partiton�� ����Ѵ�.
	 * @param first Quick Sorting�� �ϰ��� �ϴ� �迭�� ù ��° �ּ�
	 * @param last Quick Sorting�� �ϰ��� �ϴ� �迭�� ������ �ּ�
	 * @return down�� �ּڰ�
	 */
	private int partition(int first, int last) {
		int up = first;
		int down = last;
		record pivot = record[first];
		record temp;
		do {
			while (true) {
				if ((pivot.getPenalty() < record[up].getPenalty()) || (up == last)) {
					break;
				} else {
					up++;
				}
			}
			while (true) {
				if ((pivot.getPenalty() >= record[down].getPenalty()) || (down == first)) {
					break;
				} else {
					down--;
				}
			}
			if (up < down) {
				temp = record[up];
				record[up] = record[down];
				record[down] = temp;
			}
		} while (up < down);
		temp = record[first];
		record[first] = record[down];
		record[down] = temp;
		
		return down;
	}
	
	
	/**
	 * ���ο� GRADE�� �������� �ּҸ� int Ÿ���� �迭�� ��� �迭�� ��ȯ�Ѵ�.
	 * 11����_input_sample.txt ������ ��������,
	 * GRADE�� F�� ������ ������ 0, GRADE�� D�� ������ ������ 3, GRADE�� C�� ������ ������ 4, GRADE�� B�� ������ ������ 8, GRADE�� A�� ������ ������ 13�̴�.
	 * �̷��� �ּҸ� ���� �迭�� sort() �޼ҵ忡�� �������� ������ ���� �� ���ȴ�.
	 * @return ���ο� GRADE�� �������� �ּҸ� ���� �迭
	 */
	private int[] getIndex() {
		int size = record.length;
		int[] arr = new int[size];
		char[] cArr = new char[size];
		int index = 0;
		char c;
		
		for(int i = 0; i < size; i++) {
			c = record[i].getGrade();
			if (!(isDuplicate(cArr, c))) {
				cArr[index] = c;
				arr[index] = i;
				index++;
			}
		}
		
		int[] newArr = new int[index];
		for(int i = 0; i < newArr.length; i++) {
			newArr[i] = arr[i];
		}
		
		return newArr;
	}
	
	
	/**
	 * �Ķ���ͷ� ���� �迭 �ȿ� �Ķ���ͷ� ���� ���Ұ� �����ϴ����� ���� ��ȯ�Ѵ�.
	 * �̷��� �Ҹ��� ���� getIndex() �޼ҵ忡�� �ش� GRADE�� �������� �˱� ���� ���ȴ�.
	 * @param arr �˻��� �迭
	 * @param c �˻��� ����
	 * @return c�� �迭 �ȿ� ������ true, �ƴϸ� false
	 */
	private boolean isDuplicate(char[] arr, char c) {
		
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] == c) {
				return true;
			}
		}
		return false;
	}
	
	
}
