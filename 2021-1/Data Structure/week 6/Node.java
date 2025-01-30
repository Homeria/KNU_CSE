package week6;

public class Node <E> {

	protected Node<E> left, right;
	protected E data;
	
	public Node() {
		left = null;
		right = null;
		data = null;
	}
	
	public Node(E n) {
		left = null;
		right = null;
		this.data = n;
	}
	
	public E getData() {
		return data;
	}
	
	public Node<E> getRight() {
		return right;
	}
	
	public Node<E> getLeft() {
		return left;
	}
	
	public void setRight(Node<E> node) {
		right = node;
	}
	
	public void setLeft(Node<E> node) {
		left = node;
	}
	
}
