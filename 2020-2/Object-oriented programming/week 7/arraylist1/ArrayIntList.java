package w7.arraylist1;
 
import java.util.Arrays;

public class ArrayIntList {

	private static final int DEFAULT_CAPACITY = 10;
	
	private int size;
	private int[] element;
	
	
	public ArrayIntList() {
		element = new int[DEFAULT_CAPACITY];
		size = 0;
	}
	
	
	/**
	 * 주어진 값을 리스트의 마지막에 추가한다.
	 * 만약 배열이 이미 꽉 찬 상태이면 배열의 크기를 늘린다.
	 * @param value 추가할 값
	 */
	public void add(int value) {
		checkResize();
		element[size] = value;
		size++;
	}
	
	
	/**
	 * 주어진 값을 리스트의 주어진 인덱스 방에 삽입한다.
	 * 만약 배열이 이미 꽉 찬 상태이면 배열의 크기를 늘린다.
	 * index는 0 이상, size 이하이어야 한다.
	 * @param index 인덱스
	 * @param value 삽입할 값
	 */
	public void add(int index, int value) {
		checkResize();
		
		for(int i = size - 1; i >= index; i--) {
			element[i + 1] = element[i];
		}
		
		element[index] = value;
		size++;
	}
	
	
	/**
	 * 주어진 인덱스의 값을 읽는다.
	 * 일단, index는 0 이상, size 미만이라고 가정한다.
	 * @param index 인덱스.
	 * @return 읽은 값.
	 */
	public int get(int index) {
		return element[index];
	}
	
	
	/**
	 * 주어진 인덱스의 값을 설정한다.
	 * 일단, index는 0 이상, size 미만이라고 가정한다.
	 * @param index 인덱스.
	 * @param value 값.
	 */
	public void set(int index, int value) {
		element[index] = value;
	}
	
	
	/**
	 * 원소의 수가 얼마인지 알아낸다.
	 * @return 원소의 수
	 */
	public int size() {
		return size;
	}
	
	
	/**
	 * 빈 리스트인가?
	 * @return 빈 리스트인 경우 true, 그렇지 않으면 false.
	 */
	public boolean isEmpty() {
		int count = 0;
		for(int i = 0; i < size; i++) {
			if (element[i] == 0) {
				count++;
			}
		}
		if (count == size) {
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * 주어진 인덱스의 값을 제거하고 그 이후에 있는 값들을 앞으로 한 칸씩 이동한다.
	 * 일단, index는 0 이상, size 미만이라고 가정한다.
	 * @param index 인덱스
	 */
	public void remove(int index) {
		for(int i = index; i < element.length; i++) {
			if (i == element.length - 1) {
				element[i] = 0;
			} else {
				element[i] = element[i + 1];
			}
			
		}
		size--;
	}
	
	
	/*
	 * private helper method.
	 * 배열이 꽉 찼는지 검사하고
	 * 꽉 찬 경우 배열의 크기를 두 배로 늘려준다.
	 */
	private void checkResize() {
		boolean done = false;
		for(int a : element) {
			if (a == 0) {
				done = true;
				break;
			}
		}
		if(!done) {
			element = Arrays.copyOf(element, element.length * 2);
		}
	}
	
	
	/**
	 * 리스트를 아래 형식의 문자열로 반환한다.
	 * "[12, 34, -102, 1]"
	 * 만약 빈 문자열이면 "[]"를 반환한다.
	 */
	public String toString() {
		StringBuilder s = new StringBuilder("[");
		for(int i = 0; i < element.length; i++) {
			if (element[i] != 0) {
				if (i == size - 1) {
					s.append(element[i]);
				} else {
					s.append(element[i] + ", ");
				}
			}
		}
		s.append("]");
		String string = s.toString();
		return string;
	}
	
	
	
	
	
	
}
