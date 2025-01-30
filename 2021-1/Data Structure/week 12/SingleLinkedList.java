package week12;

public class SingleLinkedList<E> {
	
	private Node<E> head = null;
	private int size;
	
	public SingleLinkedList() {
		head = null;
		size = 0;
	}
	
	public void addFirst(E item) {
		head = new Node<E>(item, head);
		size++;
	}
	
	public void traverse() {
		Node<E> nodeRef = head;
		while(nodeRef != null) {
			if (nodeRef.next != null) {
				System.out.println(nodeRef.data);
				System.out.println(" ==> ");
			} else {
				System.out.println(nodeRef.data);
			}
			nodeRef = nodeRef.next;
		}
	}
	
	public E get(int index) {
		Node<E> node = getNode(index);
		return node.data;
	}
	
	public E set(int index, E newValue) {
		Node<E> node = getNode(index);
		E result = node.data;
		node.data = newValue;
		return result;
	}
	
	public boolean remove(int index) {
		Node<E> curr = head;
		if(index == 0) {
			head = head.next;
			return true;
		} else {
			for(int i = 1; i < index; i++) {
				if(curr.getNext() == null) {
					return false;
				}
				curr = curr.getNext();
			}
			curr.setNext(curr.getNext());
			size--;
			return true;
		}
	}
	
	
	public void add(int index, E item) {
		if(index == 0) {
			addFirst(item);
		} else {
			Node<E> node = getNode(index - 1);
			addAfter(node, item);
		}
	}
	
	private Node<E> getNode(int index) {
		Node<E> node = head;
		for(int i = 0; i < index && node != null; i++) {
			node = node.next;
		}
		return node;
	}
	
	public void addAfter(Node<E> node, E item) {
		node.next = new Node<E>(item, node.next);
		size++;
	}
	
	public int getSize() {
		return size;
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < size; i++) {
			sb.append(getNode(i).data + " ");
		}
		
		return sb.toString();
	}
	
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}
	
}
