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
	 * �迭�� �뷮�� �ʿ��� ������ �ø��� �迭 ���� �Ҵ��� ���� �޼ҵ�
	 * @param newCapacity ���ο� �迭�� �뷮
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
	 * �Ķ���ͷ� ���� index�� �������� Parent�� �ּڰ��� ��ȯ�ϴ� �޼ҵ�
	 * @param index ������ �Ǵ� �ּڰ�
	 * @return index�� �������� �� parent�� �ּڰ�
	 */
	private int getParent(int index) {
		return index / 2;
	}
	
	
	/**
	 * �Ķ���ͷ� ���� index�� �������� LeftChild�� �ּڰ��� ��ȯ�ϴ� �޼ҵ�
	 * �� �� �޼ҵ忡���� ������� �ʴ� �޼ҵ�
	 * @param index ������ �Ǵ� �ּڰ�
	 * @return index�� �������� �� LeftChild�� �ּڰ�
	 */
	private int getLeftChild(int index) {
		return index * 2;
	}
	
	
	/**
	 * �Ķ���ͷ� ���� index�� �������� RightChild�� �ּڰ��� ��ȯ�ϴ� �޼ҵ�
	 * �� �� �޼ҵ忡���� ������� �ʴ� �޼ҵ�
	 * @param index ������ �Ǵ� �ּڰ�
	 * @return index�� �������� �� RightChild�� �ּڰ�
	 */
	private int getRightChild(int index) {
		return index * 2 + 1;
	}
	
	
	/**
	 * �Ķ���ͷ� ���� value ���� �� �迭�� �߰��ϴ� �޼ҵ�
	 * @param value �߰��ϰ��� �ϴ� ��
	 */
	public void add(int value) {
		if(size + 1 == array.length) {
			resize(array.length * 2);
		}
		up(size + 1, value);
		size++;
	}
	
	
	/**
	 * �Ķ���ͷ� ���� value ���� �� �迭�� �߰��� ��, � ���� �ٲپ�� �ϴ��� �Ǻ��ϰ� �ٲ��ִ� �޼ҵ�
	 * @param index target�� �ε���
	 * @param target �߰��ϰ��� �ϴ� ��
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
	 * ���� �迭�� � ���Ұ� ������� ����ϴ� �޼ҵ�
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
	 * �Ķ���ͷ� ���� �Է°��� ���� �ּڰ��� ���Ͽ� �ᱣ���� ��ȯ�ϴ� �޼ҵ�
	 * @param target ���ϰ��� �ϴ� ��
	 * @return target�� ���� �ּڰ����� �۴ٸ� true, �ƴϸ� false
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
	 * ���� �ּڰ��� ã�� �޼ҵ�
	 * @return ���� �ּڰ�
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
