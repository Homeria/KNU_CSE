package week3;

public class Node <E>{

	public E data;
	public Node<E> next;
	
	public Node(E dataItem) {
		data = dataItem;
		next = null;
	}
	
	public Node(E dataItem, Node<E> nodeRef) {
		data = dataItem;
		next = nodeRef;
	}
	
	public Node<E> getNext() {
		return next;
	}
	
	public void setNext(Node<E> nextNode) {
		this.next = nextNode;
	}
	
}
