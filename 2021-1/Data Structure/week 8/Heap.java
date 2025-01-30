package week8;

public class Heap {
	
	private static final int DEFAULT_CAPACITY = 10;
	
	private int size;
	private int[] array;
	
	
	public Heap() {
		array = new int[DEFAULT_CAPACITY];
		size = 0;
	}
	
	
	/**
	 * 배열의 용량을 필요할 때마다 늘리는 배열 동적 할당을 위한 메소드
	 * @param newCapacity 새로운 배열의 용량
	 */
	private void resize(int newCapacity) {
		int[] newArray = new int[newCapacity];
		
		for(int i = 1; i <= size; i++) {
			newArray[i] = array[i];
		}
		
		this.array = null;
		this.array = newArray;
	}
	
	
	/**
	 * 파라미터로 받은 index를 기준으로 Parent의 주솟값을 반환하는 메소드
	 * @param index 기준이 되는 주솟값
	 * @return index를 기준으로 한 parent의 주솟값
	 */
	private int getParent(int index) {
		return index / 2;
	}
	
	
	/**
	 * 파라미터로 받은 index를 기준으로 LeftChild의 주솟값을 반환하는 메소드
	 * 본 힙 메소드에서는 사용하지 않는 메소드
	 * @param index 기준이 되는 주솟값
	 * @return index를 기준으로 한 LeftChild의 주솟값
	 */
	private int getLeftChild(int index) {
		return index * 2;
	}
	
	
	/**
	 * 파라미터로 받은 index를 기준으로 RightChild의 주솟값을 반환하는 메소드
	 * 본 힙 메소드에서는 사용하지 않는 메소드
	 * @param index 기준이 되는 주솟값
	 * @return index를 기준으로 한 RightChild의 주솟값
	 */
	private int getRightChild(int index) {
		return index * 2 + 1;
	}
	
	
	/**
	 * 파라미터로 받은 value 값을 힙 배열에 추가하는 메소드
	 * @param value 추가하고자 하는 값
	 */
	public void add(int value) {
		if(size + 1 == array.length) {
			resize(array.length * 2);
		}
		up(size + 1, value);
		size++;
	}
	
	
	/**
	 * 파라미터로 받은 value 값을 힙 배열에 추가할 때, 어떤 값과 바꾸어야 하는지 판별하고 바꿔주는 메소드
	 * @param index target의 인덱스
	 * @param target 추가하고자 하는 값
	 */
	private void up(int index, int target) {
		while(index > 1) {
			int parent = getParent(index);
			int parentValue = array[parent];
			
			if(target >= parentValue) {
				break;
			}
			array[index] = parentValue;
			index = parent;
		}
		array[index] = target;
	}
	
	
	/**
	 * 현재 배열에 어떤 원소가 들었는지 출력하는 메소드
	 */
	public void printArray() {
		System.out.print("Heap : [");
		for(int i = 1; i <= size; i++) {
			if (i != size) {
				System.out.print(array[i] + " ");
			} else {
				System.out.print(array[i]);
			}
			
		}
		System.out.print("]");
		System.out.println("");
	}
	
	
	/**
	 * 파라미터로 받은 입력값과 힙의 최솟값을 비교하여 결괏값을 반환하는 메소드
	 * @param target 비교하고자 하는 값
	 * @return target이 힙의 최솟값보다 작다면 true, 아니면 false
	 */
	public boolean examineMin(int target) {
		int n = searchMin();
		if(target > n) {
			return false;
		} else {
			return true;
		}
	}
	
	
	/**
	 * 힙의 최솟값을 찾는 메소드
	 * @return 힙의 최솟값
	 */
	public int searchMin() {
		int n = Byte.MAX_VALUE;
		for(int i = 1; i <= size; i++) {
			if(n > array[i]) {
				n = array[i];
			}
		}
		return n;
	}
}
