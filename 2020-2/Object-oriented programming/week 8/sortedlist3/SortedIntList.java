package w8.sortedlist3;

import java.util.Arrays;
import java.util.NoSuchElementException;

import w8.stutterlist.ArrayIntList;

public class SortedIntList extends ArrayIntList {

	private boolean unique;
	
	/**
	 * 구성자
	 * 원소중복금지(uniqueness)가 false로 설정된 기본 용량을 갖는 리스트를 구성한다.
	 */
	public SortedIntList() {
		this(DEFAULT_CAPACITY);
		unique = false;
	}
	
	
	/**
	 * 구성자
	 * 주어진 값에 따라 원소중복금지(uniqueness) 여부가 정해지는 기본 용량을 갖는 리스트를 구성한다.
	 * @param unique 원소중복금지 여부
	 */
	public SortedIntList(boolean unique) {
		this(DEFAULT_CAPACITY);
		this.unique = unique;
	}
	
	
	/**
	 * 원소중복금지(uniqueness)가 false로 설정된, 주어진 용량을 갖는 리스트를 반환한다.
	 * @param capacity 용량
	 */
	public SortedIntList(int capacity) {
		super(capacity);
		if (capacity < 0) {
			throw new IllegalArgumentException("리스트의 용량은 음수일 수 없습니다 : " + capacity);
		}
		unique = false;
	}
	
	
	/**
	 * 주어진 값에 따라 원소중복금지 여부가 정해지고 주어진 용량을 갖는 리스트를 구성한다.
	 * @param unique 원소중복금지 여부
	 * @param capacity 용량
	 */
	public SortedIntList(boolean unique, int capacity) {
		super(capacity);
		if (capacity < 0) {
			throw new IllegalArgumentException("리스트의 용량은 음수일 수 없습니다 : " + capacity);
		}
		this.unique = unique;
	}
	
	
	/**
	 * 오름차순이 유지되도록 value를 배열에 끼워 넣는다.
	 * 중복금지허용(unique가 true) 상태일 때, value가 들어 있다면 넣지 않는다.
	 * @param value 배열에 끼워넣을 원소.
	 */
	public void add(int value) {
		if (((unique) && !(contains(value))) || (!unique)) {
			int a = Arrays.binarySearch(element, 0, size, value);
			int index;
			if (a < 0) {
				index = -(a + 1);
			} else {
				index = a;
			}
			super.add(index, value);
		}
	}
	
	
	/**
	 * 지원하지 않는 메소드
	 */
	public void add(int index, int value) {
		throw new UnsupportedOperationException();
	}
	
	
	/**
	 * 이 원소가 원소의 중복을 금지하는가?
	 * @return 원소의 중복을 금지한다면 true, 아니면 false.
	 */
	public boolean getUnique() {
		return unique;
	}
	
	
	/**
	 * 주어진 값이 리스트에서 몇 번 방에 있는지 알아본다.
	 * @param value 찾고자 하는 원소
	 * @return value의 인덱스
	 */
	public int indexOf(int value) {
		return Arrays.binarySearch(element, 0, size, value);
	}
	
	
	/**
	 * 이 리스트에서 가장 큰 원소를 반환한다.
	 * 리스트가 비어 있다면 NoSuchElementException 에러를 던진다.
	 * @return 리스트에서 가장 큰 원소
	 */
	public int max() {
		int max = Integer.MIN_VALUE;
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		for (int a : element) {
			if (a > max) {
				max = a;
			}
		}
		return max;
	}

	
	/**
	 * 이 리스트에서 가장 작은 원소를 반환한다.
	 * 리스트가 비어 있다면 NoSuchElementException 에러를 던진다.
	 * @return 리스트에서 가장 작은 원소
	 */
	public int min() {
		int min = Integer.MAX_VALUE;
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		for (int a : element) {
			if (a < min) {
				min = a;
			}
		}
		return min;
	}
	
	
	/**
	 * 이 리스트가 원소의 중복을 금지하는지 여부를 설정한다.
	 * unique가 true가 된다면, 리스트 내에 중복원소들을 제거하여 중복이 없도록 만든다.
	 * @param unique
	 */
	public void setUnique(boolean unique) {
		
		this.unique = unique;
		
		if (unique) {
			for(int i = 0; i < size - 1; i++) {
				if (element[i] == element[i + 1]) {
					remove(i + 1);
					i--;
				}
			}
		}
		
		
	}
	
	
	/**
	 * "S:[-3,7,20]U" 형태의 문자열을 반환한다.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("S:[");
		for(int i = 0; i < size; i++) {
			sb.append(element[i]);
			if (i != size - 1) {
				sb.append(", ");
			}
		}
		sb.append("]");
		if (unique) {
			sb.append("U");
		}
		return sb.toString();
	}
	
	
	
	
	
}
