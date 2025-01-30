package week3;

public class myStack <E> {
	
	SinglyLinkedList<E> list;;
	int n = 0;
	
	public myStack() {
		list = new SinglyLinkedList<>();
	}

	public void push(E item) {
		list.add(n, item);
		n++;
	}
	
	public Object pop() {
		Object obj = peek();
		list.remove(n - 1);
		n--;
		return obj;
	}
	
	public Object peek() {
		if (n != 0) {
			return list.get(n - 1);
		} else {
			return null;
		}
	}
	
	public boolean empty() {
		if (n == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getSize() {
		return n;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = n - 1; i >= 0; i--) {
			sb.append("[" + list.get(i) + "]");
			if (i != 0) {
				sb.append("\n");
			}
		}
		return sb.toString();
	}
	
}
