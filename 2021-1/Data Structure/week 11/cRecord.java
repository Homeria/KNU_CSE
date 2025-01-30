package week11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class cRecord {

	
	static record[] record;
	
	// 본 클래스에서는 배열의 SIZE를 설정해놓았지만, 값을 더 키워도 정상작동한다.
	// 즉 이 SIZE는 입력 받는 데이터의 최고 수용량이다.
	private final int SIZE = 1000;
	
	File file;
	Scanner input;
	
	
	/**
	 * 생성자
	 * 파라미터로 아무것도 주어지지 않았을 때, "11주차_input_sample.txt" 파일이 기본으로 설정하여 내용을 가져온다.
	 * @throws FileNotFoundException
	 */
	public cRecord() throws FileNotFoundException {
		
		file = new File("./src/11주차_input_sample.txt");
		input = new Scanner(file);
		record = inputData();
	}
	
	
	/**
	 * 생성자
	 * 파라미터로 받은 파일 객체로 파일의 내용을 가져온다.
	 * @param file 내용을 가지고 올 주소를 담고 있는 파일 객체
	 * @throws FileNotFoundException
	 */
	public cRecord(File file) throws FileNotFoundException {
		this.file = file;
		input = new Scanner(file);
		record = inputData();
	}
	
	
	/**
	 * 생성자에서 생성된 Scanner를 통해 record 객체로 배열에 담아 반환한다.
	 * @return 내용을 가지고 올 파일의 내용을 record 객체로 담은 record 타입 배열
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
	 * 파일의 내용이 담긴 배열을 출력한다.
	 */
	public void printArray() {
		for(record r : record) {
			System.out.println(r.getGrade() + "\t" + r.getPenalty() + "\t" + r.getName());
		}
	}
	
	
	/**
	 * 배열을 정렬한다.
	 * GRADE를 기준으로 insertion Sorting 진행 후 배열을 출력하고,
	 * 정렬된 배열을 가지고 정렬된 각각의 GRADE 마다 Penalty를 기준으로 Quick Sorting 진행 후 배열을 출력한다.
	 * Quick Sorting은 같은 GRADE 사이의 원소끼리만 이루어진다.
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
	 * insertion Sorting을 한다.
	 * insertion Sorting을 하는 기준(주소)을 이 메소드에서 정한다.
	 */
	private void insertionSort() {
		for(int previousPos = record.length - 2; previousPos >= 0; previousPos--) {
			insert(previousPos);
		}
	}
	
	
	/**
	 * 파라미터로 입력받은 기준(주소)에 따라 값을 삽입정렬한다.
	 * @param previousPos 주솟값
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
	 * Quick Sorting을 한다.
	 * 이 Quick Sorting은 실행 후 반환된 pivot index를 기준으로
	 * pivot index의 왼쪽과 오른쪽을 재귀적으로 Quick Sorting 한다.
	 * @param first Quick Sorting을 하고자 하는 배열의 첫 번째 주소
	 * @param last Quick Sorting을 하고자 하는 배열의 마지막 주소
	 */
	private void quickSort(int first, int last) {
		if (first < last) {
			int pivIndex = partition(first, last);
			quickSort(first, pivIndex - 1);
			quickSort(pivIndex + 1, last);
		}
		
		
	}
	
	
	/**\
	 * Quick Sorting을 하기 위한 partiton을 담당한다.
	 * @param first Quick Sorting을 하고자 하는 배열의 첫 번째 주소
	 * @param last Quick Sorting을 하고자 하는 배열의 마지막 주소
	 * @return down의 주솟값
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
	 * 새로운 GRADE의 시작점의 주소를 int 타입의 배열에 모아 배열을 반환한다.
	 * 11주차_input_sample.txt 파일을 기준으로,
	 * GRADE가 F인 원소의 시작은 0, GRADE가 D인 원소의 시작은 3, GRADE가 C인 원소의 시작은 4, GRADE가 B인 원소의 시작은 8, GRADE가 A인 원소의 시작은 13이다.
	 * 이러한 주소를 담은 배열은 sort() 메소드에서 시작점과 끝점을 잡을 때 사용된다.
	 * @return 새로운 GRADE의 시작점의 주소를 담은 배열
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
	 * 파라미터로 받은 배열 안에 파라미터로 받은 원소가 존재하는지에 대해 반환한다.
	 * 이러한 불리언 값은 getIndex() 메소드에서 해당 GRADE의 시작점을 알기 위해 사용된다.
	 * @param arr 검사할 배열
	 * @param c 검사할 원소
	 * @return c가 배열 안에 있으면 true, 아니면 false
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
